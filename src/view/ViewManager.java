package view;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ViewManager {
	
	private static final int HEIGHT = 800;
	private static final int WIDTH = 600;
	private AnchorPane primaryPane;
	private Scene primaryScene;
	private Stage primaryStage;
	
	public ViewManager() {
		primaryPane = new AnchorPane();
		primaryScene = new Scene(primaryPane, WIDTH, HEIGHT);
		primaryStage = new Stage();
		
		primaryStage.setScene(primaryScene);
		primaryStage.show();
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
}