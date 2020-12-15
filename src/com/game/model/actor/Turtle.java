package com.game.model.actor;

import java.util.ArrayList;

import com.game.model.Bounds;
import com.game.model.World;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;

public class Turtle extends Actor {
	ArrayList<Image> sprites = new ArrayList<Image>();
	private double speed = 0.5;
	private double speedMultiplier;
	boolean isStandable = true;
	int i = 1;
	boolean bool = true;
	
	AnimationTimer animation = new AnimationTimer() {
		int time = 120;
		int counter = 0;
		int sprite = 0;
		@Override
		public void handle(long arg0) {
			if (counter < time) {
				counter++;
			} else {
				counter = 0;
				sprite++;
				if (sprite == sprites.size()) {
					sprite = 0;
				}
				setImage(sprites.get(sprite));
			}
		}
	};
	
	@Override
	public void act(long now) {		
		move(speed * speedMultiplier , 0);
		if (Bounds.isFullyOutOfBounds(this) && speedMultiplier > 0) {
			move(-(Bounds.maxX + World.getGridSize()), 0);
		}
		if (Bounds.isFullyOutOfBounds(this) && speedMultiplier < 0) {
			move(Bounds.maxX + World.getGridSize(), 0);
		}
	}
	
	public Turtle(int x, int y, double s) {
		sprites.add(new Image("file:src/assets/turtle_0.png", World.getGridSize(), World.getGridSize(), true, true));
		sprites.add(new Image("file:src/assets/turtle_1.png", World.getGridSize(), World.getGridSize(), true, true));
		sprites.add(new Image("file:src/assets/turtle_2.png", World.getGridSize(), World.getGridSize(), true, true));
		setGridX(x);
		setGridY(y);
		speedMultiplier = s;
		setImage(sprites.get(0));
		animation.start();
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public double getSpeedMultiplier() {
		return speedMultiplier;
	}
	
	public void setSpeedMultiplier(double s) {
		speedMultiplier = s;
	}
	
	public boolean isStandable() {
		return isStandable;
	}
}
