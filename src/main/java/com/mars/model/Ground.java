package com.mars.model;

public class Ground {

	private int height;
	private int width;
	
	public Ground(int heigth, int width) {
		this.height = heigth;
		this.width = width;
	}
	
	public boolean isPositionValid(Position position) {
		int x = position.getX();
		int y = position.getY();
		if (y >= this.height || x >= this.width || y < 0 || x < 0) {
			return false;
		}
		return true;
	}
}
