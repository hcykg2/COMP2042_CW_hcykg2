package main.java.app;

import javafx.application.Application;
import javafx.stage.Stage;
import main.java.controller.GameController;
import main.java.model.View;
import main.java.view.ViewManager;

public class Main extends Application {
	View background;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {	
		ViewManager viewManager = new ViewManager();
		GameController gameController = new GameController(viewManager);
	    
	}
}
