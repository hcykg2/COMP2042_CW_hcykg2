package model.actor;

import java.util.ArrayList;

import javafx.scene.image.Image;
import model.Bounds;
import model.World;

public class Log extends Actor {

	private double speed;
	ArrayList<Image> sprites = new ArrayList<Image>(); 
	
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
	
	public Log(int sprite, int x, int y, double s) {
		sprites.add(new Image("file:src/assets/log_0.png", World.getGridSize(), World.getGridSize(), true, true));
		sprites.add(new Image("file:src/assets/log_1.png", World.getGridSize(), World.getGridSize(), true, true));
		sprites.add(new Image("file:src/assets/log_2.png", World.getGridSize(), World.getGridSize(), true, true));
		setImage(sprites.get(sprite));
		setGridX(x);
		setGridY(y);
		speed = s;
		
	}
	public boolean getLeft() {
		return speed < 0;
	}
	
	public double getSpeed() {
		return speed;
	}
}
