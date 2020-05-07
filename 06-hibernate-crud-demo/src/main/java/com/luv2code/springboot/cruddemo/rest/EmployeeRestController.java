package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	// inject EmployeeService
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {

		Employee employee = employeeService.findById(employeeId);
		if (employee == null) {
			throw new RuntimeException("Employee id not found : " + employeeId);
		}
		return employee;
	}

	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {

		employee.setId(0);

		employeeService.saveEmployee(employee);

		return employee;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {

		Employee searchEmployee = employeeService.findById(employee.getId());
		if (searchEmployee == null) {
			throw new RuntimeException("Update Operation Failed. Employee id not found : " + employee.getId());
		}
		employeeService.saveEmployee(employee);

		return employee;
	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteById(@PathVariable int employeeId) {

		Employee searchEmployee = employeeService.findById(employeeId);
		if (searchEmployee == null) {
			throw new RuntimeException("Delete Operation Failed. Employee id not found : " + employeeId);
		}
		employeeService.deleteById(employeeId);

		return "Successfully Deleted Employee with Id : " + employeeId;
	}
}
