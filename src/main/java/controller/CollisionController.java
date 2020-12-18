package main.java.controller;

import java.util.ArrayList;

import main.java.model.Tile;
import main.java.model.View;
import main.java.model.World;
import main.java.model.actor.Actor;
import main.java.model.actor.End;
import main.java.model.actor.Frog;

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
	
	public static ArrayList<End> getCollidedEnds(View view, Actor actor) {
		End end;
		ArrayList<End> collidedEnds = new ArrayList<End>();
		for (int i = 0; i < view.endList.size(); i++) {
			end = view.endList.get(i);
			if (!end.isActivated() && end.intersects(actor.getX() + 1, actor.getY() + 1, actor.getWidth() - 2, actor.getHeight() - 2)) {
				collidedEnds.add(end);
			}
		}
		return collidedEnds;
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
	
	public static ArrayList<Tile> isStandingOnTile(World stage, Actor actor) {
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		for (Tile otherActors: stage.getTiles()) {
			if (otherActors.contains(actor.getX() + World.getGridSize()/2, actor.getY() + World.getGridSize()/2)) {
				tiles.add(otherActors);
			}
		}
		return tiles;
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
