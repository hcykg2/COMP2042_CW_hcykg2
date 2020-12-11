package model;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;

import java.util.ArrayList;


public abstract class Actor extends ImageView{
	
	private double width;
	private double height;

    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
    
    public int getGridX() {
    	return (int) (getX() + World.getGridSize()/2)/World.getGridSize();
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

    public <A extends Actor> java.util.List<A> getCollidedActors(java.lang.Class<A> cls){
        ArrayList<A> collidedActors = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(getX() + 1, getY() + 1, width - 2, height - 2)) {
                collidedActors.add(actor);
            }
        }
        return collidedActors;
    }
    
    public void manageInput(InputEvent e) {
        
    }

    public abstract void act(long now);

}
