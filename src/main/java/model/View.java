package main.java.model;

import java.io.File;
import java.util.ArrayList;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import main.java.model.actor.End;
import main.java.model.actor.Frog;

public class View extends World{
	
	public int beginX = 0;
	public int beginY = 0;
	MediaPlayer mediaPlayer;
	public final ArrayList<Frog> frogList = new ArrayList<Frog>();
	public final ArrayList<End> endList = new ArrayList<End>();
	public int activatedEnds = 0;
	
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
		String musicFile = "src/assets/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}

	public void stopMusic() {
		mediaPlayer.stop();
	}
	
	public Frog getFrog() {
		return frogList.get(0);
	}
}
