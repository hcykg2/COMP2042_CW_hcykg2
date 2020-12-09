package view;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import java.util.ArrayList;


public abstract class Actor extends ImageView{

    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
    
    public int getGridX() {
    	return (int) (getX() - World.gridOffsetX)/World.gridSize;
    }
    
    public int getGridY() {
    	return (int) (getY() - World.gridOffsetX)/World.gridSize;
    }
    
    public void setGridX(int x) {
    	setX(x * World.gridSize + World.gridOffsetX);
    }
    
    public double getCoordinateOfGridX(int x) {
    	return x * World.gridSize + World.gridOffsetX;
    }
    
    public double getCoordinateOfGridY(int y) {
    	return y * World.gridSize + World.gridOffsetX;
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

    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    public void manageInput(InputEvent e) {
        
    }

    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }

    public abstract void act(long now);

}
