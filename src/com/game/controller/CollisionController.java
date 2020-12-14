package com.game.controller;

import java.util.ArrayList;

import com.game.model.World;

import model.actor.Actor;
import model.actor.Frog;

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
	
	public static <A extends Actor> java.util.List<A> getCollidedFrogs(World stage, Actor actor) {
		Class<A> frogClass = (Class<A>) Frog.class;
		ArrayList<A> collidedActors = new ArrayList<A>();
		for (A otherActors: stage.getObjects(frogClass)) {
			if (otherActors != actor && otherActors.intersects(actor.getX() + 1, actor.getY() + 1, actor.getWidth() - 2, actor.getHeight() - 2)) {
				collidedActors.add(otherActors);
			}
		}
		return collidedActors;
	}
	
	public static <A extends Actor> java.util.List<A> isStandingOn(World stage, Actor actor, Class<A> actorClass) {
		ArrayList<A> collidedActors = new ArrayList<A>();
		for (A otherActors: stage.getObjects(actorClass)) {
			if (otherActors != actor && otherActors.contains(actor.getX() + World.getGridSize()/2, actor.getY() + World.getGridSize()/2)) {
				collidedActors.add(otherActors);
			}
		}
		return collidedActors;
	}
	
	public static <A extends Actor> java.util.List<A> isStandingOnStandable(World stage, Actor actor) {
		Class<A> actorClass = (Class<A>) Actor.class;
		ArrayList<A> collidedActors = new ArrayList<A>();
		for (A otherActors: stage.getObjects(actorClass)) {
			if (otherActors != actor && otherActors.contains(actor.getX() + World.getGridSize()/2, actor.getY() + World.getGridSize()/2) && otherActors.isStandable()) {
				collidedActors.add(otherActors);
			}
		}
		return collidedActors;
	}
}
