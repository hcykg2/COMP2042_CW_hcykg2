package main.java.model;

import java.io.File;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import main.java.util.TextColor;
import main.java.model.GameChar;

/**
 * View for displaying the current score of the player
 * @author Kelvin
 *
 */
public class ScoreView extends View {
	ArrayList<GameChar> scoreNums = new ArrayList<GameChar>();
	ArrayList<GameChar> text = new ArrayList<GameChar>();
	AnimationTimer incrementTimer;
	AnimationTimer textTimer;
	boolean highScoreFlag = false;
	
	/**
	 * 
	 * @param init Initial score to display
	 * @param target Final score to display
	 * @param highScore If true, display blinking "high score" text above score
	 */
	public ScoreView(int init, int target) {
		setBackground();
    	scoreNums = addText(" 000000", TextColor.YELLOW, 5, 7);
    	text = addText(" high score", TextColor.YELLOW, 4, 6);
    	
    	for(int i = 0; i < text.size(); i++) {
			text.get(i).setOpacity(0);
		}
    	
    	incrementScore(init, target);
	}
	
	private void setBackground() {
		blank = new ImageView(new Image("file:src/main/resources/assets/tile_water.png", World.getGridCountX() * getGridSize(), getGridCountY() * getGridSize(), false, true));
		getChildren().add(blank);
    	blank.setX(0);
    	blank.setY(0);
	}
	
	private void playBlip() {
		String musicFile = "src/main/resources/assets/audio/blip.wav"; 
		Media sound = new Media(new File(musicFile).toURI().toString());
		AudioClip mediaPlayer = new AudioClip(sound.getSource());
	    mediaPlayer.play();
	}
	
	private void playScoreSound() {
		String musicFile = "src/main/resources/assets/audio/score.wav"; 
		Media sound = new Media(new File(musicFile).toURI().toString());
		AudioClip mediaPlayer = new AudioClip(sound.getSource());
	    mediaPlayer.play();
	}
	
	private void setScore(int score) {
		int temp = 0;
		int digits = scoreNums.size();
		for (int i = 0; i < digits; i++) {
			scoreNums.get(digits - i - 1).setImage(new Image("file:src/main/resources/assets/char/char_yellow_" + (int) (((score - temp) % Math.pow(10, i + 1) )/Math.pow(10, i)) + ".png", World.getGridSize()/2, World.getGridSize()/2, true, true));
			temp = (int) (score % Math.pow(10, i + 1));
		}
	}
	
	private void createIncrementTimer(int init, int target) {
		incrementTimer = new AnimationTimer() {
			int i = 0;
			
			@Override
			public void handle(long now) {
				if (i == 0) {
					setScore(init);
				}
				if (init + i != target) {
					setScore(init + i);
					if(target > init) {
						i++;
					} else {
						i--;
					}
					if (i % 10 == 0) {
						playBlip();
					}
				} else {
					if (init + i != target) {
						setScore(init + i);
						if(target > init) {
							i+=2;
						} else {
							i-=2;
						}
					}
					setScore(init + i);
					AnimationTimer wait = new AnimationTimer() {
						int i = 0;
						@Override
						public void handle(long arg0) {
							if (i == 0) {
								playScoreSound();
							}
							if (i <= 90) {
								i++;
							} else {
								i = 0;
								setIsDone(true);
								stop();
							}
						}
						
					};
					wait.start();
					stop();
				}
			}
		};
	}
	
	private void incrementScore(int init, int target) {
		createIncrementTimer(init, target);
		incrementTimer.start();
	}
}
