import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World representing the friction simulation
 * 
 * @author Austin
 * @version 0
 */
public class Friction extends Simulation {
    private Slider height;
    private Slider length;
    private Slider mu;
    
    private Label heightLabel;
    private Label lengthLabel;
    private Label muLabel;
    
    private Label time;
    private Label x;
    private Label v;
    private Label a;
    
    private Ramp ramp;
    private Box box;
    
    /**
     * Constructor for objects of class Friction.
     */
    public Friction() {    
        super();
        setBackground(new GreenfootImage("Friction.png"));
    }
    
    /**
     * Listen for mouse input for sliders and buttons
     */
    public void act() {
        super.act();
        
        setBackground(new GreenfootImage("Friction.png"));
        
        if (resetButton.mouseDown()) {
            Greenfoot.setWorld(new Friction());
        }

        // Set attributes of ramp and box for live feedback
        if (!started) {
            ramp.setLength((int) length.getValue());
            ramp.setHeight((int) height.getValue());
            box.setMu(mu.getValue());
        }
    }
    
    /**
     * Create all objects and add them to the world
     */
    protected void prepare() {
        super.prepare();
        
        ramp = new Ramp();
        ramp.addToWorld(this);
        
        box = new Box(ramp);
        box.addToWorld(this);
        
        // Sliders
        height = new Slider(141, 156, 336, 14, new Color(188, 190, 192), 20, 150, 500, new Color(57, 181, 74), new Color(0, 148, 68), new Color(0, 148, 68), 3);
        height.addToWorld(this);
        
        length = new Slider(141, 210, 336, 14, new Color(188, 190, 192), 20, 150, 1000, new Color(57, 181, 74), new Color(0, 148, 68), new Color(0, 148, 68), 3);
        length.addToWorld(this);
        
        mu = new Slider(141, 264, 336, 14, new Color(188, 190, 192), 20, 0, 1, new Color(57, 181, 74), new Color(0, 148, 68), new Color(0, 148, 68), 3);
        mu.addToWorld(this);
        
        // Labels for sliders
        heightLabel = new LinkedLabel(470, 144, 80, 36, new Color(57, 181, 74, 0), () -> String.format("%.01f", height.getValue()), 30, new Color(0, 148, 68));
        heightLabel.addToWorld(this);
        
        lengthLabel = new LinkedLabel(470, 198, 80, 36, new Color(57, 181, 74, 0), () -> String.format("%.01f", length.getValue()), 30, new Color(0, 148, 68));
        lengthLabel.addToWorld(this);
        
        muLabel = new LinkedLabel(470, 252, 80, 36, new Color(57, 181, 74, 0), () -> String.format("%.02f", mu.getValue()), 30, new Color(0, 148, 68));
        muLabel.addToWorld(this);

        // Output labels
        time = new LinkedLabel(955, 45, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.02f", box.getTime()) + " s", 25, new Color(0, 148, 68));
        time.addToWorld(this);
        
        x = new LinkedLabel(955, 95, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.01f", box.getPosition().getX()) + " m, " + String.format("%.01f", box.getPosition().getY()) + " m", 25, new Color(0, 148, 68));
        x.addToWorld(this);
        
        v = new LinkedLabel(955, 145, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.01f", box.getVelocity().getX()) + " ms⁻¹, " + String.format("%.01f", box.getVelocity().getY()) + " ms⁻¹", 25, new Color(0, 148, 68));
        v.addToWorld(this);
        
        a = new LinkedLabel(955, 195, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.01f", box.getAcceleration().getX()) + " ms⁻², " + String.format("%.01f", box.getAcceleration().getY()) + " ms⁻²", 25, new Color(0, 148, 68));
        a.addToWorld(this);
    }
    
    /**
     * Starts the simulation with given inputs
     */
    protected void begin() {
        super.begin();
        box.resume();
        box.showForces();
        
        height.disable();
        length.disable();
        mu.disable();
    }
}
