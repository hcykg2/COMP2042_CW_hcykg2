package com.game.view;

import com.game.model.View;
import com.game.model.World;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class ViewManager {

	private View currentView;
	private Scene currentScene;
	private Stage stage;
	
	public ViewManager() {
		stage = new Stage();
	}
	
	public Stage getStage() {
		return stage;
	}
	
	public Scene getScene() {
		return currentScene;
	}
	
	public View getView() {
		return currentView;
	}
	
	public void setView(View newView) {
		currentView = newView;
	}
	
	public void start() {
		currentScene = new Scene(currentView, World.getGridSize() * World.getGridCountX(), World.getGridSize() * World.getGridCountY());
		stage.setScene(currentScene);
		stage.show();
	}
}