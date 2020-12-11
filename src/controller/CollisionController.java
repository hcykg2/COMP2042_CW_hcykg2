package controller;

import java.util.ArrayList;

import model.World;
import model.actor.Actor;

public class CollisionController<A> {
	
	public static <A extends Actor> java.util.List<A> getCollidedActors(World stage, Actor actor, java.lang.Class<A> actorClass) {
		ArrayList<A> collidedActors = new ArrayList<A>();
		for (A otherActors: stage.getObjects(actorClass)) {
			if (otherActors != actor && otherActors.intersects(actor.getX() + 1, actor.getY() + 1, actor.getWidth() - 2, actor.getHeight() - 2)) {
				collidedActors.add(otherActors);
			}
		}
		return collidedActors;
	}
	
	public static <A extends Actor> java.util.List<A> isStandingOn(World stage, Actor actor, java.lang.Class<A> actorClass) {
		ArrayList<A> collidedActors = new ArrayList<A>();
		for (A otherActors: stage.getObjects(actorClass)) {
			if (otherActors != actor && otherActors.contains(actor.getX() + World.getGridSize()/2, actor.getY() + World.getGridSize()/2)) {
				collidedActors.add(otherActors);
			}
		}
		return collidedActors;
	}
}
