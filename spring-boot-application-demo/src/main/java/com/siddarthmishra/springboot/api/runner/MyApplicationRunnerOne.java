package com.siddarthmishra.springboot.api.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyApplicationRunnerOne implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("=================================================================================");
		System.out.println("Inside " + MyApplicationRunnerOne.class.getName());
		if (args.getNonOptionArgs() != null && !args.getNonOptionArgs().isEmpty()) {
			System.out.println("Printing ApplicationArguments Non Optional Args");
			args.getNonOptionArgs().stream().forEach(System.out::println);
		} else {
			System.out.println("Non Optional Args are empty");
		}
	}
}
