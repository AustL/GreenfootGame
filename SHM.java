import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SHM here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SHM extends World
{
    private Button startButton;
    private Button backButton;
    private Button helpButton;
    private Button exitButton;
    
    private Slider angle;
    private Slider radius;
    
    private Label time;
    private Label radiusLabel;
    private Label angleLabel;
    
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
        
        if (startButton.mouseDown()) {
            begin();
        }
        
        if (backButton.mouseDown()) {
            Greenfoot.setWorld(new Menu());
        }
        
        if (exitButton.mouseUp()) {
            Greenfoot.stop();
        }
        
        pendulum.setPosition(radius.getValue(), angle.getValue() + 270);
    }
    
    private void prepare() {
        startButton = new EllipseButton(948, 332, 187, 187, new Color(0, 148, 68, 0));
        startButton.addToWorld(this);
        startButton.setHoverColour(new Color(0, 148, 68, 120));
        
        backButton = new Button(33, 10, 80, 80, new Color(57, 181, 74, 0));
        backButton.addToWorld(this);
        backButton.setHoverColour(new Color(57, 181, 74, 140));
        
        helpButton = new Button(988, 10, 80, 80, new Color(57, 181, 74, 0));
        helpButton.addToWorld(this);
        helpButton.setHoverColour(new Color(57, 181, 74, 140));
        
        exitButton = new Button(1102, 10, 80, 80, new Color(57, 181, 74, 0));
        exitButton.addToWorld(this);
        exitButton.setHoverColour(new Color(57, 181, 74, 140));
        
        angle = new Slider(139, 633, 336, 14, new Color(188, 190, 192), 20, -90, 90, new Color(57, 181, 74), new Color(0, 148, 68), new Color(0, 148, 68), 3);
        angle.addToWorld(this);
        
        radius = new Slider(139, 687, 336, 14, new Color(188, 190, 192), 20, 0, 100, new Color(57, 181, 74), new Color(0, 148, 68), new Color(0, 148, 68), 3);
        radius.addToWorld(this);
        
        angleLabel = new LinkedLabel(470, 621, 80, 36, new Color(57, 181, 74, 0), () -> String.format("%.02f", angle.getValue()), 30, new Color(0, 148, 68));
        angleLabel.addToWorld(this);
        
        radiusLabel = new LinkedLabel(470, 675, 80, 36, new Color(57, 181, 74, 0), () -> String.format("%.02f", radius.getValue()), 30, new Color(0, 148, 68));
        radiusLabel.addToWorld(this);
        
        pendulum = new Pendulum(40, 315, 1);
        pendulum.addToWorld(this);
        
        time = new LinkedLabel(100, 400, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.02f", pendulum.getTime()), 40, new Color(0, 148, 68));
        time.addToWorld(this);
    }
    
    private void begin() {
        pendulum.resume();
    }
}
