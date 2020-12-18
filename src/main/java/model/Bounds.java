package main.java.model;

import main.java.model.actor.Actor;
import main.java.util.Direction;

public class Bounds {
	public static final int minGridX = 0;
	public static final int minGridY = 0;
	public static final int maxGridX = World.getGridCountX() - 1;
	public static final int maxGridY = World.getGridCountY() - 1;
	public static final int minX = 0;
	public static final int minY = 0;
	public static final int maxX = World.getGridCountX() * World.getGridSize();
	public static final int maxY = World.getGridCountY() * World.getGridSize();
	
	public static boolean isOutOfBounds(Actor actor) {
		if (actor.getGridX() < minGridX || actor.getGridX() > maxGridX || actor.getGridY() < minGridY || actor.getGridY() > maxGridY) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isFullyOutOfBounds(Actor actor) {
		if (actor.getX() + World.getGridSize() < minX || actor.getX() > maxX || actor.getY() + World.getGridSize() < minY || actor.getY() > maxY) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean canMoveInDirection(Actor actor, Direction dir) {
		switch (dir) {
			case UP:
				return actor.getGridY() > minGridY;
			case RIGHT:
				return actor.getGridX() < maxGridX;
			case DOWN:
				return actor.getGridY() < maxGridY;
			case LEFT:
				return actor.getGridX() > minGridX;
			default:
				return false;
		}
	}
}
