import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CircularMotion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Collision extends Simulation {
    
    /**
     * Constructor for objects of class CircularMotion.
     * 
     */
    public Collision() {
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super();
        prepare();
        setBackground(new GreenfootImage("Collision.png"));
    }
    
    public void act() {
        super.act();
        
        setBackground(new GreenfootImage("Collision.png"));
        
        if (resetButton.mouseDown()) {
            Greenfoot.setWorld(new Collision());
        }
    }
    
    protected void prepare() {
        super.prepare();
        
        // Sliders
        
        
        // Labels for sliders
        
        
        // Output labels
    }
    
    protected void begin() {
        super.begin();
    }
}
