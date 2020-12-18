package main.java.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class InfoButton extends ImageView{
	private boolean toggled = false;
	public InfoButton(int x, int y) {
		setImage(new Image("file:src/assets/button_info.png", World.getGridSize(), World.getGridSize(), true, true));
		setX(x * World.getGridSize());
		setY(y * World.getGridSize());
		setOnMouseClicked(event -> {
			toggled = !toggled;
			System.out.println(toggled);
		});
	}
	
	public boolean isToggled() {
		return toggled;
	}
	
	public void setToggled(boolean toggle) {
		toggled = toggle;
	}
}
