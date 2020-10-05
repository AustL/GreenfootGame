import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World representing the projectile motion simulation
 * 
 * @author Austin
 * @version 0
 */
public class ProjectileMotion extends Simulation {
    private final double velocityToLength = 1.5;

    private Slider angle;
    private Slider velocity;
    
    private Label velocityLabel;
    private Label angleLabel;
    
    private Label time;
    private Label x;
    private Label v;
    private Label a;
    
    private Ball ball;

    /**
     * Constructor for objects of class ProjectileMotion.
     */
    public ProjectileMotion() {
        super();
        setBackground(new GreenfootImage("Projectile Motion.png"));
    }
    
    /**
     * Listen for mouse input for sliders and buttons
     */
    public void act() {
        super.act();
        
        setBackground(new GreenfootImage("Projectile Motion.png"));
               
        if (resetButton.mouseDown()) {
            Greenfoot.setWorld(new ProjectileMotion());
        }
        
        // Display line
        if (!started) {
            ball.drawLine(velocity.getValue() * velocityToLength, angle.getValue(), Color.RED);
        }
    }

    /**
     * Create all objects and add them to the world
     */
    protected void prepare() {
        super.prepare();
        
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
        time = new LinkedLabel(945, 45, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.02f", ball.getTime()) + " s", 25, new Color(0, 148, 68));
        time.addToWorld(this);
        
        x = new LinkedLabel(945, 95, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.01f", ball.getPosition().getX() - 20) + " m, " + String.format("%.01f", ball.getPosition().getY()) + " m", 25, new Color(0, 148, 68));
        x.addToWorld(this);
        
        v = new LinkedLabel(945, 145, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.01f", ball.getVelocity().getX()) + " ms⁻¹, " + String.format("%.01f", ball.getVelocity().getY()) + " ms⁻¹", 25, new Color(0, 148, 68));
        v.addToWorld(this);
        
        a = new LinkedLabel(945, 195, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.01f", ball.getAcceleration().getX()) + " ms⁻², " + String.format("%.01f", ball.getAcceleration().getY()) + " ms⁻²", 25, new Color(0, 148, 68));
        a.addToWorld(this);
    }
    
    /**
     * Starts the simulation with given inputs
     */
    protected void begin() {
        super.begin();
        ball.setVelocity(velocity.getValue() * Math.cos(Math.toRadians(angle.getValue())), velocity.getValue() * Math.sin(Math.toRadians(angle.getValue())));
        ball.showForces();
        ball.resume();
        angle.disable();
        velocity.disable();
    }
}
