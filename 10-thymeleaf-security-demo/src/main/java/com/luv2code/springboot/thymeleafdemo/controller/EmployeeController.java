package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/list")
	public String listEmployees(Model model) {

		List<Employee> employees = employeeService.findAll();

		model.addAttribute("employees", employees);

		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormToAdd(Model model) {

		Employee employee = new Employee();

		model.addAttribute("employee", employee);

		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {

		employeeService.save(employee);

		return "redirect:/employees/list";

	}

	@GetMapping("/showFormForUpdate/{employeeId}")
	public String updateEmployee(@PathVariable("employeeId") int id, Model model) {

		Employee employee = employeeService.findById(id);

		model.addAttribute("employee", employee);

		return "/employees/employee-form";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int id) {

		employeeService.deleteById(id);

		return "redirect:/employees/list";
	}

	@GetMapping("/search")
	public String delete(@RequestParam("employeeName") String theName, Model theModel) {

		// delete the employee
		List<Employee> theEmployees = employeeService.searchBy(theName);

		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		// send to /employees/list
		return "/employees/list-employees";

	}
}
