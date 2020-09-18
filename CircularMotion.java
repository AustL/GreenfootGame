import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CircularMotion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CircularMotion extends World {
    private Button startButton;
    private Button backButton;
    private Button helpButton;
    private Button exitButton;
    
    private Satellite satellite;
    
    private boolean started = false;
    
    /**
     * Constructor for objects of class CircularMotion.
     * 
     */
    public CircularMotion() {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        prepare();
        setBackground(new GreenfootImage("Circular Motion.png"));
    }
    
    public void act() {
        setBackground(new GreenfootImage("Circular Motion.png"));
        
        if (startButton.mouseDown()) {
            begin();
        }

        if (backButton.mouseDown()) {
            Greenfoot.setWorld(new Menu());
        }
        
        if (exitButton.mouseUp()) {
            Greenfoot.stop();
        }
    }
    
    private void prepare() {
        startButton = new Button(948, 329, 187, 187, new Color(0, 148, 68, 0));
        startButton.addToWorld(this);
        startButton.setHoverColour(new Color(0, 148, 68, 120));
        startButton.setBorderRadius(94);
        
        backButton = new Button(33, 10, 80, 80, new Color(57, 181, 74, 0));
        backButton.addToWorld(this);
        backButton.setHoverColour(new Color(57, 181, 74, 140));
        
        helpButton = new Button(988, 10, 80, 80, new Color(57, 181, 74, 0));
        helpButton.addToWorld(this);
        helpButton.setHoverColour(new Color(57, 181, 74, 140));
        
        exitButton = new Button(1102, 10, 80, 80, new Color(57, 181, 74, 0));
        exitButton.addToWorld(this);
        exitButton.setHoverColour(new Color(57, 181, 74, 140));
    }
    
    private void begin() {
        started = true;
        startButton.disable();
    }
}
