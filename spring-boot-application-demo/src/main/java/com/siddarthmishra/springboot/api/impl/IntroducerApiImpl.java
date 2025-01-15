package com.siddarthmishra.springboot.api.impl;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.siddarthmishra.springboot.api.entity.IntroducerDetails;
import com.siddarthmishra.springboot.api.service.IntroducerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

@RestController
@RequestMapping(path = "introducers")
public class IntroducerApiImpl {

	@Autowired
	private IntroducerService introducerService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IntroducerDetails> getIntroducerById(@PathVariable(name = "id") @Size(min = 3) String spid) {
		IntroducerDetails introducerDetails = introducerService.getIntroducerById(spid);
		return ResponseEntity.ok(introducerDetails);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity saveIntroducer(@RequestBody @Valid IntroducerDetails introducerDetails,
			HttpServletRequest httpServletRequest) {
		IntroducerDetails createdIntroducerDetails = introducerService.saveIntroducer(introducerDetails);
		StringBuilder uri = new StringBuilder(httpServletRequest.getRequestURI()).append(CommonConstants.FORWARD_SLASH)
				.append(createdIntroducerDetails.getSpid());
		return ResponseEntity.created(URI.create(uri.toString())).build();
	}

	// http://localhost:8081/introducers?expiryFrom=20240701&expiryTo=20240929&pageNumber=1&pageSize=3&orderByExpiry=desc
	// http://localhost:8081/introducers?pageNumber=0&pageSize=3
	// http://localhost:8081/introducers
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<IntroducerDetails>> findAllIntroducers(@RequestParam(required = false) String expiryFrom,
			@RequestParam(required = false) String expiryTo,
			@RequestParam(defaultValue = "${introducer.default.page-number}") Integer pageNumber,
			@RequestParam(defaultValue = "${introducer.default.page-size}") Integer pageSize,
			@RequestParam(defaultValue = "${introducer.default.sort-by}") String orderByExpiry) {
		List<IntroducerDetails> allIntroducers;
		allIntroducers = introducerService.findAllIntroducers(expiryFrom, expiryTo, pageNumber, pageSize,
				orderByExpiry);
		return ResponseEntity.ok(allIntroducers);
	}
}
