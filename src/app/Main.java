package app;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Digit;
import model.Frog;
import model.Log;
import model.Turtle;
import model.WetTurtle;
import view.End;
import view.MyStage;
import view.World;

public class Main extends Application {
	AnimationTimer timer;
	MyStage background;
	Frog animal;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {	
	    background = new MyStage();
	    Scene scene  = new Scene(background, World.getGridSize() * World.getGridCountX(), World.getGridSize() * World.getGridCountY());
	    
	    animal = new Frog();
		
		background.add(new Log("file:src/assets/logs.png", 300, 0, 276, -2));
		background.add(new Log("file:src/assets/logs.png", 300, 400, 276, -2));
		background.add(new Log("file:src/assets/log3.png", 150, 50, 329, 0.75));
		background.add(new Log("file:src/assets/log3.png", 150, 270, 329, 0.75));
		background.add(new Log("file:src/assets/log3.png", 150, 490, 329, 0.75));
		
		background.add(new Turtle(500, 376, -1, 130, 130));
		background.add(new Turtle(300, 376, -1, 130, 130));
		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));
//		background.add(new End(13,96));
//		background.add(new End(141,96));
		background.add(new End(6, 1));
//		background.add(new End(141 + 141-13+141-13+1,96));
//		background.add(new End(141 + 141-13+141-13+141-13+3,96));
		background.add(animal);
		background.add(new Digit(0, 30, 360, 25));
		background.start();
		primaryStage.setScene(scene);
		primaryStage.show();
		
		start();  
	}
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
//            		background.stopMusic();
            		stop();
            		background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
            }
        };
    }
	public void start() {
//		background.playMusic();
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 360 - shift, 25));
    		  shift+=30;
    		}
    }
}
