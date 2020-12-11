package app;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Digit;
import model.End;
import model.Frog;
import model.MyStage;
import model.World;

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

		background.start();
		primaryStage.setScene(scene);
		primaryStage.show();
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
