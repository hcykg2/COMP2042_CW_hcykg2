package model;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import view.End;
import view.World;


public class Frog extends Actor {
	Image imgW1;
	Image imgW2;
	int points = 0;
	int end = 0;
	boolean noMove = false;
	
	
	static double speed = 5;
	boolean isMoving = false;
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
		super(World.getGridSize(), World.getGridSize());
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
		if (carDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/assets/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/assets/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/assets/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				setX(300);
				setY(679.8+movement);
				carDeath = false;
				carD = 0;
				setImage(new Image("file:src/assets/froggerUp.png", imgSize, imgSize, true, true));
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}
			
		}
		if (waterDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/assets/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/assets/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/assets/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (carD == 4) {
				setImage(new Image("file:src/assets/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (carD == 5) {
				setX(300);
				setY(679.8+movement);
				waterDeath = false;
				carD = 0;
				setImage(new Image("file:src/assets/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}
			
		}
		if (getIntersectingObjects(Vehicle.class).size() >= 1) {
			carDeath = true;
		}
		if (getX() == 240 && getY() == 82) {
			stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=50;
			}
			points+=50;
			changeScore = true;
			w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setX(300);
			setY(679.8+movement);
		}
		else if (getY()<413){
			waterDeath = true;
			//setX(300);
			//setY(679.8+movement);
		}
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
