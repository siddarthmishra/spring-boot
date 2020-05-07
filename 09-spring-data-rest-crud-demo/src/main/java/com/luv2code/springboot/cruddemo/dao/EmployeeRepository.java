package com.luv2code.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.cruddemo.entity.Employee;

// if we want to expose a different resource name?
// instead of "/employees" (or default) to use "/members" (customized)

// @RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// that's it ... no need to write any code LOL

}
