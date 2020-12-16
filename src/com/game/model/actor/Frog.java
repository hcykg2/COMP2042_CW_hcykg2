package com.game.model.actor;

import java.io.File;
import java.util.ArrayList;

import com.game.controller.CollisionController;
import com.game.model.Bounds;
import com.game.model.World;
import com.game.util.Direction;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

public class Frog extends Actor{
	Image imgW1;
	Image imgW2;
	private int frogID;
	private double speed = 5;
	private double speedMultiplier;
	boolean isStandable = false;
	boolean isMoving = false;
	boolean isDying = false;
	private Direction direction = Direction.UP;
	int imgSize = World.getGridSize();
	ArrayList<End> inter = new ArrayList<End>();
	
	public void playMusic() {
		String musicFile = "src/assets/jump2.wav"; 
		Media sound = new Media(new File(musicFile).toURI().toString());
		AudioClip mediaPlayer = new AudioClip(sound.getSource());
	    mediaPlayer.play();
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public Frog(int id) {
		frogID = id;
		imgW1 = new Image("file:src/assets/frogUp.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/assets/frogUp2.png", imgSize, imgSize, true, true);
		setImage(imgW1);
		setGridX(6);
		setGridY(13);
	}
	
	public void tryMove(Direction dir) {
		if (!isMoving) {
			setDirection(dir);
			if (Bounds.canMoveInDirection(this, dir) && !isMoving) {
				moveGrid.start();
			}
		}
	}

	// GRID MOVEMENT
	
	AnimationTimer moveGrid = new AnimationTimer() {
		int targetGrid;
		double targetCoordinate;
		int moved;
		
		@Override
		public void handle(long now) {
			
			if (!isMoving) {
				setImage(imgW2);
				if (direction == Direction.UP) {
					targetGrid = getGridY() - 1;
				} else if (direction == Direction.RIGHT) {
					targetGrid = getGridX() + 1;
				} else if (direction == Direction.DOWN) {
					targetGrid = getGridY() + 1;
				} else if (direction == Direction.LEFT) {
					targetGrid = getGridX() - 1;
				}
				targetCoordinate = getCoordinateOfGrid(targetGrid);
				moved = 0;
				isMoving = true;
			} else {
				switch(direction) {
				case UP:
					move(0, -speed);
					break;
				case RIGHT:
					move(speed, 0);
					break;
				case DOWN:
					move(0, speed);
					break;
				case LEFT:
					move(-speed, 0);
					break;
				default:
					break;
				}
				moved += speed;
			}
			
			if (moved > 2 * World.getGridSize()) {
				isMoving = false;
				stop();
			}
			
			if (direction == Direction.UP || direction == Direction.DOWN) {
				if (Math.abs(getY() - targetCoordinate) < speed) {
					postMoveGrid.start();
					setY(targetCoordinate);
					stop();
				}
			} else {
				if (Math.abs(getX() - targetCoordinate) < speed) {
					postMoveGrid.start();
					setX(targetCoordinate);
					stop();
				}
			}
		}
	};
	
	AnimationTimer postMoveGrid = new AnimationTimer() {
		int time = 15;
		int i = time;
		@Override
		public void handle(long now) {
			i--;
			if (i <= 0) {
				setImage(imgW1);
				i = time;
				isMoving = false;
				stop();
			}
		}
	};
	
	AnimationTimer death = new AnimationTimer() {
		int time = 120;
		@Override
		public void handle(long arg0) {
			
		}
	};
	
	@Override
	public void act(long now) {
//		if (CollisionController.getCollidedActors(getWorld(), this, Vehicle.class).size() > 0) {
//			System.out.println("wow");
//		}
		if (CollisionController.isStandingOnStandable(getView(), this).size() > 0) {
			double speed = CollisionController.isStandingOn(getView(), this, Actor.class).get(0).getSpeed();
			double speedMultiplier = CollisionController.isStandingOn(getView(), this, Actor.class).get(0).getSpeedMultiplier();
			move(speed * speedMultiplier, 0);
		}
		
	}
	
	public int getID() {
		return frogID;
	}
	
	public boolean getIsMoving() {
		return isMoving;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(Direction dir) {
		direction = dir;
		setRotate(dir.getAngle());
	}
	
	public double getSpeedMultiplier() {
		return speedMultiplier;
	}
	
	public void setSpeedMultiplier(double s) {
		speedMultiplier = s;
	}
	
	public boolean isStandable() {
		return isStandable;
	}
}
