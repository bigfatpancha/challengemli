package com.challenge.mli.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.challenge.mli.model.DistancesMessages;
import com.challenge.mli.model.Position;
import com.challenge.mli.model.Satellite;

@Service
public class SatelliteService {
	
	public Position getLocation(ArrayList<Float> distances) {
		return null;
	}
	
	public String getMessage(ArrayList<ArrayList<String>> messages) {
		return "";
	}
	
	public DistancesMessages parseSatellitesData(ArrayList<Satellite> satellitesData) {
		ArrayList<Float> distances = new ArrayList<>();
		ArrayList<ArrayList<String>> messages = new ArrayList<>();
		satellitesData.forEach((satellite) -> {
			distances.add(satellite.getDistance());
			messages.add(satellite.getMessages());
		});
		return new DistancesMessages(distances, messages);
	}
	
}
