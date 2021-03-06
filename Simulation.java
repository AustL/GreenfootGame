import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Base class for all simulation worlds
 * 
 * @author Austin
 * @version 0
 */
public class Simulation extends World {
    protected Button startButton;
    protected Button backButton;
    protected Button resetButton;
    protected Button helpButton;
    protected Button exitButton;
    
    protected boolean started = false;
    
    /**
     * Constructor for objects of class Simulation.
     * 
     */
    public Simulation() {    
        // Create an unbounded new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1, false);
        prepare();
    }
    
    /**
     * Listen for start and top bar button presses
     */
    public void act() {      
        if (startButton.mouseDown()) {
            begin();
        }

        if (backButton.mouseDown()) {
            Greenfoot.setWorld(new Menu());
        }
        
        if (exitButton.mouseDown()) {
            Greenfoot.stop();
        }
    }
    
     /**
     * Create the start and top bar buttons and add them to the world
     */
    protected void prepare() {
        startButton = new Button(948, 329, 187, 187, new Color(0, 148, 68, 0));
        startButton.addToWorld(this);
        startButton.setHoverColour(new Color(0, 148, 68, 120));
        startButton.setBorderRadius(94);
        
        // Top bar buttons
        backButton = new Button(33, 10, 80, 80, new Color(57, 181, 74, 0));
        backButton.addToWorld(this);
        backButton.setHoverColour(new Color(57, 181, 74, 140));
        
        resetButton = new Button(875, 10, 80, 80, new Color(57, 181, 74, 0));
        resetButton.addToWorld(this);
        resetButton.setHoverColour(new Color(57, 181, 74, 140));
        
        helpButton = new Button(988, 10, 80, 80, new Color(57, 181, 74, 0));
        helpButton.addToWorld(this);
        helpButton.setHoverColour(new Color(57, 181, 74, 140));
        
        exitButton = new Button(1102, 10, 80, 80, new Color(57, 181, 74, 0));
        exitButton.addToWorld(this);
        exitButton.setHoverColour(new Color(57, 181, 74, 140));
    }
    
    /**
     * Begin the simulation and disable the start button
     */
    protected void begin() {
        started = true;
        startButton.disable();
    }
}
