package com.challenge.mli.exceptions;

public class MessageNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7902327659102712558L;
	private String message;

	public MessageNotFoundException(String message) {
		super();
		this.message = message;
	}
}
