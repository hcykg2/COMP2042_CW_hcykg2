package view;

import javafx.scene.Scene;
import javafx.stage.Stage;
import model.View;
import model.World;

public class ViewManager {

	private View screen;
	private Scene scene;
	private Stage stage;
	
	public ViewManager() {
		screen = new View();
		scene = new Scene(screen, World.getGridSize() * World.getGridCountX(), World.getGridSize() * World.getGridCountY());
		
		stage = new Stage();
		screen.start();
		stage.setScene(scene);
		stage.show();
	}
	
	public Stage getStage() {
		return stage;
	}
	
	public View getScreen() {
		return screen;
	}
}