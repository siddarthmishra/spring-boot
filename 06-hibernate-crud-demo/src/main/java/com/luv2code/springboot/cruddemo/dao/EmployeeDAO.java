package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

	List<Employee> findAll();

	Employee findById(int id);

	void saveEmployee(Employee employee);

	void deleteById(int id);
}
