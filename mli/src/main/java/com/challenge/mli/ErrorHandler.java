package com.challenge.mli;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.challenge.mli.exceptions.PositionNotFoundException;

@ControllerAdvice
public class ErrorHandler {
	
	@ResponseBody
	@ExceptionHandler(PositionNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(PositionNotFoundException ex) {
		return ex.getMessage();
	}

}
