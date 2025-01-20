package com.siddarthmishra.springboot.api.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import com.siddarthmishra.springboot.api.filters.MyDemoFilter;

@Configuration
public class FilterConfiguration {

	// Caching using ETag (Entity Tag)
	// https://medium.com/@reetesh043/understanding-and-implementing-etags-in-rest-apis-659abe0f91ab
	@Bean
	ShallowEtagHeaderFilter shallowEtagHeaderFilter() {
		return new ShallowEtagHeaderFilter();
	}

	@Bean
	FilterRegistrationBean<MyDemoFilter> registerMyDemoFilter() {
		final MyDemoFilter myDemoFilter = new MyDemoFilter();
		final FilterRegistrationBean<MyDemoFilter> myDemoFilterRegister = new FilterRegistrationBean<>(myDemoFilter);
		// Defines the URL pattern for which this filter will be registered against.
		// myDemoFilterRegister.addUrlPatterns("/*"); // All
		myDemoFilterRegister.addUrlPatterns("/introducers/*");
		return myDemoFilterRegister;
	}
}
