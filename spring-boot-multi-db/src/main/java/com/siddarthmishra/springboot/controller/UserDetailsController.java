package com.siddarthmishra.springboot.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siddarthmishra.springboot.dto.UserDTO;
import com.siddarthmishra.springboot.service.UserDetailsService;

@RestController
@RequestMapping("/users")
public class UserDetailsController {

	private UserDetailsService userDetailsService;

	public UserDetailsController(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> findById(@PathVariable Integer userId) {
		Optional<UserDTO> userDTO = userDetailsService.findById(userId);
		return ResponseEntity.of(userDTO);
	}

}
