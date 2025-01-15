package com.siddarthmishra.springboot.api.exception;

import org.springframework.http.HttpStatusCode;

public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = -1958687932363380535L;

	private String details;
	private String errorCode;
	private HttpStatusCode httpStatusCode;

	public ApplicationException() {
		// default constructor
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(String message, String errorCode, HttpStatusCode httpStatusCode, String details) {
		this(message);
		this.errorCode = errorCode;
		this.httpStatusCode = httpStatusCode;
		this.details = details;
	}

	public String getDetails() {
		return details;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public HttpStatusCode getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void setHttpStatusCode(HttpStatusCode httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
}
