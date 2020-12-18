package main.java.model;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import main.java.util.Consts;
import main.java.util.TextColor;

public class StartView extends View{
	ArrayList<GameChar> infoText = new ArrayList<GameChar>();
	ArrayList<GameChar> startText = new ArrayList<GameChar>();
	AnimationTimer startViewTimer;
	
	public StartView() {
		blank = new ImageView(new Image("file:src/assets/tile_water.png", World.getGridCountX() * getGridSize(), getGridCountY() * getGridSize(), false, true));
		getChildren().add(blank);
    	blank.setX(0);
    	blank.setY(0);
    	
    	ImageView title = new ImageView(new Image("file:src/assets/title_frogger.png", 7 * World.getGridSize(), World.getGridSize(), true, true));
    	getChildren().add(title);
    	title.setX(3.5 * World.getGridSize());
    	title.setY(5 * World.getGridSize());
		startText.addAll(addText("push any key to start", TextColor.YELLOW, 2, 7));
		
		InfoButton button = new InfoButton(0, 0);
		getChildren().add(button);
		
		infoText.addAll(addText("\nkelvin goh hcykg2 20218707\n\nuse wasd keys to move\navoid enemies\ndo not fall in river\ngood luck", TextColor.YELLOW, 1, 0));
		for(int i = 0; i < infoText.size(); i++) {
			infoText.get(i).setOpacity(0);
		}
		
		startViewTimer = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				double opacity = 0;
				if (button.isToggled()) {
					for(int i = 0; i < infoText.size(); i++) {
						if (infoText.get(i).getOpacity() == 1) {
							opacity = 0;
						} else {
							opacity = 1;
						}
						infoText.get(i).setOpacity(opacity);
						button.setToggled(false);
					}
				}
			}
		};
		
		textBlinkAnimation.start();
	}
	
	AnimationTimer textBlinkAnimation = new AnimationTimer() {
		int i = 0;
		int time = 40;
		double opacity = 0;
		@Override
		public void handle(long arg0) {
			if (i < time) {
				i++;
			} else {
				i = 0;
				for(int i = 0; i < startText.size(); i++) {
					if (startText.get(i).getOpacity() == 1) {
						opacity = 0;
					} else {
						opacity = 1;
					}
					startText.get(i).setOpacity(opacity);
				}
			}
		}
	};
	
	@Override
	public void start() {
		startViewTimer.start();
	}
	
	@Override
	public void stop() {
		startViewTimer.stop();
	}
}
