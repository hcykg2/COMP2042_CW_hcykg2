package controller;

import model.Actor;
import model.World;

public class BoundsController {
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
}
