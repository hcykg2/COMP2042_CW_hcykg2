package app;

import javafx.application.Application;
import javafx.stage.Stage;
import model.View;
import view.ViewManager;

public class Main extends Application {
	View background;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {	
		ViewManager viewManager = new ViewManager();
	    View screen = viewManager.getScreen();
	    Stage stage = viewManager.getStage();
	}
}
