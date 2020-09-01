import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ProjectileMotion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProjectileMotion extends World
{
    private final double velocityToLength = 0.5;
    
    private Button startButton;
    private Slider angle;
    private Slider velocity;
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
        
        if (startButton.mouseUp()) {
            started = true;
            begin();
            startButton.disable();
            ball.showForces();
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
        startButton = new Button(800, 200, 300, 150, new Color(0, 0, 0, 50), "Begin", 50, new Color(0, 0, 0));
        startButton.addToWorld(this);
        startButton.setHoverColour(new Color(0, 0, 0, 100));
        
        angle = new Slider(161, 155, 293, 14, new Color(188, 190, 192), 18, 0, 90, new Color(57, 181, 74), new Color(0, 148, 68), new Color(0, 148, 68), 3);
        angle.addToWorld(this);
        
        velocity = new Slider(161, 261, 293, 14, new Color(188, 190, 192), 18, 0, 150, new Color(57, 181, 74), new Color(0, 148, 68), new Color(0, 148, 68), 3);
        velocity.addToWorld(this);
        
        ball = new Ball(20, 0, 1);
        ball.addToWorld(this);
    }
    
    private void begin() {
        ball.setVelocity(velocity.getValue() * Math.cos(Math.toRadians(angle.getValue())), velocity.getValue() * Math.sin(Math.toRadians(angle.getValue())));
    }
}
