package com.game.controller;

import java.util.ArrayList;

import com.game.model.View;
import com.game.model.World;
import com.game.model.actor.Actor;
import com.game.model.actor.Frog;

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
	
	public static java.util.List<Frog> getCollidedFrogs(View view, Actor actor) {
		Frog frog;
		ArrayList<Frog> collidedFrogs = new ArrayList<Frog>();
		for (int i = 0; i < view.frogList.size(); i++) {
			frog = view.frogList.get(i);
			if (frog.intersects(actor.getX() + 1, actor.getY() + 1, actor.getWidth() - 2, actor.getHeight() - 2)) {
				collidedFrogs.add(frog);
			}
		}
		return collidedFrogs;
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
