package com.siddarthmishra.springboot.api.exception.handler;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.siddarthmishra.springboot.api.exception.ApplicationException;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = { ApplicationException.class })
	public ResponseEntity<Error> handleApplicationException(ApplicationException exception) {
		Error error = new Error().setMessage(exception.getMessage()).setErrorCode(exception.getErrorCode()).setDetails(
				exception.getDetails() == null ? Arrays.toString(exception.getStackTrace()) : exception.getDetails());
		return new ResponseEntity<>(error, exception.getHttpStatusCode());
	}

	@ExceptionHandler(value = { EntityNotFoundException.class })
	public ResponseEntity<Error> handleEntityNotFoundException(EntityNotFoundException exception) {
		Error error = new Error().setMessage(exception.getMessage())
				.setErrorCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
