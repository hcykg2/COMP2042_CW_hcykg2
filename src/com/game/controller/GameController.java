package com.game.controller;

import com.game.model.View;
import com.game.model.World;
import com.game.util.Direction;
import com.game.util.Consts;
import com.game.view.ViewManager;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

// scoring, switch screens,
public class GameController {
	private int score;
	private View currentView;
	private ViewManager viewManager;
	private EventHandler<KeyEvent> onKeyPress;
	
	public GameController(ViewManager viewManager) {
		this.viewManager = viewManager;
		currentView = new View();
		viewManager.setView(currentView);
		viewManager.start();
		currentView.start();
		viewManager.getScene().addEventHandler(KeyEvent.KEY_PRESSED, this::keyPressed);
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
			if (i < 360) {
				i++;
			} else {
				currentView.stop();
				currentView = new View();
				Scene currentScene = new Scene(currentView, World.getGridSize() * World.getGridCountX(), World.getGridSize() * World.getGridCountY());
				viewManager.getStage().setScene(currentScene);
				currentView.start();
				stop();
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
}
