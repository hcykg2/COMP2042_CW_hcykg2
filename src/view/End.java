package view;

import javafx.scene.image.Image;
import model.Actor;

public class End extends Actor{
	boolean activated = false;
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}
	
	public End(int x, int y) {
		super(2 * World.getGridSize(), 2 * World.getGridSize());
		setGridX(x);
		setGridY(y);
		setImage(new Image("file:src/assets/end.png", 2 * World.getGridSize(), 2 * World.getGridSize(), true, true));
	}
	
	public void setEnd() {
		setImage(new Image("file:src/assets/end_frog.png", 2 * World.getGridSize(), 2 * World.getGridSize(), true, true));
		activated = true;
	}
	
	public boolean isActivated() {
		return activated;
	}
	

}
