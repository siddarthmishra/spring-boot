package com.siddarthmishra.springboot.api.impl;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siddarthmishra.springboot.api.constants.CommonConstants;
import com.siddarthmishra.springboot.api.entity.User;
import com.siddarthmishra.springboot.api.service.UserDetailsService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserDetailsController {

	private UserDetailsService userDetailsService;

	public UserDetailsController(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> registerUserAndSendEmail(@RequestBody @Valid User user,
			HttpServletRequest httpServletRequest) {
		long t1 = System.currentTimeMillis();
		// Simulate the time required for user registration.
		User registeredUser = userDetailsService.registerUser(user);
		// Registration is successful.
		StringBuilder uri = new StringBuilder(httpServletRequest.getRequestURI()).append(CommonConstants.FORWARD_SLASH)
				.append(registeredUser.getUserId());
		ResponseEntity<User> responseEntity = ResponseEntity.created(URI.create(uri.toString())).build();
		long t2 = System.currentTimeMillis();
		System.out.println("Registering a user took " + (t2 - t1) + " ms");
		return responseEntity;
	}

	@GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
		Optional<User> user = userDetailsService.findByUserId(userId);
		return ResponseEntity.of(user);
	}

	@GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> search(@RequestParam(required = false) String emailId,
			@RequestParam(required = false) Integer userId) {
		Optional<User> user = userDetailsService.search(emailId, userId);
		return ResponseEntity.of(user);
	}
}
