package com.luv2code.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUserName(String username);

}
