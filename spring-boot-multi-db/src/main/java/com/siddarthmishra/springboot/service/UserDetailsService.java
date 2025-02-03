package com.siddarthmishra.springboot.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.siddarthmishra.springboot.dto.UserDTO;
import com.siddarthmishra.springboot.entity.db2.UserDetails;
import com.siddarthmishra.springboot.repository.db2.UserDetailsRepository;

@Service
public class UserDetailsService {

	private UserDetailsRepository userDetailsRepository;

	public UserDetailsService(UserDetailsRepository userDetailsRepository) {
		this.userDetailsRepository = userDetailsRepository;
	}

	public Optional<UserDTO> findById(Integer userId) {
		Optional<UserDetails> userDetails = userDetailsRepository.findById(userId);
		return userDetails
				.map(user -> new UserDTO(user.getUserId(), user.getEmailId(), user.getFirstName(), user.getLastName()));
	}
}
