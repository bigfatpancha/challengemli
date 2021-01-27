package com.challenge.mli.model;

public class Source {

	private Position position;
	private String message;

	public Source(Position position, String message) {
		this.position = position;
		this.message = message;
	}

	public Position getPosition() {
		return position;
	}

	public String getMessage() {
		return message;
	}


}
