package main.java.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Button to display info
 * @author Kelvin
 *
 */
public class InfoButton extends ImageView{
	private boolean toggled = false;
	
	/**
	 * @param x x grid coordinate
	 * @param y y grid coordinate
	 */
	public InfoButton(int x, int y) {
		setImage(new Image("file:src/main/resources/assets/button_info.png", World.getGridSize(), World.getGridSize(), true, true));
		setX(x * World.getGridSize());
		setY(y * World.getGridSize());
		setOnMouseClicked(event -> {
			toggled = true;
		});
	}
	
	/**
	 * Checks if button has been clicked on
	 * @return True if button has been clicked on
	 */
	public boolean isToggled() {
		return toggled;
	}
	
	/**
	 * Sets the toggled state of the button
	 * @param toggle The toggled state of the button
	 */
	public void setToggled(boolean toggle) {
		toggled = toggle;
	}
}
