package main.java.controller;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
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
		currentView = new View(6, 13);
		Levels.initLevel1(currentView);
		viewManager.setView(currentView);
		viewManager.start();
		currentView.start();
		viewManager.getScene().addEventHandler(KeyEvent.KEY_PRESSED, this::keyPressed);
		timee.start();
	}
	
	public void keyPressed(KeyEvent event) {
		if (Consts.keyToDirectionFrog1.containsKey(event.getCode())) {
			currentView.getFrog().tryMove(Consts.keyToDirectionFrog1.get(event.getCode()));
		}
    }
	
	AnimationTimer gameLoop = new AnimationTimer() {

		@Override
		public void handle(long arg0) {
			
		}
		
	};
	
	AnimationTimer timee = new AnimationTimer() {
		int i = 0;

		@Override
		public void handle(long arg0) {
			if (currentView.activatedEnds >= currentView.endList.size()) {
				newView();
			}
		}
	};
	
	public void start() {
		gameLoop.start();
	}
	
	public void stop() {
		gameLoop.stop();
	}
	
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
		currentView = new View(6, 13);
		Levels.initLevel1(currentView);
		Scene currentScene = new Scene(currentView, World.getGridSize() * World.getGridCountX(), World.getGridSize() * World.getGridCountY());
		viewManager.getStage().setScene(currentScene);
		currentView.start();
		currentScene.addEventHandler(KeyEvent.KEY_PRESSED, this::keyPressed);
	}
}
