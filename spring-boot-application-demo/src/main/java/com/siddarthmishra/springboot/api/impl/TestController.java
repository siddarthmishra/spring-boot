package com.siddarthmishra.springboot.api.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.siddarthmishra.springboot.api.entity.User;
import com.siddarthmishra.springboot.api.exception.ApplicationException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import reactor.core.publisher.Mono;


@RestController
public class TestController {

	private static final String COLON = ":";

	private static final String FORWARD_SLASH = "/";

	private static final String COLON_DOUBLE_FORWARD_SLASH = COLON + FORWARD_SLASH + FORWARD_SLASH;

	private static final String QUESTION_MARK = "?";

	private static final String DEFAULT_MSG_FORMAT = "%s %s from %s %s.";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;

	@Autowired
	@Qualifier("objectMapper")
	private ObjectMapper objectMapper;

	private Function<ClientResponse, Mono<? extends Throwable>> exceptionFunction = response -> {

		return response.createException().flatMap(webClientResponseException -> {
			ApplicationException applicationException;
			try {
				applicationException = webClientResponseException.getResponseBodyAs(ApplicationException.class);
			} catch (Throwable throwable) {
				applicationException = null;
				throwable.printStackTrace();
			}
			if (applicationException != null) {
				applicationException.setHttpStatusCode(response.statusCode());
			} else {
				/**
				 * If the response body is not of type ApplicationException or in case of any
				 * other failure
				 */
				// String message = webClientResponseException.getMessage();
				String message = String.format(DEFAULT_MSG_FORMAT, webClientResponseException.getStatusCode().value(),
						webClientResponseException.getStatusText(),
						webClientResponseException.getRequest().getMethod().toString(),
						webClientResponseException.getRequest().getURI().toString());
				applicationException = new ApplicationException(message);
				applicationException.setDetails(webClientResponseException.getResponseBodyAsString());
				applicationException.setHttpStatusCode(response.statusCode());
			}
			return Mono.just(applicationException);
		});
	};

	@GetMapping
	public String getMethodName() {
		return "Welcome!!!";
	}

	@GetMapping("/greet")
	public ResponseEntity<String> greetWithName(@RequestParam(defaultValue = "World") String name) {
		String result = "Hello " + name + "!!!";
		// Using ShallowEtagHeaderFilter bean present in FilterConfiguration.java
		return ResponseEntity.ok().body(result);
		// Without using ShallowEtagHeaderFilter bean present in FilterConfiguration.java
		// return ResponseEntity.ok().eTag(Integer.toString(result.hashCode())) .body(result);
	}

	@GetMapping("/resttemplate/greet")
	public ResponseEntity<String> greetUsingRestTemplate(HttpServletRequest httpServletRequest) {

		// request url
		String url = buildURL(httpServletRequest, "greet");
		System.out.println("Constructed URL: " + url);

		// create headers
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION, httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION));

		// create request
		HttpEntity<HttpHeaders> request = new HttpEntity<>(headers);

		// make a request
		return restTemplate.exchange(url, HttpMethod.GET, request, String.class);
	}

	private String buildURL(HttpServletRequest httpServletRequest, String remainingURI) {
		StringBuilder url = new StringBuilder();
		url.append(httpServletRequest.getScheme()).append(COLON_DOUBLE_FORWARD_SLASH)
				.append(httpServletRequest.getServerName()).append(COLON).append(httpServletRequest.getServerPort());
		if (remainingURI != null) {
			url.append(FORWARD_SLASH).append(remainingURI);
		}
		if (httpServletRequest.getQueryString() != null) {
			url.append(QUESTION_MARK);
			String decodedQueryString = decodeURL(httpServletRequest.getQueryString());
			url.append(decodedQueryString);
		}
		return url.toString();
	}

	private String decodeURL(String encodedURL) {
		// https://stackoverflow.com/questions/15235400/java-url-param-replace-20-with-space
		// https://stackoverflow.com/questions/53377692/handling-white-spaces-in-request-parameter-in-springboot
		// https://www.baeldung.com/java-url-encoding-decoding
		// https://www.baeldung.com/java-urlencoder-translate-space-characters
		try {
			return URLDecoder.decode(encodedURL, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encodedURL;
	}

	@GetMapping("/webclient/searchuser")
	public ResponseEntity<User> getUserUsingWebClient(HttpServletRequest httpServletRequest)
			throws JsonMappingException, JsonProcessingException {
		String url = buildURL(httpServletRequest, "users/search");
		String jsonResponse = webClientBuilder
				.defaultHeader(HttpHeaders.AUTHORIZATION, httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION))
				.build().get().uri(url).retrieve()
				.onStatus(HttpStatusCode::is4xxClientError, exceptionFunction)
				.onStatus(HttpStatusCode::is5xxServerError, exceptionFunction)
				//.toEntity(User.class).block(); // failing to parse "creationDate". If using this then add @JsonIgnore
				.bodyToMono(String.class).block();
		User user = objectMapper.readValue(jsonResponse, User.class);
		return ResponseEntity.ok(user);
	}

	@GetMapping("/webclient/posts/{postId}")
	public ResponseEntity<String> getPostUsingWebClient(@PathVariable Integer postId) {
		String url = new StringBuilder().append("https://json-placeholder.mock.beeceptor.com/posts/").append(postId)
				.toString();
		Optional<String> jsonResponse = webClientBuilder.build().get().uri(url).retrieve().bodyToMono(String.class)
				.blockOptional();
		return ResponseEntity.of(jsonResponse);
	}

	@PostMapping("/webclient/users")
	public ResponseEntity<Void> saveUserUsingWebClient(@RequestBody @Valid User user,
			HttpServletRequest httpServletRequest) {
		String url = buildURL(httpServletRequest, "users");
		ResponseEntity<Void> responseEntity = webClientBuilder
				.defaultHeader(HttpHeaders.AUTHORIZATION, httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION))
				.build().post().uri(url).bodyValue(user).retrieve()
				.onStatus(HttpStatusCode::is4xxClientError, exceptionFunction)
				.onStatus(HttpStatusCode::is5xxServerError, exceptionFunction)
				.toBodilessEntity().block();
		return responseEntity;
	}
}
