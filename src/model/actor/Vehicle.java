package model.actor;

import com.game.model.Bounds;
import com.game.model.World;

import javafx.scene.image.Image;

public class Vehicle extends Actor {
	private double speed = 1;
	private double speedMultiplier;
	boolean isStandable = false;
	
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
	
	public Vehicle(String imageLink, int x, int y, int speed, int width) {
		setImage(new Image(imageLink, width * World.getGridSize(),  World.getGridSize(), true, true));
		setGridX(x);
		setGridY(y);
		speedMultiplier = speed;
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
