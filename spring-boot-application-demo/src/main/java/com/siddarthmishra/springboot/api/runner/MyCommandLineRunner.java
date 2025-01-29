package com.siddarthmishra.springboot.api.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

	@Value("${file1.key1}")
	private String file1Key1Value;

	@Value("${ext.file1.key1}")
	private String extFile1Key1Value;

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
		System.out.println("==========START - Printing External Properties Values==========");
		System.out.println("file1.key1=" + file1Key1Value);
		System.out.println("ext.file1.key1=" + extFile1Key1Value);
		System.out.println("==========END - Printing External Properties Values==========");
	}
}
