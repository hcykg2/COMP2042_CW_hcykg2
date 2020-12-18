package main.java.controller;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import main.java.model.StartView;
import main.java.model.View;
import main.java.model.World;
import main.java.util.Consts;
import main.java.util.Levels;
import main.java.view.ViewManager;

// scoring, switch screens,
public class GameController {
	private int score;
	private View currentView;
	private ViewManager viewManager;
	
	public GameController(ViewManager viewManager) {
		this.viewManager = viewManager;
//		currentView = new View(6, 13);
//		Levels.initLevel1(currentView);
		currentView = new StartView();
		viewManager.setView(currentView);
		viewManager.start();
		viewManager.getScene().addEventHandler(KeyEvent.KEY_PRESSED, this::keyPressed);
		currentView.start();

		timee.start();
	}
	
	public void keyPressed(KeyEvent event) {
		if (Consts.keyToDirectionFrog1.containsKey(event.getCode()) && currentView.frogList.size() > 0) {
			currentView.getFrog().tryMove(Consts.keyToDirectionFrog1.get(event.getCode()));
		} else {
			if (StartView.class.isInstance(currentView)) {
				currentView.wipe2();
//				currentView.setIsDone(true);
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
		System.out.println("stopping...");
		currentView.stop();
		currentView = new View(6, 13);
		Levels.initLevel1(currentView);
		Scene currentScene = new Scene(currentView, World.getGridSize() * World.getGridCountX(), World.getGridSize() * World.getGridCountY());
		viewManager.getStage().setScene(currentScene);
		
		currentView.start();
		currentScene.addEventHandler(KeyEvent.KEY_PRESSED, this::keyPressed);
	}
}
