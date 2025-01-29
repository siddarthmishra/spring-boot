package com.siddarthmishra.springboot.api.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class MyApplicationRunnerTwo implements ApplicationRunner {

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
	}
}
