package com.challenge.mli.model;

import java.util.ArrayList;

public class Satellite {
	
	private String name;
	private ArrayList<String> messages;
	private Double distance;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getMessages() {
		return messages;
	}
	public void setMessages(ArrayList<String> messages) {
		this.messages = messages;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}

	

}
