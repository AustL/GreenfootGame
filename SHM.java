import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World representing the simple harmonic motion simulation
 * 
 * @author Austin
 * @version 0
 */
public class SHM extends Simulation { 
    private Slider angle;
    private Slider radius;
    
    private Label radiusLabel;
    private Label angleLabel;
    
    private Label time;
    private Label x;
    private Label v;
    private Label a;
    
    private Pendulum pendulum;

    /**
     * Constructor for objects of class SHM.
     */
    public SHM() {
        super();
        setBackground(new GreenfootImage("SHM.png"));
    }
    
    /**
     * Listen for mouse input for sliders and buttons
     */
    public void act() {
        super.act();
        
        setBackground(new GreenfootImage("SHM.png"));

        if (resetButton.mouseDown()) {
            Greenfoot.setWorld(new SHM());
        }
        
        // Sets the position of the pendulum for live feedback
        if (!started) {
            pendulum.setPosition(radius.getValue(), angle.getValue());
        }
    }
    
    /**
     * Create all objects and add them to the world
     */
    protected void prepare() {
        super.prepare();
        
        // Sliders
        angle = new Slider(139, 633, 336, 14, new Color(188, 190, 192), 20, 210, 330, new Color(57, 181, 74), new Color(0, 148, 68), new Color(0, 148, 68), 3);
        angle.addToWorld(this);
        
        radius = new Slider(139, 687, 336, 14, new Color(188, 190, 192), 20, 0, 400, new Color(57, 181, 74), new Color(0, 148, 68), new Color(0, 148, 68), 3);
        radius.addToWorld(this);
        
        // Labels for sliders
        angleLabel = new LinkedLabel(470, 621, 80, 36, new Color(57, 181, 74, 0), () -> String.format("%.02f", angle.getValue()), 30, new Color(0, 148, 68));
        angleLabel.addToWorld(this);
        
        radiusLabel = new LinkedLabel(470, 675, 80, 36, new Color(57, 181, 74, 0), () -> String.format("%.02f", radius.getValue()), 30, new Color(0, 148, 68));
        radiusLabel.addToWorld(this);
        
        pendulum = new Pendulum(200, 270);
        pendulum.addToWorld(this);
        
        // Output labels
        time = new LinkedLabel(945, 478, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.02f", pendulum.getTime()) + " s", 25, new Color(0, 148, 68));
        time.addToWorld(this);
        
        x = new LinkedLabel(945, 528, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.01f", pendulum.getPosition().getX()) + " m, " + String.format("%.01f", pendulum.getPosition().getY()) + " m", 25, new Color(0, 148, 68));
        x.addToWorld(this);
        
        v = new LinkedLabel(945, 578, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.01f", pendulum.getVelocity().getX()) + " ms⁻¹, " + String.format("%.01f", pendulum.getVelocity().getY()) + " ms⁻¹", 25, new Color(0, 148, 68));
        v.addToWorld(this);
        
        a = new LinkedLabel(945, 628, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.01f", pendulum.getAcceleration().getX()) + " ms⁻², " + String.format("%.01f", pendulum.getAcceleration().getY()) + " ms⁻²", 25, new Color(0, 148, 68));
        a.addToWorld(this);
    }
    
    /**
     * Starts the simulation with given inputs
     */
    protected void begin() {
        super.begin();
        
        pendulum.resume();
        angle.disable();
        radius.disable();
        pendulum.showForces();
    }
}
