package com.siddarthmishra.springboot.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${server.port}")
	private String serverPort;

	@Value("${spring.security.user.name}")
	private String username;

	@Value("${spring.security.user.password}")
	private String password;

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
	public ResponseEntity<String> greetUsingRestTemplate(@RequestParam(required = false) String name) {

		// request url
		String url;
		if (name != null) {
			url = "http://localhost:" + serverPort + "/greet?name=" + name;
		} else {
			url = "http://localhost:" + serverPort + "/greet";
		}

		// create headers
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth(username, password);

		// create request
		HttpEntity<HttpHeaders> request = new HttpEntity<>(headers);

		// make a request
		return restTemplate.exchange(url, HttpMethod.GET, request, String.class);
	}
}
