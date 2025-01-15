package com.siddarthmishra.springboot.api.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping
	public String getMethodName() {
		return "Welcome!!!";
	}
}
