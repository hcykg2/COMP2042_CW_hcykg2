package main.java.model.actor;

import java.io.File;
import java.util.ArrayList;

import com.sun.prism.paint.Stop;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import main.java.controller.CollisionController;
import main.java.model.Bounds;
import main.java.model.Tile;
import main.java.model.World;
import main.java.util.Consts;
import main.java.util.Direction;

public class Frog extends Actor{
	ArrayList<Image> normalDeathSprites = new ArrayList<Image>();
	ArrayList<Image> waterDeathSprites = new ArrayList<Image>();
	Image imgW1;
	Image imgW2;
	private int frogID;
	private double speed = 5;
	private double speedMultiplier;
	boolean isStandable = false;
	boolean isMoving = false;
	boolean isDying = false;
	boolean reachedEnd = false;
	private Direction direction = Direction.UP;
	int imgSize = World.getGridSize();
	ArrayList<End> inter = new ArrayList<End>();
	boolean forceStopMove = false;
	boolean doneFlag = false;
	
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
		normalDeathSprites.add(new Image("file:src/assets/frog_death_normal_0.png", World.getGridSize(), World.getGridSize(), true, true));
		normalDeathSprites.add(new Image("file:src/assets/frog_death_normal_1.png", World.getGridSize(), World.getGridSize(), true, true));
		normalDeathSprites.add(new Image("file:src/assets/frog_death_normal_2.png", World.getGridSize(), World.getGridSize(), true, true));
		normalDeathSprites.add(new Image("file:src/assets/frog_death_normal_3.png", World.getGridSize(), World.getGridSize(), true, true));
		
		waterDeathSprites.add(new Image("file:src/assets/frog_death_water_0.png", World.getGridSize(), World.getGridSize(), true, true));
		waterDeathSprites.add(new Image("file:src/assets/frog_death_water_1.png", World.getGridSize(), World.getGridSize(), true, true));
		waterDeathSprites.add(new Image("file:src/assets/frog_death_water_2.png", World.getGridSize(), World.getGridSize(), true, true));
		waterDeathSprites.add(new Image("file:src/assets/frog_death_water_3.png", World.getGridSize(), World.getGridSize(), true, true));
		setImage(imgW1);
		setGridX(6);
		setGridY(13);
	}
	
	public void tryMove(Direction dir) {
		if (!isMoving && !isDying) {
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
		int moved = 0;
		
		@Override
		public void handle(long now) {
			
			if (moved == 0) {
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
				isMoving = true;
			} 
			if (isMoving){
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
				forceStopMove = true;
				stop();
			}
			
			if (forceStopMove) {
				isMoving = false;
				forceStopMove = false;
				moved = 0;
				if(reachedEnd) {
					setImage(imgW1);
					setGridX(getView().beginX);
					setGridY(getView().beginY);
					getView().activatedEnds++;
					reachedEnd = false;
				}
				stop();
			}

			if (direction == Direction.UP || direction == Direction.DOWN) {
				if (Math.abs(getY() - targetCoordinate) < speed) {
					postMoveGrid.start();
					setY(targetCoordinate);
					moved = 0;
					stop();
				}
			} else if (Math.abs(getX() - targetCoordinate) < speed) {
				postMoveGrid.start();
				setX(targetCoordinate);
				moved = 0;
				stop();
			}
		}
	};
	
	AnimationTimer postMoveGrid = new AnimationTimer() {
		int time = 15;
		int i = time;
		@Override
		public void handle(long now) {
			
			if (forceStopMove) {
				System.out.println("test");
				isMoving = false;
				forceStopMove = false;
				i = time;
				if(reachedEnd) {
					setImage(imgW1);
					setGridX(getView().beginX);
					setGridY(getView().beginY);
					getView().activatedEnds++;
					reachedEnd = false;
				}
				stop();
			}
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
		int i = 0;
		int sprite = -1;
		int time = 60;
		@Override
		public void handle(long arg0) {
			if (sprite == -1) {
				if (isMoving) {
					forceStopMove = true;
				}
				setDirection(Direction.UP);
				setImage(normalDeathSprites.get(0));
				isDying = true;
				sprite = 0;
			}
			if (i < time) {
				i++;
			} else if (sprite < normalDeathSprites.size() - 1) {
				sprite++;
				i = 0;
				setImage(normalDeathSprites.get(sprite));
			} else {
				setGridX(getView().beginX);
				setGridY(getView().beginY);
				setImage(imgW1);
				i = 0;
				sprite = -1;
				isDying = false;
				stop();
			}
		}
	};
	
	AnimationTimer deathWater = new AnimationTimer() {
		int i = 0;
		int sprite = -1;
		int time = 60;
		@Override
		public void handle(long arg0) {
			if (sprite == -1) {
				if (isMoving) {
					forceStopMove = true;
				}
				setDirection(Direction.UP);
				setImage(waterDeathSprites.get(0));
				isDying = true;
				sprite = 0;
			}
			if (i < time) {
				i++;
			} else if (sprite < waterDeathSprites.size() - 1) {
				sprite++;
				i = 0;
				setImage(waterDeathSprites.get(sprite));
			} else {
				setGridX(getView().beginX);
				setGridY(getView().beginY);
				setImage(imgW1);
				i = 0;
				sprite = -1;
				isDying = false;
				stop();
			}
		}
	};
	
	@Override
	public void act(long now) {
		if (CollisionController.getCollidedActors(getView(), this, Vehicle.class).size() > 0 && !isDying) {
			death.start();
		}
		
		ArrayList<Tile> tiles = CollisionController.isStandingOnTile(getView(), this);
		
		if (CollisionController.isStandingOnStandable(getView(), this).size() > 0 && !isDying) {
			double speed = CollisionController.isStandingOn(getView(), this, Actor.class).get(0).getSpeed();
			double speedMultiplier = CollisionController.isStandingOn(getView(), this, Actor.class).get(0).getSpeedMultiplier();
			move(speed * speedMultiplier, 0);
		} else if (tiles.size() > 0) {
			for (int i = 0; i < tiles.size(); i++) {
				if (!isMoving && !tiles.get(i).isSafe) {
					deathWater.start();
				}
			}
		}
		
		ArrayList<End> collidedEnds = CollisionController.getCollidedEnds(getView(), this);
		
		if (collidedEnds.size() > 0) {
			for (int i = 0; i < collidedEnds.size(); i ++) {
				collidedEnds.get(i).setActivated(true);
			}
			
			if (isMoving) {
				reachedEnd = true;
				forceStopMove = true;
			} else {
				setImage(imgW1);
				setGridX(getView().beginX);
				setGridY(getView().beginY);
				getView().activatedEnds++;
				reachedEnd = false;
			}
		}
		
		if (Bounds.isOutOfBounds(this)) {
			death.start();
		}
		
		if (getView().getIsLevel() && getView().activatedEnds >= getView().endList.size() && doneFlag == false) {
			System.out.println("hmmmm");
			doneFlag = true;
			getView().wipe2();
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
