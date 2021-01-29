package com.challenge.mli.model;

import java.util.List;

public class DistancesMessages {
	
	private List<Double> distances;
	private List<List<String>> messages;
	
	public DistancesMessages(List<Double> distances, List<List<String>> messages) {
		this.distances = distances;
		this.messages = messages;
	}

	public List<Double> getDistances() {
		return distances;
	}
	
	public List<List<String>> getMessages() {
		return messages;
	}
	
}
