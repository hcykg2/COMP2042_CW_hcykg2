package model;

import javafx.scene.image.Image;

public class Vehicle extends Actor {
	private int speed = 1;
	private int speedMultiplier;
	
	@Override
	public void act(long now) {
		move(speed * speedMultiplier, 0);
		if (getX() > 600 && speedMultiplier>0)
			setX(-200);
		if (getX() < -50 && speedMultiplier<0)
			setX(600);
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
}
