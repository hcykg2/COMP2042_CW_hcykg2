package main.java.model;


import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import main.java.model.actor.Actor;
import main.java.model.actor.Log;
import main.java.model.actor.Turtle;
import main.java.util.TextColor;

public abstract class World extends Pane {
    private AnimationTimer timer;
    private final static int gridSize = 32;
    private final static int gridCountX = 14;
    private final static int gridCountY = 14;
    
    public World() {
    }

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                List<Actor> actors = getObjects(Actor.class);
                
                for (Actor anActor: actors) {
                	anActor.act(now);
                }
      
            }
        };
    }

    public void start() {
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    public void add(Actor actor) {
        getChildren().add(actor);
    }
    
    public void add(Tile tile) {
        getChildren().add(tile);
    }
    
    public void add(GameChar character) {
        getChildren().add(character);
    }
    
    public void addText(String text, TextColor color, int x, int y) {
		char[] charArray = text.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			add(new GameChar(charArray[i], color, x * World.getGridSize() + i * World.getGridSize()/2, y * World.getGridSize()));
		}
	}
    
    public void addRow(String imageLink, int y, boolean isSafe) {
        for (int i = 0; i < World.getGridCountX(); i++) {
        	add(new Tile(imageLink, i, y, isSafe));
        }
    }

    public void remove(Actor actor) {
        getChildren().remove(actor);
    }
    
    public void addTurtles(int x, int y, double s, int count) {
    	for (int i = 0; i < count; i++) {
    		add(new Turtle(x + i, y, s));
    	}
    }
    
    public void addLog(int x, int y, double s, int length) {
    	add(new Log(0, x, y, s));
    	for (int i = 1; i < length - 1; i++) {
    		add(new Log(1, x + i, y, s));
    	}
    	add(new Log(2, x + length - 1, y, s));
    }

    @SuppressWarnings("unchecked")
	public <A extends Actor> List<A> getObjects(Class<A> actorClass) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (actorClass.isInstance(n)) {
                someArray.add((A) n);
            }
        }
        return someArray;
    }
    
    public List<Tile> getTiles() {
        ArrayList<Tile> someArray = new ArrayList<Tile>();
        for (Node n: getChildren()) {
            if (Tile.class.isInstance(n)) {
                someArray.add((Tile) n);
            }
        }
        return someArray;
    }

    public abstract void act(long now);
    
    public static int getGridSize() {
    	return gridSize;
    }
    
    public static int getGridCountX() {
    	return gridCountX;
    }
    
    public static int getGridCountY() {
    	return gridCountY;
    }
}
