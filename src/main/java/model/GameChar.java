package main.java.model;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.java.util.Consts;
import main.java.util.TextColor;

public class GameChar extends ImageView{
	int dim;
	
	AnimationTimer timer = new AnimationTimer() {
		int i = 0;
		int time = 20;
		@Override
		public void handle(long arg0) {
			if (i < time) {
				i++;
			} else {
				i = 0;
				stop();
			}
		}
		
	};

	public GameChar(char c, TextColor color, int x, int y) {
		Image img;
		String charColor = c + Consts.colorToString.get(color);
		if (Consts.charColorToFilePath.containsKey(charColor)) {
			img = new Image(Consts.charColorToFilePath.get(charColor), World.getGridSize()/2, World.getGridSize()/2, true, true);
		} else {
			img = new Image("file:src/main/resources/assets/char/char_space", World.getGridSize()/2, World.getGridSize()/2, true, true);
		}
		setImage(img);
		setX(x);
		setY(y);
	}
	
	public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
    
    public int getGridX() {
    	return (int) Math.floor((getX() + World.getGridSize()/2)/World.getGridSize());
    }
    
    public int getGridY() {
    	return (int) (getY())/World.getGridSize();
    }
    
    public void setGridX(int x) {
    	setX(x * World.getGridSize());
    }
    
    public void setGridY(int y) {
    	setY(y * World.getGridSize());
    }
    
    public void moveGrid(int dx, int dy) {
    	setGridX(getGridX() + dx);
    	setGridY(getGridY() + dy);
    }
    
    public double getCoordinateOfGrid(int coordinate) {
    	return coordinate * World.getGridSize();
    }
}
