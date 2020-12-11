package model.actor;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import model.Bounds;
import model.World;

public class Turtle extends Actor {
	ArrayList<Image> sprites = new ArrayList<Image>();
	private int speed;
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
		move(speed , 0);
		if (Bounds.isFullyOutOfBounds(this) && speed>0) {
			setGridX(Bounds.minGridX - 1);
		}
		if (Bounds.isFullyOutOfBounds(this) && speed<0) {
			setGridX(Bounds.maxGridX + 1);
		}
	}
	
	public Turtle(int x, int y, int s) {
		sprites.add(new Image("file:src/assets/turtle_0.png", World.getGridSize(), World.getGridSize(), true, true));
		sprites.add(new Image("file:src/assets/turtle_1.png", World.getGridSize(), World.getGridSize(), true, true));
		sprites.add(new Image("file:src/assets/turtle_2.png", World.getGridSize(), World.getGridSize(), true, true));
		setGridX(x);
		setGridY(y);
		speed = s;
		setImage(sprites.get(0));
		animation.start();
	}
	
	public double getSpeed() {
		return speed;
	}
}
