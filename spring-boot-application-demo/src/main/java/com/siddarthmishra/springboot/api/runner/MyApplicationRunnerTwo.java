package com.siddarthmishra.springboot.api.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.siddarthmishra.springboot.api.dto.PersonDTO;

@Component
@Order(2)
public class MyApplicationRunnerTwo implements ApplicationRunner {

	@Autowired
	private PersonDTO person2;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("=================================================================================");
		System.out.println("Inside " + MyApplicationRunnerTwo.class.getName());
		if (args.getOptionNames() != null && !args.getOptionNames().isEmpty()) {
			System.out.println("Printing ApplicationArguments Optional Names");
			args.getOptionNames().stream().forEach(System.out::println);
		} else {
			System.out.println("Optional Names are empty");
		}

		System.out.println("Person : " + person2);
	}
}
