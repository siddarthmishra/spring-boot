package com.siddarthmishra.springboot.api.interceptors;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class MyDemoInterceptor implements HandlerInterceptor {

	// Request is intercepted by this method before reaching the Controller.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/**
		 * Business logic just when the request is received and intercepted by this
		 * interceptor before reaching the controller.
		 */
		System.out.println("MyDemoInterceptor - preHandle");
		System.out.println("MyDemoInterceptor - preHandle - Method Type: " + request.getMethod());
		System.out.println("MyDemoInterceptor - preHandle - Request URI: " + request.getRequestURI());
		System.out.println("MyDemoInterceptor - preHandle - Servlet Path: " + request.getServletPath());
		System.out.println("MyDemoInterceptor - preHandle - Handler: " + handler.getClass().getName());
		// check which controller method is requested
		if (handler instanceof HandlerMethod handlerMethod) {
			// can be added different logics
			Class<?> controllerClass = handlerMethod.getBeanType();
			String methodName = handlerMethod.getMethod().getName();
			System.out.println("MyDemoInterceptor - preHandle - Controller name: " + controllerClass.getName());
			System.out.println("MyDemoInterceptor - preHandle - Method name: " + methodName);
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	// Response is intercepted by this method before reaching the client.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		/**
		 * Business logic just before the response reaches the client and the request is
		 * served.
		 */
		System.out.println("MyDemoInterceptor - postHandle START");
		System.out.println(
				"MyDemoInterceptor - postHandle - HTTP Response : " + HttpStatusCode.valueOf(response.getStatus()));
		System.out.println("MyDemoInterceptor - postHandle END");
	}

	// This method is called after request & response HTTP communication is done.
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// Business logic after request and response is Completed
		System.out.println("MyDemoInterceptor - afterCompletion START");
		if (ex != null) {
			// exception handle part
			System.out.println("MyDemoInterceptor - afterCompletion - An error occured. " + ex);
		} else {
			System.out.println("MyDemoInterceptor - afterCompletion - SUCCESS");
		}
		System.out.println("MyDemoInterceptor - afterCompletion END");
	}

}
