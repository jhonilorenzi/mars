package com.mars.model;

public class OutOfAreaException extends RuntimeException {

	private static final long serialVersionUID = 5297442433257035321L;

	public OutOfAreaException(String message) {
		super(message);
	}
}
