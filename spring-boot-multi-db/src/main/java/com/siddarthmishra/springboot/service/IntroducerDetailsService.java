package com.siddarthmishra.springboot.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.siddarthmishra.springboot.dto.IntroducerDTO;
import com.siddarthmishra.springboot.entity.db1.IntroducerDetails;
import com.siddarthmishra.springboot.repository.db1.IntroducerDetailsRepository;

@Service
public class IntroducerDetailsService {

	private IntroducerDetailsRepository introducerDetailsRepository;

	public IntroducerDetailsService(IntroducerDetailsRepository introducerDetailsRepository) {
		this.introducerDetailsRepository = introducerDetailsRepository;
	}

	public Optional<IntroducerDTO> findById(String spid) {
		Optional<IntroducerDetails> introducerDetails = introducerDetailsRepository.findById(spid);
		return introducerDetails.map(introducer -> new IntroducerDTO(introducer.getSpid(), introducer.getPartyId(),
				introducer.getEffectiveDate(), introducer.getExpiryDate()));
	}
}
