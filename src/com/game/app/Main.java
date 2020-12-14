package com.game.app;

import com.game.controller.GameController;
import com.game.model.View;
import com.game.view.ViewManager;

import javafx.application.Application;
import javafx.stage.Stage;

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
