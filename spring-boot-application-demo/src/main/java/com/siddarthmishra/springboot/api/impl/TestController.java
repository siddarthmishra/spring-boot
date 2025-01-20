package com.siddarthmishra.springboot.api.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

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
}
