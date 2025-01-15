package com.siddarthmishra.springboot.api.exception.handler;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(value = { "errorCode", "message", "details" })
public class Error implements Serializable {

	private static final long serialVersionUID = 1735118540898770534L;

	private String details;
	private String errorCode;
	private String message;

	public String getDetails() {
		return details;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

	public Error setDetails(String details) {
		this.details = details;
		return this;
	}

	public Error setErrorCode(String errorCode) {
		this.errorCode = errorCode;
		return this;
	}

	public Error setMessage(String message) {
		this.message = message;
		return this;
	}

}
