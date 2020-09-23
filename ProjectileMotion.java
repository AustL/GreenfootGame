import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World representing the projectile motion simulation
 * 
 * @author Austin
 * @version 0
 */
public class ProjectileMotion extends World
{
    private final double velocityToLength = 1.5;
    
    private Button startButton;
    private Button backButton;
    private Button resetButton;
    private Button helpButton;
    private Button exitButton;

    private Slider angle;
    private Slider velocity;
    
    private Label velocityLabel;
    private Label angleLabel;
    
    private Label time;
    private Label x;
    private Label v;
    private Label a;
    
    private Ball ball;

    private boolean started = false;
    /**
     * Constructor for objects of class ProjectileMotion.
     */
    public ProjectileMotion() {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        prepare();
        setBackground(new GreenfootImage("Projectile Motion.png"));
    }
    
    /**
     * Listen for mouse input for sliders and buttons
     */
    public void act() {
        setBackground(new GreenfootImage("Projectile Motion.png"));
        
        if (startButton.mouseDown()) {
            begin();
        }

        if (backButton.mouseDown()) {
            Greenfoot.setWorld(new Menu());
        }
        
        if (resetButton.mouseDown()) {
            Greenfoot.setWorld(new ProjectileMotion());
        }
        
        if (exitButton.mouseUp()) {
            Greenfoot.stop();
        }
        
        // Display line
        if (!started) {
            ball.drawLine(velocity.getValue() * velocityToLength, angle.getValue(), Color.RED);
        }
    }

    /**
     * Create all objects and add them to the world
     */
    private void prepare() {
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
        
        // Sliders
        angle = new Slider(141, 156, 336, 14, new Color(188, 190, 192), 20, 0, 90, new Color(57, 181, 74), new Color(0, 148, 68), new Color(0, 148, 68), 3);
        angle.addToWorld(this);
        
        velocity = new Slider(141, 210, 336, 14, new Color(188, 190, 192), 20, 0, 100, new Color(57, 181, 74), new Color(0, 148, 68), new Color(0, 148, 68), 3);
        velocity.addToWorld(this);
        
        // Labels for sliders
        angleLabel = new LinkedLabel(470, 144, 80, 36, new Color(57, 181, 74, 0), () -> String.format("%.02f", angle.getValue()), 30, new Color(0, 148, 68));
        angleLabel.addToWorld(this);
        
        velocityLabel = new LinkedLabel(470, 198, 80, 36, new Color(57, 181, 74, 0), () -> String.format("%.02f", velocity.getValue()), 30, new Color(0, 148, 68));
        velocityLabel.addToWorld(this);
        
        ball = new Ball(20, 0);
        ball.addToWorld(this);
        
        // Output labels
        time = new LinkedLabel(955, 45, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.02f", ball.getTime()) + " s", 25, new Color(0, 148, 68));
        time.addToWorld(this);
        
        x = new LinkedLabel(955, 95, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.01f", ball.getPosition().getX() - 20) + " m, " + String.format("%.01f", ball.getPosition().getY()) + " m", 25, new Color(0, 148, 68));
        x.addToWorld(this);
        
        v = new LinkedLabel(955, 145, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.01f", ball.getVelocity().getX()) + " ms⁻¹, " + String.format("%.01f", ball.getVelocity().getY()) + " ms⁻¹", 25, new Color(0, 148, 68));
        v.addToWorld(this);
        
        a = new LinkedLabel(955, 195, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.01f", ball.getAcceleration().getX()) + " ms⁻², " + String.format("%.01f", ball.getAcceleration().getY()) + " ms⁻²", 25, new Color(0, 148, 68));
        a.addToWorld(this);
    }
    
    /**
     * Starts the simulation with given inputs
     */
    private void begin() {
        ball.setVelocity(velocity.getValue() * Math.cos(Math.toRadians(angle.getValue())), velocity.getValue() * Math.sin(Math.toRadians(angle.getValue())));
        startButton.disable();
        ball.showForces();
        started = true;
        ball.resume();
    }
}
