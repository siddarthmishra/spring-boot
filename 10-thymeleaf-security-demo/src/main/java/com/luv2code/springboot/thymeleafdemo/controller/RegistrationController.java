package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleafdemo.entity.User;
import com.luv2code.springboot.thymeleafdemo.formobject.RegisterUser;
import com.luv2code.springboot.thymeleafdemo.service.UserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private UserService userService;

	private Logger logger = Logger.getLogger(getClass().getName());

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/showRegistrationForm")
	public String showMyLoginPage(Model theModel) {

		theModel.addAttribute("registerUser", new RegisterUser());

		return "employees/registration-form";
	}

	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(@Valid @ModelAttribute("registerUser") RegisterUser registerUser,
			BindingResult theBindingResult, Model theModel) {

		String userName = registerUser.getUserName().toLowerCase();
		logger.info("Processing registration form for: " + userName);

		// form validation
		if (theBindingResult.hasErrors()) {
			return "employees/registration-form";
		}

		// check the database if user already exists
		User existing = userService.findByUserName(userName);
		if (existing != null) {
			theModel.addAttribute("registerUser", new RegisterUser());
			theModel.addAttribute("registrationError", "User name already exists.");

			logger.warning("User name already exists.");
			return "employees/registration-form";
		}

		// create user account
		userService.save(registerUser);

		logger.info("Successfully created user: " + userName);

		return "employees/registration-confirmation";
	}
}
