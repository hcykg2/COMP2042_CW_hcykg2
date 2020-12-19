package main.java.model;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.java.util.TextColor;

public class ScoreboardView extends View {

	public ScoreboardView() {
		
		
		setBackground();
		
		try {
			File file = new File("src/main/resources/scores.txt");
			Scanner reader = new Scanner(file);
			if (file.createNewFile()) {
				System.out.println("file created");
			} else {
				System.out.println("file already exists");
			}
			
			int i = 0;
			while (reader.hasNextLine() && i < 10) {
				addText(reader.nextLine(), TextColor.YELLOW, 1, i + 2);
				i++;
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	private void setBackground() {
		blank = new ImageView(new Image("file:src/main/resources/assets/tile_water.png", World.getGridCountX() * getGridSize(), getGridCountY() * getGridSize(), false, true));
		getChildren().add(blank);
    	blank.setX(0);
    	blank.setY(0);
	}
}
