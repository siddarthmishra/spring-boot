package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	Employee findById(int id);

	void saveEmployee(Employee employee);

	void deleteById(int id);
	
	String getSysdate();
}
