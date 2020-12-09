package view;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.Row;
import model.Vehicle;

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
		add(new Vehicle("file:src/assets/car1.png", 2, 10, -1, 1));
		add(new Row("file:src/assets/grassRow.png", 13));
		add(new Row("file:src/assets/roadRow.png", 12));
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
