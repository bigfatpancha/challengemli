package com.challenge.mli;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.mli.model.DistancesMessages;
import com.challenge.mli.model.Position;
import com.challenge.mli.model.Satellite;
import com.challenge.mli.model.Source;
import com.challenge.mli.services.SatelliteService;

@RestController
public class SatelliteController {
	
	@Autowired SatelliteService satelliteService;

	@PostMapping("/topsecret")
	@ResponseBody
	Source postTopsecret(@RequestBody ArrayList<Satellite> satellites) {
		DistancesMessages distancesMessages = this.satelliteService.parseSatellitesData(satellites);
		
		Position sourcePosition = this.satelliteService.getLocation(distancesMessages.getDistances());
		String message = this.satelliteService.getMessage(distancesMessages.getMessages());
		
		return new Source(sourcePosition, message);
	}
	
	@PostMapping("/topsecret_split/{satellite_name}")
	@ResponseBody
	String postTopsecretSplit(@RequestBody Satellite satellite) {
		// TODO persistir la informacion
		return "";
	}
	
	@GetMapping("/topsecret_split/")
	@ResponseBody
	Source getTopsecretSplit() {
		ArrayList<Float> distances = null; // TODO obtener la informacion persistida
		ArrayList<ArrayList<String>> messages = null; // TODO obtener la informacion persistida
		
		Position sourcePosition = this.satelliteService.getLocation(distances);
		String message = this.satelliteService.getMessage(messages);
		
		return new Source(sourcePosition, message);
	}

}
