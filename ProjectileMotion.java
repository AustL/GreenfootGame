import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ProjectileMotion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProjectileMotion extends World
{
    private final double velocityToLength = 0.75;
    
    private Button startButton;
    private Button backButton;
    private Button helpButton;
    private Button exitButton;

    private Slider angle;
    private Slider velocity;
    
    private Label time;
    private Label velocityLabel;
    private Label angleLabel;
    
    private Ball ball;

    private double maxHeight = 0;
    private double maxRange = 0;
    
    private boolean started = false;
    /**
     * Constructor for objects of class ProjectileMotion.
     * 
     */
    public ProjectileMotion() {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        prepare();
        setBackground(new GreenfootImage("Projectile Motion.png"));
    }
    
    public void act() {
        setBackground(new GreenfootImage("Projectile Motion.png"));
        
        if (startButton.mouseDown()) {
            begin();
        }

        if (backButton.mouseDown()) {
            Greenfoot.setWorld(new Menu());
        }
        
        if (exitButton.mouseUp()) {
            Greenfoot.stop();
        }
        
        // Display line
        if (!started) {
            ball.drawLine(velocity.getValue() * velocityToLength, angle.getValue());
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare() {
        startButton = new EllipseButton(948, 329, 187, 187, new Color(0, 148, 68, 0));
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
        
        angle = new Slider(141, 156, 336, 14, new Color(188, 190, 192), 20, 0, 90, new Color(57, 181, 74), new Color(0, 148, 68), new Color(0, 148, 68), 3);
        angle.addToWorld(this);
        
        velocity = new Slider(141, 210, 336, 14, new Color(188, 190, 192), 20, 0, 100, new Color(57, 181, 74), new Color(0, 148, 68), new Color(0, 148, 68), 3);
        velocity.addToWorld(this);
        
        angleLabel = new LinkedLabel(470, 144, 80, 36, new Color(57, 181, 74, 0), () -> String.format("%.02f", angle.getValue()), 30, new Color(0, 148, 68));
        angleLabel.addToWorld(this);
        
        velocityLabel = new LinkedLabel(470, 198, 80, 36, new Color(57, 181, 74, 0), () -> String.format("%.02f", velocity.getValue()), 30, new Color(0, 148, 68));
        velocityLabel.addToWorld(this);
        
        ball = new Ball(20, 0, 1);
        ball.addToWorld(this);
        
        time = new LinkedLabel(100, 500, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.02f", ball.getTime()), 40, new Color(0, 148, 68));
        time.addToWorld(this);
    }
    
    private void begin() {
        ball.setVelocity(velocity.getValue() * Math.cos(Math.toRadians(angle.getValue())), velocity.getValue() * Math.sin(Math.toRadians(angle.getValue())));
        startButton.disable();
        ball.showForces();
        started = true;
        ball.resume();
    }
}
