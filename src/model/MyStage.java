package model;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MyStage extends World{
	MediaPlayer mediaPlayer;
	@Override
	public void act(long now) {
		
	}
	
	public MyStage() {
		
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
//		add(new Turtle(1, 3, -1));
//		add(new Turtle(2, 3, -1));
		
		add(new End(6, 1));
		add(new Frog());
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
}
