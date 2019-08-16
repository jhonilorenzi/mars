package com.mars.model;


public class Robot {

	private Position position;
	private Orientation orientation;
	private Ground ground;

	public Robot(Position position, Ground ground) {
		this.position = position;
		this.orientation = Orientation.NORTH;
		this.ground = ground;
	}

	public void moveForward() {
		switch (orientation) {
		case NORTH:
			this.position.incY();
			break;
		case SOUTH:
			this.position.decY();
			break;
		case EAST:
			this.position.incX();
			break;
		case WEST:
			this.position.decX();
			break;
		}
		checkInBounds();
	}

	private void checkInBounds() {
		if (!this.ground.isPositionValid(this.position)) {
			throw new OutOfAreaException("The robot cannot leave the area");
		}
	}

	public void turnLeft() {
		switch (orientation) {
		case EAST:
			this.orientation = Orientation.NORTH;
			break;
		case NORTH:
			this.orientation = Orientation.WEST;
			break;
		case SOUTH:
			this.orientation = Orientation.EAST;
			break;
		case WEST:
			this.orientation = Orientation.SOUTH;
			break;
		}
	}

	public void turnRight() {
		switch (orientation) {
		case EAST:
			this.orientation = Orientation.SOUTH;
			break;
		case NORTH:
			this.orientation = Orientation.EAST;
			break;
		case SOUTH:
			this.orientation = Orientation.WEST;
			break;
		case WEST:
			this.orientation = Orientation.NORTH;
			break;
		}
	}

	public int getX() {
		return this.position.getX();
	}

	public void setX(int x) {
		this.position.setX(x);
	}

	public int getY() {
		return this.position.getY();
	}

	public void setY(int y) {
		this.position.setY(y);
	}

	public Orientation getRotation() {
		return orientation;
	}

	public void setRotation(Orientation rotation) {
		this.orientation = rotation;
	}

	@Override
	public String toString() {
		return String.format("(%d, %d, %s)", this.position.getX(), this.position.getY(), this.orientation.toString());
	}
}
