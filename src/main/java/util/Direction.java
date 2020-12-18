package main.java.util;

public enum Direction {
	UP(0),
	RIGHT(90),
	DOWN(180),
	LEFT(270);
	
	private final int angle;
	private Direction(int angle) {
		this.angle = angle;
	}
	
	public int getAngle() {
		return angle;
	}
}
