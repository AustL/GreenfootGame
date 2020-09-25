import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class representing the marble object
 * 
 * @author Austin
 * @version 0
 */
public class Marble extends RigidBody {
    private Color colour;
    
    /**
     * Constructor for Marble
     * 
     * @param x         The initial x position of the marble
     * @param y         The initial y position of the marble
     * @param mass      The initial mass of the marble
     * @param colour    The colour of the marble
     */
    public Marble(double x, double y, double mass, Color colour) {
        super(x, y, mass);
        this.colour = colour;
        this.force = new Force();
    }

    /**
     * Draws the marble as a coloured circle
     */
    protected void createImage() {
        GreenfootImage image = new GreenfootImage((int) (mass * 10), (int) (mass * 10));
        image.setColor(colour);
        image.fillOval(0, 0, (int) (mass * 10), (int) (mass * 10));  // The size depends on the mass
        setImage(image);
    }
    
    /**
     * Calculate the final velocity of the marble after a collision
     * 
     * @param u2    The initial velocity of the other marble
     * @param m2    The mass of the other marble
     */
    public void calculateFinalVelocity(double u2, double m2) {
        double u1 = velocity.getX();
        double m1 = mass;
        double v1 = u1 * (m1 - m2) / (m1 + m2) + u2 * 2 * m2 / (m1 + m2);
        
        velocity = new Velocity(v1, 0);
    }
    
    /**
     * Checks whether a collision has occured
     * 
     * @return      Whether a collision has occured
     */
    public boolean collided() {
        return isTouching(Marble.class);
    }
    
    /**
     * Sets the mass of the marble
     * 
     * @param mass  The mass to set the marble to
     */
    public void setMass(double mass) {
        this.mass = mass;
    }
    
    /**
     * Sets the initial x velocity of the marble
     * 
     * @param velocity  The velocity to set the marble to
     */
    public void setVelocity(double velocity) {
        this.velocity = new Velocity(velocity, 0);
    }
}
