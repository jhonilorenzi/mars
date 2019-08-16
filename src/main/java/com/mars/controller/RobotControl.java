package com.mars.controller;

import com.mars.model.Ground;
import com.mars.model.Position;
import com.mars.model.Robot;

public class RobotControl {

	private Movements[] movements;
	private Robot robot;

	public RobotControl(Movements[] movements, Position position, Ground ground) {
		this.movements = movements;
		this.robot = new Robot(position, ground);
	}

	public String executeMovements() {
		for (Movements movement : movements) {
			switch (movement) {
			case FORWARD:
				robot.moveForward();
				break;
			case LEFT:
				robot.turnLeft();
				break;
			case RIGHT:
				robot.turnRight();
				break;
			}
		}
		return robot.toString();
	}
}
