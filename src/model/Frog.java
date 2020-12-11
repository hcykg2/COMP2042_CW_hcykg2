package model;

import java.util.ArrayList;

import controller.CollisionController;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Frog extends Actor {
	Image imgW1;
	Image imgW2;
	int points = 0;
	int end = 0;
	boolean noMove = false;
	
	
	static double speed = 5;
	boolean isMoving = false;
	boolean isDying = false;
	private int direction = 0;
	
	double movement = 13.3333333*2;
	int imgSize = World.getGridSize();
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean stop = false;
	boolean changeScore = false;
	int carD = 0;
	double w = 800;
	ArrayList<End> inter = new ArrayList<End>();
	
	public Frog() {
		imgW1 = new Image("file:src/assets/frogUp.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/assets/frogUp2.png", imgSize, imgSize, true, true);
		setImage(imgW1);
		setGridX(0);
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
					move (speed, 0);
					break;
				case 2:
					move(0, speed);
					break;
				case 3:
					move (-speed, 0);
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
					setImage(imgW1);
					setY(targetCoordinate);
					isMoving = false;
					stop();
				}
			} else {
				if (Math.abs(getX() - targetCoordinate) < speed) {
					setImage(imgW1);
					setX(targetCoordinate);
					isMoving = false;
					stop();
				}
			}
		}
	};
	
	@Override
	public void act(long now) {
//		if (CollisionController.getCollidedActors(getWorld(), this, Vehicle.class).size() > 0) {
//			System.out.println("wow");
//		}
//		System.out.println(getWorld().getHeight());
	}
	public boolean getStop() {
		return end==5;
	}
	
	public int getPoints() {
		return points;
	}
	
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	
	public int getDirection() {
		return direction;
	}
	
	public void setDirection(int dir) {
		direction = dir;
		setRotate(dir * 90);
	}
}
