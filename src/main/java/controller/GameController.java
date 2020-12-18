package main.java.controller;

import java.io.File;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import main.java.model.StartMenu;
import main.java.model.View;
import main.java.model.World;
import main.java.util.Consts;
import main.java.util.Levels;
import main.java.model.Level;
import main.java.model.ScoreView;
import main.java.view.ViewManager;

// scoring, switch screens,
public class GameController {
	private int score;
	private View currentView;
	private ViewManager viewManager;
	
	public GameController(ViewManager viewManager) {
		this.viewManager = viewManager;
		currentView = new StartMenu();
		viewManager.setView(currentView);
		viewManager.start();
		viewManager.getScene().addEventHandler(KeyEvent.KEY_PRESSED, this::keyPressed);
		currentView.start();

		timee.start();
	}
	
	public void keyPressed(KeyEvent event) {
		if (Consts.keyToDirectionFrog1.containsKey(event.getCode()) && currentView.getFrog() != null) {
			currentView.getFrog().tryMove(Consts.keyToDirectionFrog1.get(event.getCode()));
		} else {
			if (StartMenu.class.isInstance(currentView)) {
				playStartSound();
				currentView.wipe2();
			}
		}
    }
	
	AnimationTimer timee = new AnimationTimer() {
		int i = 0;

		@Override
		public void handle(long arg0) {
			if (currentView.getIsDone()) {
				newView();
				currentView.wipe();
			}
		}
	};
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void addScore(int score) {
		this.score += score;
	}
	
	public void newView() {
		currentView.stop();
		Level newLevel = new Level(6, 13);
		currentView = (View) newLevel;
		Levels.initLevel1(newLevel);
		Scene currentScene = new Scene(newLevel, World.getGridSize() * World.getGridCountX(), World.getGridSize() * World.getGridCountY());
		viewManager.getStage().setScene(currentScene);
		
		newLevel.start();
		currentScene.addEventHandler(KeyEvent.KEY_PRESSED, this::keyPressed);
	}
	
	public void playStartSound() {
		String musicFile = "src/main/resources/assets/audio/start.wav"; 
		Media sound = new Media(new File(musicFile).toURI().toString());
		AudioClip mediaPlayer = new AudioClip(sound.getSource());
	    mediaPlayer.play();
	}
}
