package com.siddarthmishra.springboot.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siddarthmishra.springboot.api.entity.User;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, Integer> {

	public Optional<User> findByEmailId(String emailId);
}
