package com.siddarthmishra.springboot.api.runner;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=================================================================================");
		System.out.println("Inside " + MyCommandLineRunner.class.getName());
		if (args != null && args.length > 0) {
			System.out.println("Printing CommandLineRunner args");
			Arrays.stream(args).forEach(System.out::println);
		} else {
			System.out.println("CommandLineRunner arguments are empty");
		}
	}
}
