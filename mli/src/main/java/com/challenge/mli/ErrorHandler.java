package com.challenge.mli;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.challenge.mli.exceptions.MessageNotFoundException;
import com.challenge.mli.exceptions.PositionNotFoundException;

@ControllerAdvice
public class ErrorHandler {
	
	@ResponseBody
	@ExceptionHandler(PositionNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String positoinNotFoundHandler(PositionNotFoundException ex) {
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(MessageNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String positionNotFoundHandler(MessageNotFoundException ex) {
		return ex.getMessage();
	}

}
