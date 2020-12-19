package main.java.controller;

import java.util.ArrayList;

import main.java.model.Tile;
import main.java.model.View;
import main.java.model.World;
import main.java.model.actor.Actor;
import main.java.model.actor.End;
import main.java.model.actor.Frog;

/**
 * This class contains methods for checking whether an actor is intersecting with another actor or standing on a tile.
 * @author Kelvin
 *
 */
public class CollisionController {
	
	/**
	 * Returns an ArrayList of actors of a specified subclass that are intersected with a specified actor.
	 * @param <A> Actor subclass
	 * @param actor The specified actor
	 * @param actorClass Class object of the actor subclass
	 * @return ArrayList of actors in subclass that are intersected with the specified actor.
	 */
	public static <A extends Actor> ArrayList<A> getCollidedActors(Actor actor, java.lang.Class<A> actorClass) {
		View view = actor.getView();
		ArrayList<A> collidedActors = new ArrayList<A>();
		for (A otherActors: view.getObjects(actorClass)) {
			if (otherActors != actor && otherActors.intersects(actor.getX() + 1, actor.getY() + 1, actor.getWidth() - 2, actor.getHeight() - 2)) {
				collidedActors.add(otherActors);
			}
		}
		return collidedActors;
	}
	
	/**
	 * Returns an ArrayList of ends that are intersecting with the specified actor.
	 * @param actor The specified actor
	 * @return ArrayList of ends
	 */
	public static ArrayList<End> getCollidedEnds(Actor actor) {
		View view = actor.getView();
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
	/**
	 * Returns an ArrayList of actors of a specified actor subclass being stood on by the specified actor.
	 * @param <A> Actor subclass
	 * @param actor The specified actor
	 * @param actorClass Class object of the actor subclass
	 * @return ArrayList of actors being stood on by the specified actor.
	 */
	public static <A extends Actor> ArrayList<A> getStandingOnActors(Actor actor, Class<A> actorClass) {
		View view = actor.getView();
		ArrayList<A> collidedActors = new ArrayList<A>();
		for (A otherActors: view.getObjects(actorClass)) {
			if (otherActors != actor && otherActors.contains(actor.getX() + World.getGridSize()/2, actor.getY() + World.getGridSize()/2)) {
				collidedActors.add(otherActors);
			}
		}
		return collidedActors;
	}
	
	/**
	 * Returns an ArrayList of tiles being stood on by the specified actor
	 * @param actor The specified actor
	 * @return ArrayList of tiles being stood on by the specified actor.
	 */
	public static ArrayList<Tile> getStandingOnTiles(Actor actor) {
		View view = actor.getView();
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		for (Tile otherActors: view.getTiles()) {
			if (otherActors.contains(actor.getX() + World.getGridSize()/2, actor.getY() + World.getGridSize()/2)) {
				tiles.add(otherActors);
			}
		}
		return tiles;
	}
	
	/**
	 * Returns an ArrayList of standable tiles being stood on by the specified actor
	 * @param <A> Actor subclass
	 * @param actor The specified actor
	 * @return  ArrayList of standable tiles being stood on by the specified actor.
	 */
	public static <A extends Actor> ArrayList<A> getStandingOnStandableTiles(Actor actor) {
		View view = actor.getView();
		Class<A> actorClass = (Class<A>) Actor.class;
		ArrayList<A> collidedActors = new ArrayList<A>();
		for (A otherActors: view.getObjects(actorClass)) {
			if (otherActors != actor && otherActors.contains(actor.getX() + World.getGridSize()/2, actor.getY() + World.getGridSize()/2) && otherActors.isStandable()) {
				collidedActors.add(otherActors);
			}
		}
		return collidedActors;
	}
}
