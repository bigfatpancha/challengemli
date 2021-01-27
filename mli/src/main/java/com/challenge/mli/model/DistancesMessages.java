package com.challenge.mli.model;

import java.util.ArrayList;

public class DistancesMessages {
	
	private ArrayList<Float> distances;
	private ArrayList<ArrayList<String>> messages;
	
	
	
	public DistancesMessages(ArrayList<Float> distances, ArrayList<ArrayList<String>> messages) {
		this.distances = distances;
		this.messages = messages;
	}

	public ArrayList<Float> getDistances() {
		return distances;
	}
	
	public ArrayList<ArrayList<String>> getMessages() {
		return messages;
	}
	
}
