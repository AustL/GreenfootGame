
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class representing the ball object
 * 
 * @author Austin
 * @version 0
 */
public class Ball extends RigidBody {
    private final int groundLevel = 70;
    
    /**
     * Constructor for Ball
     * 
     * @param x     The initial x-position of the ball
     * @param y     The initial y-position of the ball
     */
    public Ball(double x, double y) {
        super(x, y, 1);
        this.force = new Force(0, -9.8);
        
        createImage();
    }
    
    /**
     * Update the ball's position and draw the image
     */
    public void act() {
        if (!paused) {
            updatePosition();
            time += dt;
        }
        
        setLocation((int) position.getX(), getWorld().getHeight() - (int) position.getY() - groundLevel);
        createImage();
        
        // Draw free body diagram if required
        if (forceVisible) {
            drawForce();
        }
    }
    
    /**
     * Rescale the tennis ball image to 44 x 44 pixels
     */
    protected void createImage() {
        getImage().scale(44, 44);
    }
    
    /**
     * Adds the ball to the world, accounting for the ground
     * 
     * @param world The world to add the ball to
     */
    @Override
    public void addToWorld(World world) {
        world.addObject(this, (int) position.getX(), world.getHeight() - groundLevel - (int) position.getY());
    }
    
    /**
     * Set the velocity of the ball
     * 
     * @param x     The x-velocity of the ball
     * @param y     The y-velocity of the ball
     */
    public void setVelocity(double x, double y) {
        velocity = new Velocity(x, y);
    }
}
