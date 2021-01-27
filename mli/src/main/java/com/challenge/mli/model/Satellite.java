package com.challenge.mli.model;

import java.util.ArrayList;

public class Satellite {
	
	private String name;
	private ArrayList<String> messages;
	private Float distance;
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
	public Float getDistance() {
		return distance;
	}
	public void setDistance(Float distance) {
		this.distance = distance;
	}

	

}
