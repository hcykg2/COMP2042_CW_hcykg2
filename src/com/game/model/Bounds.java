package com.game.model;

import com.game.model.actor.Actor;

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
	
	public static boolean canMoveInDirection(Actor actor, int dir) {
		switch (dir) {
			case 0:
				return actor.getGridY() > minGridY;
			case 1:
				return actor.getGridX() < maxGridX;
			case 2:
				return actor.getGridY() < maxGridY;
			case 3:
				return actor.getGridX() > minGridX;
			default:
				return false;
		}
	}
}
