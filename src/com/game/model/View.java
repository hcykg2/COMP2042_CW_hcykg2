package com.game.model;

import java.io.File;
import java.util.ArrayList;

import com.game.model.actor.End;
import com.game.model.actor.Frog;

import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class View extends World{
	
	MediaPlayer mediaPlayer;
	private ArrayList<Frog> frogList = new ArrayList<Frog>();
	
	@Override
	public void act(long now) {
		
	}

	public View() {
		
//		mediaPlayer.play();
//		mediaPlayer.setOnEndOfMedia(new Runnable() {
//
//			@Override
//			public void run() {
//				mediaPlayer.seek(Duration.ZERO);
//				
//			}
//			
//		});
//		mediaPlayer.play();
		
		addRow("file:src/assets/tile_water.png", 0, false);
		addRow("file:src/assets/tile_end_top.png", 1, false);
		addRow("file:src/assets/tile_end_bottom.png", 2, false);
		addRow("file:src/assets/tile_water.png", 3, false);
		addRow("file:src/assets/tile_water.png", 4, false);
		addRow("file:src/assets/tile_water.png", 5, false);
		addRow("file:src/assets/tile_grass.png", 6, false);
		addRow("file:src/assets/tile_road.png", 7, false);
		addRow("file:src/assets/tile_road.png", 8, false);
		addRow("file:src/assets/tile_road.png", 9, false);
		addRow("file:src/assets/tile_road.png", 10, false);
		addRow("file:src/assets/tile_road.png", 11, false);
		addRow("file:src/assets/tile_road.png", 12, false);
		addRow("file:src/assets/tile_grass.png", 13, false);
		addTurtles(0, 3, -1, 3);
		addTurtles(6, 3, -1, 3);
		addLog(2, 4, 1.5, 5);
		addLog(9, 4, 1.5, 5);
		addLog(0, 5, 1, 3);
		addLog(5, 5, 1, 3);
		addLog(10, 5, 1, 3);
		
		add(new End(6, 1));
		Frog frog = new Frog();
		add(frog);
		
		frogList.add(frog);
		
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
