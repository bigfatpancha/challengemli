package com.challenge.mli.model;

import java.util.ArrayList;

public class DistancesMessages {
	
	private ArrayList<Double> distances;
	private ArrayList<ArrayList<String>> messages;
	
	public DistancesMessages(ArrayList<Double> distances, ArrayList<ArrayList<String>> messages) {
		this.distances = distances;
		this.messages = messages;
	}

	public ArrayList<Double> getDistances() {
		return distances;
	}
	
	public ArrayList<ArrayList<String>> getMessages() {
		return messages;
	}
	
}
