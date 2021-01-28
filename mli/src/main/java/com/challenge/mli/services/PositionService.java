package com.challenge.mli.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.challenge.mli.exceptions.PositionNotFoundException;
import com.challenge.mli.model.Circle;
import com.challenge.mli.model.Position;

@Service
public class PositionService {
	
	private Position kenobiPosition = new Position(Double.valueOf(-500), Double.valueOf(-200));
	private Position skywalkerPosition = new Position(Double.valueOf(100), Double.valueOf(-100));
	private Position satoPosition = new Position(Double.valueOf(500), Double.valueOf(100));
	
	public Position getLocation(ArrayList<Double> distances) throws PositionNotFoundException {
		
		if (distances.size() != 3) {
			throw new PositionNotFoundException("Three satellites are needed to find source position");
		}
		Map<String, Circle> distanceCircles = new HashMap<>();
		distanceCircles.put("kenobi", new Circle(this.kenobiPosition, distances.get(0)));
		distanceCircles.put("skywalker", new Circle(this.skywalkerPosition, distances.get(1)));
		distanceCircles.put("sato", new Circle(this.satoPosition, distances.get(2)));
		
		ArrayList<Position> firstIntersection = twoCirclesIntersection(distanceCircles.get("kenobi"), distanceCircles.get("skywalker"));
		ArrayList<Position> secondIntersection = twoCirclesIntersection(distanceCircles.get("kenobi"), distanceCircles.get("sato"));
		
		return findIntersectionPoint(firstIntersection, secondIntersection);
	}
	
	
	/**
	 * 
	 * @param c1
	 * @param c2
	 * Dadas dos circunferencias busca los puntos de intersección en caso de haber.
	 * @return
	 * Si encuentra algún punto de intersección retorna como resultado del método una lista con los puntos encontrados
	 * @throws Exception 
	 * Si no encuentra lanza una excepcion porque no existe una posible ubicación para la fuente emisora
	 */
	private ArrayList<Position> twoCirclesIntersection(Circle c1, Circle c2) throws PositionNotFoundException {
		ArrayList<Position> intersection = new ArrayList<>();
		Double equationFirstPart, equationSecondPart, x1, x2, y1, y2;
		Double c1C2Distance = Math.sqrt((c1.getCenter().getX() - c2.getCenter().getX()) * (c1.getCenter().getX() - c2.getCenter().getX()) + (c1.getCenter().getY() - c2.getCenter().getY()) * (c1.getCenter().getY() - c2.getCenter().getY()));
		
		if (areCirclesIntersected(c1, c2, c1C2Distance)) {
			Double a1 = c1C2Distance + c1.getRadius() + c2.getRadius();
			Double a2 = c1C2Distance + c1.getRadius() - c2.getRadius();
			Double a3 = c1C2Distance - c1.getRadius() + c2.getRadius();
			Double a4 = -c1C2Distance + c1.getRadius() + c2.getRadius();
			Double intersectionArea = Math.sqrt(a1 * a2 * a3 * a4) / 4;

			equationFirstPart = (c1.getCenter().getX() + c2.getCenter().getX()) / 2 + (c2.getCenter().getX() - c1.getCenter().getX()) * (Math.pow(c1.getRadius(), 2) - Math.pow(c2.getRadius(), 2)) / (2 * Math.pow(c1C2Distance, 2));
			equationSecondPart = 2 * (c1.getCenter().getY() - c2.getCenter().getY()) * intersectionArea / (c1C2Distance * c1C2Distance);
			x1 = equationFirstPart + equationSecondPart;
			x2 = equationFirstPart - equationSecondPart;

			equationFirstPart = (c1.getCenter().getY() + c2.getCenter().getY()) / 2 + (c2.getCenter().getY() - c1.getCenter().getY()) * (Math.pow(c1.getRadius(), 2) - Math.pow(c2.getRadius(), 2)) / (2 * Math.pow(c1C2Distance, 2));
			equationSecondPart = 2 * (c1.getCenter().getX() - c2.getCenter().getX()) * intersectionArea / (c1C2Distance * c1C2Distance);
			y1 = equationFirstPart - equationSecondPart;
			y2 = equationFirstPart + equationSecondPart;

			if (!isPointOnCircle(c1, x1, y1)) {
				Double swap = y1;
				y1 = y2;
				y2 = swap;
			}
			Position firstPoint = new Position(x1, y1);
			Position secondPoint = new Position(x2, y2);
			intersection.add(firstPoint);
			intersection.add(secondPoint);
			return intersection;
		}
		throw new PositionNotFoundException("Cant find source, no intersection");
	}

	private boolean isPointOnCircle(Circle c1, Double x1, Double y1) {
		Double test = Math.abs((x1 - c1.getCenter().getX()) * (x1 - c1.getCenter().getX()) + (y1 - c1.getCenter().getY()) * (y1 - c1.getCenter().getY()) - c1.getRadius() * c1.getRadius());
		return test <= 0.0000001;
	}

	private boolean areCirclesIntersected(Circle c1, Circle c2, Double c1C2Distance) {
		return ((c1.getRadius() + c2.getRadius()) >= c1C2Distance) && (c1C2Distance >= Math.abs(c1.getRadius() - c2.getRadius()));
	}
	
	private Position findIntersectionPoint(ArrayList<Position> firstIntersection, ArrayList<Position> secondtersection) throws PositionNotFoundException {
		Position sourcePosition = null;
		int cont = 0;
		for(Position intersectionPointI: firstIntersection) {
			for(Position intersectionPointJ : secondtersection) {
				if (intersectionPointI.equals(intersectionPointJ)) {
					sourcePosition = intersectionPointI;
					cont++;
				}
			}
		}
		if (cont == 1) {
			return sourcePosition;
		}
		if (cont > 1) {			
			throw new PositionNotFoundException("Cant find source, too many possible solutions");
		}
		throw new PositionNotFoundException("Cant find source, no intersection");
	}
	
}
