package model;

import javafx.scene.image.Image;

public class Turtle extends Actor {
	Image turtle1;
	Image turtle2;
	Image turtle3;
	private int speed;
	int i = 1;
	boolean bool = true;
	@Override
	public void act(long now) {		
		move(speed , 0);
		if (getX() > 600 && speed>0) {
			setX(-200);
			System.out.println(getX());
		}
		if (getX() < -75 && speed<0) {
			setX(600);
		}
	}
	public Turtle(int x, int y, int s) {
		turtle1 = new Image("file:src/assets/turtle_0.png", World.getGridSize(), World.getGridSize(), true, true);
		setGridX(x);
		setGridY(y);
		speed = s;
		setImage(turtle1);
	}
	
	public double getSpeed() {
		return speed;
	}
}
