package com.siddarthmishra.springboot.api.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	@Autowired
	HandlerInterceptor myDemoInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// registry.addInterceptor(myDemoInterceptor);
		// registry.addInterceptor(myDemoInterceptor).addPathPatterns("/introducer/*");
		registry.addInterceptor(myDemoInterceptor).addPathPatterns("/greet");
	}
}
