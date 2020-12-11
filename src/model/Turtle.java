package model;

import controller.BoundsController;
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
		if (BoundsController.isFullyOutOfBounds(this) && speed>0) {
			setGridX(BoundsController.minGridX - 1);
			System.out.println(getX());
		}
		if (BoundsController.isFullyOutOfBounds(this) && speed<0) {
			setGridX(BoundsController.maxGridX + 1);
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
