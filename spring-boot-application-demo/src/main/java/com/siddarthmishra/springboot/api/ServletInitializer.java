package com.siddarthmishra.springboot.api;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * The SpringServletContainerInitializer class has an @HandlesTypes annotation
 * with a value of WebApplicationInitializer. This means that the Servlet
 * container will scan for classes implementing the WebApplicationInitializer
 * interface and call the onStartUp() method in these classes.
 * https://howtodoinjava.com/spring-boot/spring-boot-servletinitializer/
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootApplicationDemo.class);
	}

}
