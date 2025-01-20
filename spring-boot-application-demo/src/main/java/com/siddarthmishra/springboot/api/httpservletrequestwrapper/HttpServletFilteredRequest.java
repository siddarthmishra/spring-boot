package com.siddarthmishra.springboot.api.httpservletrequestwrapper;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

/**
 * An example HttpServletRequestWrapper that allows you to modify or add request
 * parameters before being processed by the Servlet.
 */
public class HttpServletFilteredRequest extends HttpServletRequestWrapper {

	private Map<String, String[]> filteredParameters;

	public HttpServletFilteredRequest(HttpServletRequest request, Map<String, String[]> additionalParameters) {
		super(request);
		filteredParameters = new HashMap<>();
		if (request.getParameterMap() != null && !request.getParameterMap().isEmpty()) {
			filteredParameters.putAll(request.getParameterMap());
		}
		if (additionalParameters != null && !additionalParameters.isEmpty()) {
			filteredParameters.putAll(additionalParameters);
		}
	}

	@Override
	public String getParameter(String name) {
		String[] values = filteredParameters.get(name);
		if (values != null && values.length > 0)
			return values[0];
		return null;
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return Collections.unmodifiableMap(filteredParameters);
	}

	@Override
	public Enumeration<String> getParameterNames() {
		return Collections.enumeration(filteredParameters.keySet());
	}

	@Override
	public String[] getParameterValues(String name) {
		return filteredParameters.get(name);
	}

	public void addParameter(String key, String[] valueArray) {
		filteredParameters.put(key, valueArray);
	}

	public void addParameter(String key, String value) {
		filteredParameters.put(key, new String[] { value });
	}

	public void removeParameter(String key) {
		filteredParameters.remove(key);
	}

	public boolean containsKey(String key) {
		return filteredParameters.containsKey(key);
	}
}
