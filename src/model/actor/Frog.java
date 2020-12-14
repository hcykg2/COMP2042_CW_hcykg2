package model.actor;

import java.io.File;
import java.util.ArrayList;

import controller.CollisionController;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import model.World;

public class Frog extends Actor{
	Image imgW1;
	Image imgW2;
	private double speed = 5;
	private double speedMultiplier;
	boolean isStandable = false;
	boolean isMoving = false;
	boolean isDying = false;
	private int direction = 0;
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
	
	public Frog() {
		imgW1 = new Image("file:src/assets/frogUp.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/assets/frogUp2.png", imgSize, imgSize, true, true);
		setImage(imgW1);
		setGridX(6);
		setGridY(13);
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (!isMoving) {
					if (event.getCode() == KeyCode.W) {	            	
		                setDirection(0);
		                moveGrid.start();
		            }
		            else if (event.getCode() == KeyCode.A) {
		            	setDirection(3);
		                moveGrid.start();
		            }
		            else if (event.getCode() == KeyCode.S) {	            	
		            	setDirection(2);
		                moveGrid.start();
		            }
		            else if (event.getCode() == KeyCode.D) {
		            	setDirection(1);
		                moveGrid.start();
		            }
				}
			}
		});	
	}
	
	public void moveUp() {
		setDirection(0);
		moveGrid.start();
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
				if (direction == 0) {
					targetGrid = getGridY() - 1;
				} else if (direction == 1) {
					targetGrid = getGridX() + 1;
				} else if (direction == 2) {
					targetGrid = getGridY() + 1;
				} else if (direction == 3) {
					targetGrid = getGridX() - 1;
				}
				targetCoordinate = getCoordinateOfGrid(targetGrid);
				moved = 0;
				isMoving = true;
			} else {
				switch(direction) {
				case 0:
					move(0, -speed);
					break;
				case 1:
					move(speed, 0);
					break;
				case 2:
					move(0, speed);
					break;
				case 3:
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
			
			if (direction == 0 || direction == 2) {
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
		int i = 15;
		@Override
		public void handle(long now) {
			i--;
			if (i <= 0) {
				setImage(imgW1);
				i = 15;
				isMoving = false;
				stop();
			}
		}
	};
	
	@Override
	public void act(long now) {
//		if (CollisionController.getCollidedActors(getWorld(), this, Vehicle.class).size() > 0) {
//			System.out.println("wow");
//		}
		if (CollisionController.isStandingOnStandable(getWorld(), this).size() > 0) {
			double speed = CollisionController.isStandingOn(getWorld(), this, Actor.class).get(0).getSpeed();
			double speedMultiplier = CollisionController.isStandingOn(getWorld(), this, Actor.class).get(0).getSpeedMultiplier();
			move(speed * speedMultiplier, 0);
		}
		
	}
	
	public int getDirection() {
		return direction;
	}
	
	public void setDirection(int dir) {
		direction = dir;
		setRotate(dir * 90);
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
