package com.game.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tile extends ImageView {
	boolean isSafe;
	
	public Tile(String imageLink,int x, int y, boolean isSafe) {
		setImage(new Image(imageLink, World.getGridSize(), World.getGridSize(), true, true));
		setX(x * World.getGridSize());
		setY(y * World.getGridSize());
		this.isSafe = isSafe;
	}
}
