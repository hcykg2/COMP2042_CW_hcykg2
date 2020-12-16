package com.game.model;

import java.io.File;
import java.util.ArrayList;

import com.game.model.actor.End;
import com.game.model.actor.Frog;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class View extends World{
	
	MediaPlayer mediaPlayer;
	public final ArrayList<Frog> frogList = new ArrayList<Frog>();
	public final ArrayList<End> endList = new ArrayList<End>();
	
	@Override
	public void act(long now) {
		
	}

	public View() {
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
