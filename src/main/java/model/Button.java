package main.java.model;

import javafx.scene.image.ImageView;

public class Button extends ImageView{
	public Button() {
		setOnMouseClicked(event -> {
			System.out.println("nice");
		});
	}
}
