package controller;

import javafx.animation.AnimationTimer;
import model.View;
import view.ViewManager;

// scoring, handle input, switch screens,
public class GameController {
	private int score;
	private View currentScreen;
	private ViewManager viewManager;
	
	public GameController(ViewManager viewManager) {
		this.viewManager = viewManager;
	}
	
	AnimationTimer gameLoop = new AnimationTimer() {

		@Override
		public void handle(long arg0) {
			
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
