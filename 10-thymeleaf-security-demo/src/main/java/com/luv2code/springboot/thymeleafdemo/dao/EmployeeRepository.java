package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL

	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
	
	// add a method to sort by first name
	public List<Employee> findAllByOrderByFirstNameAsc();
	
	// search by name
	public List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);

}
