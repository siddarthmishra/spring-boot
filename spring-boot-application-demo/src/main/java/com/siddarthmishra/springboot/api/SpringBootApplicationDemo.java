package com.siddarthmishra.springboot.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.siddarthmishra.springboot.api.repository" })
@EntityScan(basePackages = { "com.siddarthmishra.springboot.api.entity" })
public class SpringBootApplicationDemo {

	public static void main(String[] args) {
		// SpringApplication.run(JpaDemoApplication.class, args);
		SpringApplication springApplication = new SpringApplication(SpringBootApplicationDemo.class);
		// springApplication.setBannerMode(Mode.OFF);
		springApplication.run(args);
	}
}
