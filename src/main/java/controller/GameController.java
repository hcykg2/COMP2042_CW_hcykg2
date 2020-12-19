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
import main.java.model.ScoreboardView;
import main.java.view.ViewManager;

public class GameController {
	private int lastScore = 0;
	private int score = 1000;
	private View currentView;
	private ViewManager viewManager;
	private int currentLevel = 0;
	
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
				currentView.setIsDone(true);
			}
		}
    }
	
	AnimationTimer timee = new AnimationTimer() {
		int i = 0;

		@Override
		public void handle(long arg0) {
			i++;
			if (currentView.getIsDone()) {
				currentView.transitionOut();
				
			}
			if (currentView.readyForNextView()) {
				if(Level.class.isInstance(currentView)) {
					currentView.stop();
					currentView = new ScoreView(lastScore, score);
					Scene currentScene = new Scene(currentView, World.getGridSize() * World.getGridCountX(), World.getGridSize() * World.getGridCountY());
					viewManager.getStage().setScene(currentScene);
				} else if (ScoreView.class.isInstance(currentView) || StartMenu.class.isInstance(currentView)) {
					newView();
				}
				currentView.transitionIn();
			}
			if (i % 3000 == 0 && score > 0) {
				addScore(-100);
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
		Level newLevel = new Level(6, 13);
		currentView = (View) newLevel;
		Levels.initLevel(newLevel, currentLevel);
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
