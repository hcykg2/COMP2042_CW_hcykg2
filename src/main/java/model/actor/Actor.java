package main.java.model.actor;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import main.java.model.View;
import main.java.model.World;

/**
 * Actors are objects that can be seen in a view and performs an action every frame.
 * @author Kelvin
 *
 */
public abstract class Actor extends ImageView {
	
	/**
	 * Moves actor by dx and dy pixels
	 * @param dx horizontal displacement
	 * @param dy vertical displacement
	 */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
    
    /**
     * Returns the x grid coordinate of the actor
     * @return x grid coordinate of the actor
     */
    public int getGridX() {
    	return (int) Math.floor((getX() + World.getGridSize()/2)/World.getGridSize());
    }
    
    /**
     * Returns the y grid coordinate of the actor
     * @return y grid coordinate of the actor
     */
    public int getGridY() {
    	return (int) (getY() + World.getGridSize()/2)/World.getGridSize();
    }
    
    /**
     * Sets the x grid coordinate of the actor
     * @param x the x grid coordinate to set to
     */
    public void setGridX(int x) {
    	setX(x * World.getGridSize());
    }
    
    /**
     * Sets the x grid coordinate of the actor
     * @param y the y grid coordinate to set to
     */
    public void setGridY(int y) {
    	setY(y * World.getGridSize());
    }
    
    /**
     * Gets the pixel coordinate from grid coordinate
     * @param Coordinate grid coordinate
     * @return Pixel coordinate
     */
    public double getCoordinateOfGrid(int coordinate) {
    	return coordinate * World.getGridSize();
    }

    /**
     * Returns the view that the actor is in
     * @return The view that the actor is in
     */
    public View getView() {
        return (View) getParent();
    }

    /**
     * Returns the width of the actor
     * @return Width of the actor
     */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    /**
     * Returns the Height of the actor
     * @return Height of the actor
     */
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }
    
    /**
     * Returns the speed of the actor
     * @return Speed of the actor
     */
    public abstract double getSpeed();
    
    /**
     * Returns the speed multiplier of the actor
     * @return Speed multiplier of the actor
     */
    public abstract double getSpeedMultiplier();
    
    /**
     * Sets the speed multiplier of the actor
     * @param s Speed multiplier
     */
    public abstract void setSpeedMultiplier(double s);
    
    /**
     * Check if the actor is safe to be stood on by a frog
     * @return true if safe, false if not
     */
    public abstract boolean isStandable();

    
    /**
     * Action to be taken every frame
     * @param now
     */
    public abstract void act(long now);

}
