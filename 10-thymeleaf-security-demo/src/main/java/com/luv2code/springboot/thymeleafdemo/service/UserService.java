package com.luv2code.springboot.thymeleafdemo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.luv2code.springboot.thymeleafdemo.entity.User;
import com.luv2code.springboot.thymeleafdemo.formobject.RegisterUser;

public interface UserService extends UserDetailsService {

	User findByUserName(String username);

	void save(RegisterUser registerUser);

}
