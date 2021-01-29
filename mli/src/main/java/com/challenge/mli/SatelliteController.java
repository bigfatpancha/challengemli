package com.challenge.mli;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.mli.model.DistancesMessages;
import com.challenge.mli.model.Position;
import com.challenge.mli.model.Satellite;
import com.challenge.mli.model.SatelliteRequest;
import com.challenge.mli.model.Source;
import com.challenge.mli.services.MessagesService;
import com.challenge.mli.services.PositionService;

@RestController
public class SatelliteController {
	
	@Autowired PositionService satelliteService;
	@Autowired MessagesService messagesService;

	@PostMapping("/topsecret")
	@ResponseBody
	Source postTopsecret(@RequestBody SatelliteRequest satellitesReq) {
		DistancesMessages distancesMessages = parseSatellitesData(satellitesReq.getSatellites());
		
		Position sourcePosition = this.satelliteService.getLocation(distancesMessages.getDistances());
		String message = this.messagesService.getMessage(distancesMessages.getMessages());
		
		return new Source(sourcePosition, message);
	}
	
	@PostMapping("/topsecret_split/{satellite_name}")
	@ResponseBody
	String postTopsecretSplit(@PathVariable String satellite_name, @RequestBody Satellite satellite) {
		// TODO persistir la informacion
		return "";
	}
	
	@GetMapping("/topsecret_split/")
	@ResponseBody
	Source getTopsecretSplit() {
		List<Double> distances = null; // TODO obtener la informacion persistida
		List<List<String>> messages = null; // TODO obtener la informacion persistida
		
		Position sourcePosition = this.satelliteService.getLocation(distances);
		String message = this.messagesService.getMessage(messages);
		
		return new Source(sourcePosition, message);
	}
	
	private DistancesMessages parseSatellitesData(ArrayList<Satellite> satellitesData) {
		List<Double> distances = new ArrayList<>();
		List<List<String>> messages = new ArrayList<>();
		satellitesData.forEach((satellite) -> {
			distances.add(satellite.getDistance());
			messages.add(satellite.getMessage());
		});
		return new DistancesMessages(distances, messages);
	}

}
