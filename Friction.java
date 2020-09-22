import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Friction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Friction extends World {
    private Button startButton;
    private Button backButton;
    private Button resetButton;
    private Button helpButton;
    private Button exitButton;
    
    private Slider height;
    private Slider length;
    private Slider mu;
    
    private Label heightLabel;
    private Label lengthLabel;
    private Label muLabel;
    
    private Label time;
    
    private Ramp ramp;
    private Box box;
    
    private boolean started = false;
    
    /**
     * Constructor for objects of class Friction.
     * 
     */
    public Friction() {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        prepare();
        setBackground(new GreenfootImage("Friction.png"));
    }
    
    public void act() {
        setBackground(new GreenfootImage("Friction.png"));
        
        if (startButton.mouseDown()) {
            begin();
        }

        if (backButton.mouseDown()) {
            Greenfoot.setWorld(new Menu());
        }
        
        if (resetButton.mouseDown()) {
            Greenfoot.setWorld(new Friction());
        }
        
        if (exitButton.mouseUp()) {
            Greenfoot.stop();
        }
        
        if (!started) {
            ramp.setLength((int) length.getValue());
            ramp.setHeight((int) height.getValue());
            box.setMu(mu.getValue());
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
        
        resetButton = new Button(875, 10, 80, 80, new Color(57, 181, 74, 0));
        resetButton.addToWorld(this);
        resetButton.setHoverColour(new Color(57, 181, 74, 140));
        
        helpButton = new Button(988, 10, 80, 80, new Color(57, 181, 74, 0));
        helpButton.addToWorld(this);
        helpButton.setHoverColour(new Color(57, 181, 74, 140));
        
        exitButton = new Button(1102, 10, 80, 80, new Color(57, 181, 74, 0));
        exitButton.addToWorld(this);
        exitButton.setHoverColour(new Color(57, 181, 74, 140));
        
        height = new Slider(141, 210, 336, 14, new Color(188, 190, 192), 20, 150, 500, new Color(57, 181, 74), new Color(0, 148, 68), new Color(0, 148, 68), 3);
        height.addToWorld(this);
        
        length = new Slider(141, 156, 336, 14, new Color(188, 190, 192), 20, 150, 1000, new Color(57, 181, 74), new Color(0, 148, 68), new Color(0, 148, 68), 3);
        length.addToWorld(this);
        
        mu = new Slider(141, 264, 336, 14, new Color(188, 190, 192), 20, 0, 1, new Color(57, 181, 74), new Color(0, 148, 68), new Color(0, 148, 68), 3);
        mu.addToWorld(this);
        
        heightLabel = new LinkedLabel(470, 144, 80, 36, new Color(57, 181, 74, 0), () -> String.format("%.01f", height.getValue()), 30, new Color(0, 148, 68));
        heightLabel.addToWorld(this);
        
        lengthLabel = new LinkedLabel(470, 198, 80, 36, new Color(57, 181, 74, 0), () -> String.format("%.01f", length.getValue()), 30, new Color(0, 148, 68));
        lengthLabel.addToWorld(this);
        
        muLabel = new LinkedLabel(470, 252, 80, 36, new Color(57, 181, 74, 0), () -> String.format("%.03f", mu.getValue()), 30, new Color(0, 148, 68));
        muLabel.addToWorld(this);
        
        ramp = new Ramp();
        ramp.addToWorld(this);
        
        box = new Box(ramp);
        box.addToWorld(this);
        
        time = new LinkedLabel(100, 500, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.02f", box.getTime()), 40, new Color(0, 148, 68));
        time.addToWorld(this);
    }
    
    private void begin() {
        started = true;
        startButton.disable();
        box.resume();
        box.showForces();
    }
}
