package com.siddarthmishra.springboot.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddarthmishra.springboot.api.entity.IntroducerActivityDetails;
import com.siddarthmishra.springboot.api.repository.IntroducerActivityRepository;

@Service
public class IntroducerActivityService {

	@Autowired
	private IntroducerActivityRepository introducerActivityRepository;

	public IntroducerActivityDetails getIntroducerActivityById(String submissionId) {
		return introducerActivityRepository.getReferenceById(submissionId);
	}

	public List<IntroducerActivityDetails> findBySpid(String spid) {
		return introducerActivityRepository.findBySpid(spid);
	}
}
