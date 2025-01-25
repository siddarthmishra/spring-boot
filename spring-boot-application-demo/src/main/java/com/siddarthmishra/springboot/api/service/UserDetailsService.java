package com.siddarthmishra.springboot.api.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.siddarthmishra.springboot.api.constants.ErrorConstants;
import com.siddarthmishra.springboot.api.entity.User;
import com.siddarthmishra.springboot.api.exception.ApplicationException;
import com.siddarthmishra.springboot.api.repository.UserDetailsRepository;
import com.siddarthmishra.springboot.api.validation.RequestValidator;

@Service
public class UserDetailsService {

	private UserDetailsRepository userDetailsRepository;

	public UserDetailsService(UserDetailsRepository userDetailsRepository) {
		this.userDetailsRepository = userDetailsRepository;
	}

	public User registerUser(User user) {
		Optional<User> registeredUser = findByEmailId(user.getEmailId());
		if (registeredUser.isPresent()) {
			String message = String.format(ErrorConstants.EMAIL_ID_REGISTERED_MSG_001_FORMAT, user.getEmailId());
			throw new ApplicationException(message, ErrorConstants.EMAIL_ID_REGISTERED_CD_001, HttpStatus.BAD_REQUEST,
					null);
		}
		user.setEmailId(user.getEmailId().toLowerCase());
		user.setUserId(null);
		user.setCreationDate(LocalDateTime.now());
		return userDetailsRepository.saveAndFlush(user);
	}

	public Optional<User> findByUserId(Integer userId) {
		return userDetailsRepository.findById(userId);
	}

	private Optional<User> findByEmailId(String emailId) {
		return userDetailsRepository.findByEmailId(emailId.toLowerCase());
	}

	public Optional<User> search(String emailId, Integer userId) {
		Optional<User> user = Optional.empty();
		boolean isAnyRequestParamValid = false;
		if (RequestValidator.isValidUserSearchEmailId(emailId)) {
			isAnyRequestParamValid = true;
			user = findByEmailId(emailId);
		}
		if (user.isEmpty() && RequestValidator.isValidUserSearchUserId(userId)) {
			isAnyRequestParamValid = true;
			user = findByUserId(userId);
		}
		if (!isAnyRequestParamValid) {
			throw new ApplicationException(ErrorConstants.REQ_PARAM_USER_SEARCH_MSG_001,
					ErrorConstants.REQ_PARAM_USER_SEARCH_CD_001, HttpStatus.BAD_REQUEST, null);
		}
		return user;
	}
}
