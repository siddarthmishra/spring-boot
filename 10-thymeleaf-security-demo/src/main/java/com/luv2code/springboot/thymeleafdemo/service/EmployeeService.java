package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	Employee findById(int id);

	void save(Employee employee);

	void deleteById(int id);
	
	List<Employee> searchBy(String theName);
}
