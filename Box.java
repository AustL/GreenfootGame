import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class representing the box object
 * 
 * @author Austin
 * @version 0
 */
public class Box extends RigidBody {
    private final int groundLevel = 71;
    
    private Force normal;
    private Force friction;
    private Force gravity;
    
    private Ramp ramp;
    
    private double mu;
    
    /**
     * Constructor for Box
     * 
     * @param ramp  The ramp which the box is linked to
     */
    public Box(Ramp ramp) {
        super(0, 0, 1);
        this.gravity = new Force(0, -9.8);
        
        this.ramp = ramp;
        
        this.position = new Position(0, ramp.getHeight());
        this.mu = 0;

        createImage();
    }
    
    /**
     * Update the position while running, else give visual feedback for sliders
     */
    public void act() {
        if (!paused) {
            updatePosition();
            time += dt;
        } else {
            position = new Position(0, ramp.getHeight());
            
            // Match angle of the ramp
            setRotation((int) Math.toDegrees(ramp.getAngle()));
        }

        setLocation((int) position.getX(), getWorld().getHeight() - (int) position.getY() - groundLevel);
        
        // Draw free body diagram if required
        if (forceVisible) {
            drawForce();
        }
    }
    
    
    /**
     * Draws all the forces (friction, normal, gravity and nett) acting on the box
     */
    @Override
    public void drawForce() {
        double angle = friction.getAngle();
        double length = friction.getMagnitude() * 10;

        drawLine(length, Math.toDegrees(angle), Color.BLACK);
        
        angle = gravity.getAngle();
        length = gravity.getMagnitude() * 10;

        drawLine(length, Math.toDegrees(angle), Color.BLACK);
        
        angle = normal.getAngle();
        length = normal.getMagnitude() * 10;

        drawLine(length, Math.toDegrees(angle), Color.BLACK);
        
        angle = force.getAngle();
        length = force.getMagnitude() * 10;

        drawLine(length, Math.toDegrees(angle), Color.RED);
    }
    
    /**
     * Updates the forces acting on the box and updates its position
     */
    @Override
    protected void updatePosition() {
        normal = calculateNormal();
        friction = calculateFriction();
        
        force = gravity.add(normal).add(friction);
        
        acceleration = force.getAcceleration(mass);
        velocity.updateWithAcceleration(acceleration, dt);
        position.updateWithVelocity(velocity, dt);
        
        // Add the bottom, set the rotation to 0 and hide the forces
        if (position.getY() == 0) {
            setRotation(0);
            hideForces();
        }
    }
    
    /**
     * Rescale the image to 44 x 44 pixels
     */
    protected void createImage() {
        getImage().scale(44, 44);
    }
    
    /**
     * Add the box to the world, accounting for ground
     * 
     * @param world The world to add the box to
     */
    @Override
    public void addToWorld(World world) {
        world.addObject(this, (int) position.getX(), world.getHeight() - groundLevel - (int) position.getY());
    }
    
    /**
     * Calculate the normal (reactive) force on the box by the ramp
     * 
     * @return      The normal force
     */
    private Force calculateNormal() {
        double theta = ramp.getAngle();
        double magnitude = mass * 9.8 * Math.cos(theta);
        double x = magnitude * Math.sin(theta);
        double y = magnitude * Math.cos(theta);

        return new Force(x, y);
    }
    
    /**
     * Calculate the frictional on the box by the ramp,
     * based on the coefficient of friction (mu)
     * 
     * @return      The frictional force
     */
    private Force calculateFriction() {
        double theta = Math.PI - ramp.getAngle();
        double magnitude = mu * calculateNormal().getMagnitude();
        magnitude = Math.min(Math.abs(gravity.getMagnitude() * Math.sin(theta)), magnitude);
        double x = magnitude * Math.cos(theta);
        double y = magnitude * Math.sin(theta);

        return new Force(x, y);
    }
    
    /**
     * Sets the coefficient of friction
     * 
     * @param mu    The coefficient of friction between the ramp and box
     */
    public void setMu(double mu) {
        this.mu = mu;
    }
}
