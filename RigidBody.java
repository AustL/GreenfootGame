import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Abstract class which represents a physics object that is affected by forces
 * 
 * @author Austin
 * @version 0
 */
public abstract class RigidBody extends Actor {
    protected Position position = new Position();
    protected Velocity velocity = new Velocity();
    protected Acceleration acceleration = new Acceleration();
    protected double mass;
    protected Force force;
    
    protected double dt = 0.1;
    protected double time = 0;
    
    protected boolean paused = true;
    protected boolean forceVisible = false;
    
    /**
     * Constructor for RigidBody
     * 
     * @param x     The x-position of the object (-left and +right) in m
     * @param y     The y-position of the object (+up and -down) in m
     * @param mass  The mass of the object in kg
     */
    public RigidBody(double x, double y, double mass) {
        this.mass = mass;
        this.position = new Position(x, y);
    }
    
    /**
     * Default behaviour for any physics object
     */
    public void act() {
        // If not paused, update the position and time
        if (!paused) {
            updatePosition();
            time += dt;
        }
        
        setLocation((int) position.getX(), getWorld().getHeight() - (int) position.getY());
        createImage();
        
        // Draw free body diagram if required
        if (forceVisible) {
            drawForce();
        }
    }
    
    /**
     * All children must create their image
     */
    protected abstract void createImage();
    
    /**
     * Updates the position of the object with the forces acting on it
     */
    protected void updatePosition() {
        acceleration = force.getAcceleration(mass);
        velocity.updateWithAcceleration(acceleration, dt);
        position.updateWithVelocity(velocity, dt);
    }
    
    /**
     * Adds the object to the world (reversing y values to be +down)
     * 
     * @param world     The world to add the object to
     */
    public void addToWorld(World world) {
        world.addObject(this, (int) position.getX(), world.getHeight() - (int) position.getY());
    }
    
    /**
     * Draws a line in relation to the object
     * 
     * @param length    The length of the line in pixels
     * @param angle     The angle at which the line extends in degrees (0 to right)
     * @param colour    The colour of the line
     */
    public void drawLine(double length, double angle, Color colour) {
        angle = Math.toRadians(angle);
        
        int x1 = getX();
        int y1 = getY();
        int x2 = x1 + (int) (length * Math.cos(angle));
        int y2 = y1 - (int) (length * Math.sin(angle));
        
        GreenfootImage image = getWorld().getBackground();
        
        image.setColor(colour);
        image.drawLine(x1, y1, x2, y2);
        
        getWorld().setBackground(image);
    }
    
    /**
     * Draws the nett force acting on the object.
     * Can be overriden to show individual forces.
     */
    public void drawForce() {
        double angle = force.getAngle();
        double length = force.getMagnitude() * 5;

        drawLine(length, Math.toDegrees(angle), Color.RED);
    }
    
    /**
     * Shows the forces in a free body diagram
     */
    public void showForces() {
        forceVisible = true;
    }
    
    /**
     * Stops showing the forces
     */
    public void hideForces() {
        forceVisible = false;
    }
    
    /**
     * Stop updating the position
     */
    public void pause() { paused = true; }
    
    /**
     * Resume updating the position
     */
    public void resume() { paused = false   ; }
    
    // Getters
    public double getTime() {
        return time;
    }
    
    public double getMass() {
        return mass;
    }
    
    public Position getPosition() {
        return position;
    }
    
    public Velocity getVelocity() {
        return velocity;
    }
    
    public Acceleration getAcceleration() {
        return acceleration;
    }
}
