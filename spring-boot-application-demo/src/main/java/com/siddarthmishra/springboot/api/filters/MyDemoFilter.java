package com.siddarthmishra.springboot.api.filters;

import java.io.IOException;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatusCode;

import com.siddarthmishra.springboot.api.httpservletrequestwrapper.HttpServletFilteredRequest;

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

	private static final String NAME_REQ_PARAM = "name";

	// default method. Not mandatory to override
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("MyDemoFilter - init() method - START");
		System.out.println("MyDemoFilter - Filter name is " + filterConfig.getFilterName());
		System.out.println("MyDemoFilter - ServletContext name is" + filterConfig.getServletContext());
		System.out.println("MyDemoFilter - init() method - END");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("MyDemoFilter - doFilter() - START");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		/**
		 * Intercept (and manipulate if required) HTTP Request before it reaches the
		 * Servlet (Controller).
		 */
		System.out.println("MyDemoFilter - Method Type: " + httpServletRequest.getMethod());
		System.out.println("MyDemoFilter - Request URI: " + httpServletRequest.getRequestURI());
		// Manipulating the request
		HttpServletFilteredRequest filteredRequest = new HttpServletFilteredRequest(httpServletRequest, null);
		modifyNameRequestParameter(filteredRequest);
		// Pass the filteredRequest along the chain
		chain.doFilter(filteredRequest, httpServletResponse);
		/**
		 * Intercept (and manipulate if required) HTTP Response after Servlet
		 * (Controller) has processed.
		 */
		System.out.println("MyDemoFilter - HTTP Response : " + HttpStatusCode.valueOf(httpServletResponse.getStatus()));
		System.out.println("MyDemoFilter - doFilter() method - END");
	}

	private void modifyNameRequestParameter(HttpServletFilteredRequest filteredRequest) {
		if (!filteredRequest.containsKey(NAME_REQ_PARAM)) {
			return;
		}
		String nameValue = filteredRequest.getParameter(NAME_REQ_PARAM);
		if (nameValue == null || nameValue.trim().length() == 0) {
			filteredRequest.removeParameter(NAME_REQ_PARAM);
		} else {
			Function<Character, String> reverseCase = ch -> !Character.isAlphabetic(ch) ? Character.toString(ch)
					: Character.isLowerCase(ch) ? Character.toString(Character.toUpperCase(ch))
							: Character.toString(Character.toLowerCase(ch));
			String result = nameValue.chars().mapToObj(i -> (char) i).map(reverseCase).collect(Collectors.joining());
			filteredRequest.addParameter(NAME_REQ_PARAM, result);
		}
	}

	// default method. Not mandatory to override
	@Override
	public void destroy() {
		System.out.println("MyDemoFilter - destroy() method invoked");
	}

}
