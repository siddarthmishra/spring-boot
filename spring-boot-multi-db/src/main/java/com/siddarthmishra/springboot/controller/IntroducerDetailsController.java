package com.siddarthmishra.springboot.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siddarthmishra.springboot.dto.IntroducerDTO;
import com.siddarthmishra.springboot.service.IntroducerDetailsService;

@RestController
@RequestMapping("/introducers")
public class IntroducerDetailsController {

	private IntroducerDetailsService introducerDetailsService;

	public IntroducerDetailsController(IntroducerDetailsService introducerDetailsService) {
		this.introducerDetailsService = introducerDetailsService;
	}

	@GetMapping("/{spid}")
	public ResponseEntity<IntroducerDTO> findById(@PathVariable String spid) {
		Optional<IntroducerDTO> introducerDTO = introducerDetailsService.findById(spid);
		return ResponseEntity.of(introducerDTO);
	}
}
