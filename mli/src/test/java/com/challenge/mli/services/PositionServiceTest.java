package com.challenge.mli.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.mli.model.Position;

@SpringBootTest
public class PositionServiceTest {
	
	private PositionService service = new PositionService();
	private List<Double> distances = new ArrayList<Double>();
	
	/**
	 * 
	 * "distance": 500.0,
	 * "distance": 282.8427124746,
	 * "distance": 600.0,
	 */
	@BeforeEach
	public void init() {
		distances.add(Double.valueOf(500));
		distances.add(Double.valueOf(282.842712476));
		distances.add(Double.valueOf(600));
	}
	
	@Test
	public void getPosition() {
		Position source = service.getLocation(distances);
		Position pos = new Position(Double.valueOf(-100), Double.valueOf(100));
		assertEquals(pos, source);
	}

}
