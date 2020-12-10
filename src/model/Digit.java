package model;

import javafx.scene.image.Image;
import view.World;

public class Digit extends Actor{
	int dim;
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Digit(int n, int dim, int x, int y) {
		super(World.getGridSize(), World.getGridSize());
		im1 = new Image("file:src/assets/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}