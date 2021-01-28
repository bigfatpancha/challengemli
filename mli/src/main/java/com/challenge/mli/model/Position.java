package com.challenge.mli.model;

public class Position {
	
	private Double X;
	private Double Y;
	
	public Position(Double x, Double y) {
		super();
		X = x;
		Y = y;
	}

	public Double getX() {
		return X;
	}
	public void setX(Double x) {
		X = x;
	}

	public Double getY() {
		return Y;
	}
	public void setY(Double y) {
		Y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((X == null) ? 0 : X.hashCode());
		result = prime * result + ((Y == null) ? 0 : Y.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (X == null) {
			if (other.X != null)
				return false;
		} else if (!X.equals(other.X))
			return false;
		if (Y == null) {
			if (other.Y != null)
				return false;
		} else if (!Y.equals(other.Y))
			return false;
		return true;
	}

}
