package main.java.model.actor;

import java.util.ArrayList;

import javafx.scene.image.Image;
import main.java.controller.BoundsController;
import main.java.model.World;

public class Log extends Actor {

	private double speed = 0.5;
	private double speedMultiplier;
	boolean isStandable = true;
	ArrayList<Image> sprites = new ArrayList<Image>(); 
	
	@Override
	public void act(long now) {		
		move(speed * speedMultiplier , 0);
		if (BoundsController.isFullyOutOfBounds(this) && speedMultiplier > 0) {
			move(-(BoundsController.maxX + World.getGridSize()), 0);
		}
		if (BoundsController.isFullyOutOfBounds(this) && speedMultiplier < 0) {
			move(BoundsController.maxX + World.getGridSize(), 0);
		}
	}
	
	public Log(int sprite, int x, int y, double s) {
		sprites.add(new Image("file:src/main/resources/assets/log_0.png", World.getGridSize(), World.getGridSize(), true, true));
		sprites.add(new Image("file:src/main/resources/assets/log_1.png", World.getGridSize(), World.getGridSize(), true, true));
		sprites.add(new Image("file:src/main/resources/assets/log_2.png", World.getGridSize(), World.getGridSize(), true, true));
		setImage(sprites.get(sprite));
		setGridX(x);
		setGridY(y);
		speedMultiplier = s;
		
	}
	public boolean getLeft() {
		return speed < 0;
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
