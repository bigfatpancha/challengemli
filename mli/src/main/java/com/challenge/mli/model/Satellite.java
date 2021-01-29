package com.challenge.mli.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Satellite {
	
	private @Id String name;
	@Column
    @ElementCollection(targetClass=String.class)
	private List<String> message;
	private Double distance;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getMessage() {
		return message;
	}
	public void setMessage(List<String> messages) {
		this.message = messages;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}

	

}
