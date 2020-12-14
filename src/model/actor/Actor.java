package model.actor;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import model.World;


public abstract class Actor extends ImageView {

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

    public World getWorld() {
        return (World) getParent();
    }

    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }
    
    public void manageInput(InputEvent e) {
        
    }
    
    public abstract double getSpeed();
    
    public abstract double getSpeedMultiplier();
    
    public abstract void setSpeedMultiplier(double s);
    
    public abstract boolean isStandable();

    public abstract void act(long now);

}
