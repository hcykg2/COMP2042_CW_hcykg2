package controller;

import javafx.animation.AnimationTimer;

// scoring, handle input, switch screens,
public class GameController {
	private int score;
	
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
