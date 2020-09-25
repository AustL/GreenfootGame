import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World representing the elastic collision simulation
 * 
 * @author Austin
 * @version 0
 */
public class Collision extends Simulation {
    private Slider mass1;
    private Slider mass2;
    private Slider velocity1;
    private Slider velocity2;
    
    private Label massLabel1;
    private Label massLabel2;
    private Label velocityLabel1;
    private Label velocityLabel2;
    
    private Label time;
    private Label x1;
    private Label v1;
    private Label x2;
    private Label v2;
    
    private Marble marble1;
    private Marble marble2;

    /**
     * Constructor for objects of class Collision.
     */
    public Collision() {
        super();
        setBackground(new GreenfootImage("Collision.png"));
    }
    
    /**
     * Listen for mouse input for sliders and buttons
     */
    public void act() {
        super.act();
        
        setBackground(new GreenfootImage("Collision.png"));
        
        if (resetButton.mouseDown()) {
            Greenfoot.setWorld(new Collision());
        }
        
        if (!started) {
            marble1.setMass(mass1.getValue());
            marble2.setMass(mass2.getValue());
            
            marble1.setVelocity(velocity1.getValue());
            marble2.setVelocity(velocity2.getValue());
        } else {
            // Check for a collision and let the marble calculate its final velocity
            if (marble1.collided()) {
                double u1 = marble1.getVelocity().getX();
                double u2 = marble2.getVelocity().getX();
                double m1 = marble1.getMass();
                double m2 = marble2.getMass();
                
                marble1.calculateFinalVelocity(u2, m2);
                marble2.calculateFinalVelocity(u1, m1);
            }
        }
    }
    
    /**
     * Create all objects and add them to the world
     */
    protected void prepare() {
        super.prepare();
        
        marble1 = new Marble(200, 300, 8, Color.RED);
        marble1.addToWorld(this);
        
        marble2 = new Marble(800, 300, 8, Color.BLUE);
        marble2.addToWorld(this);
        
        // Sliders
        mass1 = new Slider(141, 156, 336, 14, new Color(188, 190, 192), 20, 1, 15, new Color(57, 181, 74), new Color(0, 148, 68), new Color(0, 148, 68), 3);
        mass1.addToWorld(this);
        
        mass2 = new Slider(141, 210, 336, 14, new Color(188, 190, 192), 20, 1, 15, new Color(57, 181, 74), new Color(0, 148, 68), new Color(0, 148, 68), 3);
        mass2.addToWorld(this);
        
        velocity1 = new Slider(141, 264, 336, 14, new Color(188, 190, 192), 20, -20, 20, new Color(57, 181, 74), new Color(0, 148, 68), new Color(0, 148, 68), 3);
        velocity1.addToWorld(this);
        
        velocity2 = new Slider(141, 318, 336, 14, new Color(188, 190, 192), 20, -20, 20, new Color(57, 181, 74), new Color(0, 148, 68), new Color(0, 148, 68), 3);
        velocity2.addToWorld(this);
        
        // Labels for sliders
        massLabel1 = new LinkedLabel(470, 144, 80, 36, new Color(57, 181, 74, 0), () -> String.format("%.01f", mass1.getValue()), 30, new Color(0, 148, 68));
        massLabel1.addToWorld(this);
        
        massLabel2 = new LinkedLabel(470, 198, 80, 36, new Color(57, 181, 74, 0), () -> String.format("%.01f", mass2.getValue()), 30, new Color(0, 148, 68));
        massLabel2.addToWorld(this);
        
        velocityLabel1 = new LinkedLabel(470, 252, 80, 36, new Color(57, 181, 74, 0), () -> String.format("%.01f", velocity1.getValue()), 30, new Color(0, 148, 68));
        velocityLabel1.addToWorld(this);
        
        velocityLabel2 = new LinkedLabel(470, 306, 80, 36, new Color(57, 181, 74, 0), () -> String.format("%.01f", velocity2.getValue()), 30, new Color(0, 148, 68));
        velocityLabel2.addToWorld(this);
        
        // Output labels
        time = new LinkedLabel(955, 45, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.02f", marble1.getTime()) + " s", 25, new Color(0, 148, 68));
        time.addToWorld(this);
        
        x1 = new LinkedLabel(50, 605, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.01f", marble1.getPosition().getX()) + " m", 25, new Color(0, 148, 68));
        x1.addToWorld(this);
        
        v1 = new LinkedLabel(50, 655, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.01f", marble1.getVelocity().getX()) + " ms⁻¹", 25, new Color(0, 148, 68));
        v1.addToWorld(this);
        
        x2 = new LinkedLabel(650, 605, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.01f", marble2.getPosition().getX()) + " m", 25, new Color(0, 148, 68));
        x2.addToWorld(this);
        
        v2 = new LinkedLabel(650, 655, 300, 200, new Color(0, 0, 0, 0), () -> String.format("%.01f", marble2.getVelocity().getX()) + " ms⁻¹", 25, new Color(0, 148, 68));
        v2.addToWorld(this);
    }
    
    /**
     * Starts the simulation with given inputs
     */
    protected void begin() {
        super.begin();

        marble1.resume();
        marble2.resume();

        mass1.disable();
        mass2.disable();
        velocity1.disable();
        velocity2.disable();
    }
}
