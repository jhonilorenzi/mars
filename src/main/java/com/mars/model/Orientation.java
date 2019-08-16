package com.mars.model;

public enum Orientation {
	NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");

	private String name;

	private Orientation(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
