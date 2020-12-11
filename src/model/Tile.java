package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.World;

public class Row extends ImageView {
	
	public Row(String imageLink, int y) {
		setImage(new Image(imageLink, 224 * World.getGridSize(), World.getGridSize(), true, true));
		setX(0);
		setY(y * World.getGridSize());
	}
}
