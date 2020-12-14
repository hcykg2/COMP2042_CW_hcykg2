package app;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Screen;
import view.ViewManager;

public class Main extends Application {
	Screen background;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {	
		ViewManager viewManager = new ViewManager();
	    Screen screen = viewManager.getScreen();
	    Stage stage = viewManager.getStage();
	}
}
