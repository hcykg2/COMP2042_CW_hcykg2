package view;

import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Screen;
import model.World;

public class ViewManager {

	private Screen screen;
	private Scene scene;
	private Stage stage;
	
	public ViewManager() {
		screen = new Screen();
		scene = new Scene(screen, World.getGridSize() * World.getGridCountX(), World.getGridSize() * World.getGridCountY());
		
		stage = new Stage();
		screen.start();
		stage.setScene(scene);
		stage.show();
	}
	
	public Stage getStage() {
		return stage;
	}
	
	public Screen getScreen() {
		return screen;
	}
}