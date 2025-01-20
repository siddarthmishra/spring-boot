package com.siddarthmishra.springboot.api.filters;

import java.io.IOException;

import org.springframework.http.HttpStatusCode;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Bean Creation and Registration moved to FilterConfiguration.java
// @Component
public class MyDemoFilter implements Filter {

	// default method. Not mandatory to override
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("MyDemoFilter - init() method has been get invoked");
		System.out.println("MyDemoFilter - Filter name is " + filterConfig.getFilterName());
		System.out.println("MyDemoFilter - ServletContext name is" + filterConfig.getServletContext());
		System.out.println("MyDemoFilter - init() method is ended");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("MyDemoFilter - doFilter() method is invoked");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		// Intercept (and manipulate if required) HTTP Request before it reaches the Servlet (Controller).
		System.out.println("MyDemoFilter - Remote Host : " + httpServletRequest.getRemoteHost());
		System.out.println("MyDemoFilter - Remote Address : " + httpServletRequest.getRemoteAddr());
		chain.doFilter(httpServletRequest, httpServletResponse);
		// Intercept (and manipulate if required) HTTP Response after Servlet (Controller) has processed.
		System.out.println("MyDemoFilter - HTTP Response : " + HttpStatusCode.valueOf(httpServletResponse.getStatus()));
		System.out.println("MyDemoFilter - doFilter() method is ended");
	}

	// default method. Not mandatory to override
	@Override
	public void destroy() {
		System.out.println("MyDemoFilter - destroy() method is invoked");
	}

}
