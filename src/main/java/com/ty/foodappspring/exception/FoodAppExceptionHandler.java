package com.ty.foodappspring.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class FoodAppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoIdFoundException.class)
	public ResponseEntity<String> handle1(NoIdFoundException noid) {
		String st1 = noid.getMessage();
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(st1, HttpStatus.NOT_FOUND);
		return responseEntity;

	}
}