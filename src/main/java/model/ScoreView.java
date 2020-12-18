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

public class ScoreView extends View {
	ArrayList<GameChar> scoreNums = new ArrayList<GameChar>();
	ArrayList<GameChar> text = new ArrayList<GameChar>();
	AnimationTimer incrementTimer;
	AnimationTimer textTimer;
	boolean highScoreFlag = false;
	
	public ScoreView(int init, int target, boolean highScore) {
		boolean highScoreFlag = true;
		blank = new ImageView(new Image("file:src/main/resources/assets/tile_water.png", World.getGridCountX() * getGridSize(), getGridCountY() * getGridSize(), false, true));
		getChildren().add(blank);
    	blank.setX(0);
    	blank.setY(0);
    	scoreNums = addText(" 000000", TextColor.YELLOW, 5, 7);
    	text = addText(" high score", TextColor.YELLOW, 4, 6);
    	
    	for(int i = 0; i < text.size(); i++) {
			text.get(i).setOpacity(0);
		}
    	
    	incrementScore(init, target);
	}
	
	public void playBlip() {
		String musicFile = "src/main/resources/assets/audio/blip.wav"; 
		Media sound = new Media(new File(musicFile).toURI().toString());
		AudioClip mediaPlayer = new AudioClip(sound.getSource());
	    mediaPlayer.play();
	}
	
	public void playScoreSound() {
		String musicFile = "src/main/resources/assets/audio/score.wav"; 
		Media sound = new Media(new File(musicFile).toURI().toString());
		AudioClip mediaPlayer = new AudioClip(sound.getSource());
	    mediaPlayer.play();
	}
	
	public void setScore(int score) {
		int temp = 0;
		int digits = scoreNums.size();
		for (int i = 0; i < digits; i++) {
			scoreNums.get(digits - i - 1).setImage(new Image("file:src/main/resources/assets/char/char_yellow_" + (int) (((score - temp) % Math.pow(10, i + 1) )/Math.pow(10, i)) + ".png", World.getGridSize()/2, World.getGridSize()/2, true, true));
			temp = (int) (score % Math.pow(10, i + 1));
		}
	}
	
	public void createIncrementTimer(int init, int target) {
		incrementTimer = new AnimationTimer() {
			int i = 0;
			
			@Override
			public void handle(long now) {
				if (i == 0) {
					setScore(init);
				}
				if (init + i <= target) {
					setScore(init + i);
					i++;
					if (i % 10 == 0) {
						playBlip();
					}
				} else {
					playScoreSound();
					if (highScoreFlag) {
						blinkText();
					} else {
						
					}
					stop();
				}
			}
		};
	}
	
	public void createTextTimer() {
		textTimer = new AnimationTimer() {
			int i = 0;
			int time = 180;
			double opacity = 0;
			@Override
			public void handle(long now) {
				if (i % 30 == 0) {
					for(int i = 0; i < text.size(); i++) {
						if (text.get(i).getOpacity() == 1) {
							opacity = 0;
						} else {
							opacity = 1;
						}
						text.get(i).setOpacity(opacity);
					}
				} else if (i >= time) {
					i = 0;
					stop();
				}
				i++;
			}
		};
	}
	
	public void incrementScore(int init, int target) {
		createIncrementTimer(init, target);
		incrementTimer.start();
	}
	
	public void blinkText() {
		createTextTimer();
		textTimer.start();
	}
}
