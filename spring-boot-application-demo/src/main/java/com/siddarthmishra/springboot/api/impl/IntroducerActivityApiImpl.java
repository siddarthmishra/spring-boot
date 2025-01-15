package com.siddarthmishra.springboot.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siddarthmishra.springboot.api.entity.IntroducerActivityDetails;
import com.siddarthmishra.springboot.api.service.IntroducerActivityService;

@RestController
@RequestMapping(path = "introducer-activity")
public class IntroducerActivityApiImpl {

	@Autowired
	private IntroducerActivityService introducerActivityService;

	@GetMapping(path = "{submissionId}")
	public ResponseEntity<IntroducerActivityDetails> getIntroducerActivityById(@PathVariable String submissionId) {
		IntroducerActivityDetails introducerActivityDetails = introducerActivityService
				.getIntroducerActivityById(submissionId);
		return ResponseEntity.ok(introducerActivityDetails);
	}

	@GetMapping("/introducer/{spid}")
	public ResponseEntity<List<IntroducerActivityDetails>> fetchBySpid(@PathVariable String spid) {
		List<IntroducerActivityDetails> introducerActivityList;
		introducerActivityList = introducerActivityService.findBySpid(spid);
		return ResponseEntity.ok(introducerActivityList);
	}

}
