package com.challenge.mli.exceptions;

public class PositionNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4299375777158311351L;
	private String message;

	public PositionNotFoundException(String message) {
		super();
		this.message = message;
	}

}
