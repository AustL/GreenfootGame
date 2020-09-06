import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SHM here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SHM extends World
{
    private Button backButton;
    private Button helpButton;
    private Button exitButton;
    
    private Label time;
    
    private Pendulum pendulum;

    /**
     * Constructor for objects of class SHM.
     * 
     */
    public SHM()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        prepare();
        setBackground(new GreenfootImage("SHM.png"));
    }
    
    public void act() {
        setBackground(new GreenfootImage("SHM.png"));
        
        if (backButton.mouseDown()) {
            Greenfoot.setWorld(new Menu());
        }
        
        if (exitButton.mouseUp()) {
            Greenfoot.stop();
        }
    }
    
    private void prepare() {
        backButton = new Button(33, 10, 80, 80, new Color(57, 181, 74, 0));
        backButton.addToWorld(this);
        backButton.setHoverColour(new Color(57, 181, 74, 140));
        
        helpButton = new Button(988, 10, 80, 80, new Color(57, 181, 74, 0));
        helpButton.addToWorld(this);
        helpButton.setHoverColour(new Color(57, 181, 74, 140));
        
        exitButton = new Button(1102, 10, 80, 80, new Color(57, 181, 74, 0));
        exitButton.addToWorld(this);
        exitButton.setHoverColour(new Color(57, 181, 74, 140));
        
        pendulum = new Pendulum(40, 315, 1);
        pendulum.addToWorld(this);
        
        time = new LinkedLabel(100, 500, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.02f", pendulum.getTime()), 40, new Color(0, 0, 0));
        time.addToWorld(this);
    }
}
