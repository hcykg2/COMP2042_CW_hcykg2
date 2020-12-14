package model;

import javafx.scene.image.Image;
import model.actor.Actor;

public class Digit extends Actor{
	int dim;
	Image im1;
	double speed = 0;
	double speedMultiplier;
	boolean isStandable = false;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/assets/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
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
