package com.game.model.actor;

import com.game.controller.CollisionController;
import com.game.model.World;

import javafx.scene.image.Image;

public class End extends Actor{
	private boolean activated = false;
	private static double speed = 0;
	private double speedMultiplier;
	private static boolean isStandable = false;
	
	Image img1 = new Image("file:src/assets/end.png", 2 * World.getGridSize(), 2 * World.getGridSize(), true, true);
	Image img2 = new Image("file:src/assets/end_frog.png", 2 * World.getGridSize(), 2 * World.getGridSize(), true, true);
	
	@Override
	public void act(long now) {
		if (!activated && CollisionController.getCollidedActors(getWorld(), this, Frog.class).size() > 0) {
			setActivated(true);
		}
	}
	
	public End(int x, int y) {
		setGridX(x);
		setGridY(y);
		setImage(img1);
	}
	
	public void setActivated(boolean state) {
		if (state == true) {
			setImage(img2);
		} else {
			setImage(img1);
		}
		activated = state;
	}
	
	public boolean isActivated() {
		return activated;
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
