package main.java.model;

import java.io.File;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import main.java.model.actor.End;
import main.java.model.actor.Frog;

public class View extends World{
	
	public int beginX = 0;
	public int beginY = 0;
	MediaPlayer mediaPlayer;
	private Frog frog = null;
	public final ArrayList<End> endList = new ArrayList<End>();
	public int activatedEnds = 0;
	protected boolean isDone = false;
	
	@Override
	public void act(long now) {
		
	}

	public View() {
	}
	
	public View(int x, int y) {
		beginX = x;
		beginY = y;
	}
	
	public void playMusic() {
		String musicFile = "src/main/resources/assets/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}

	public void stopMusic() {
		mediaPlayer.stop();
	}
	
	public Frog getFrog() {
		return frog;
	}
	
	public void setFrog(Frog frog) {
		this.frog = frog;
	}
	
	public boolean getIsDone() {
		return isDone;
	}
	
	public void setIsDone(boolean done) {
		isDone = done;
	}
	
    AnimationTimer wipeTimer = new AnimationTimer() {
		@Override
		public void handle(long arg0) {
			if (blank.getY() > -World.getGridSize() * World.getGridSize()) {
				blank.setY(blank.getY() - 10);
			} else {
				stop();
			}
		}
    };

    ImageView blank;
    public void createWipe2() {
    	wipeTimer2 = new AnimationTimer() {
        	@Override
        	public void handle(long arg0) {
        		if (blank.getY() > 0) {
        			blank.setY(blank.getY() - 10);
        		} else {
        			setIsDone(true);
        			stop();
        		}
        	}
        };
    }
    AnimationTimer wipeTimer2;
    
    public void wipe() {
    	blank = new ImageView(new Image("file:src/main/resources/assets/tile_water.png", World.getGridCountX() * getGridSize(), getGridCountY() * getGridSize(), false, true));
    	getChildren().add(blank);
    	blank.setX(0);
    	blank.setY(0);
    	wipeTimer.start();
    }
    
    public void wipe2() {
    	blank = new ImageView(new Image("file:src/main/resources/assets/tile_water.png", World.getGridCountX() * getGridSize(), getGridCountY() * getGridSize(), false, true));
    	createWipe2();
    	getChildren().add(blank);
    	blank.setX(0);
    	blank.setY(World.getGridSize() * World.getGridCountY());
    	wipeTimer2.start();
    }
}
