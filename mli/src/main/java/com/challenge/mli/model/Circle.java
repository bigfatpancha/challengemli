package com.challenge.mli.model;

public class Circle {
	
	private Position center;
	private Double radius;
	
	public Circle(Position center, Double radius) {
		super();
		this.center = center;
		this.radius = radius;
	}

	public Position getCenter() {
		return center;
	}

	public Double getRadius() {
		return radius;
	}

	
}
