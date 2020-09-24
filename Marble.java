import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Marble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Marble extends RigidBody {
    private Color colour;
    
    public Marble(double x, double y, double mass, Color colour) {
        super(x, y, mass);
        this.colour = colour;
        this.force = new Force();
    }
    
    protected void createImage() {
        GreenfootImage image = new GreenfootImage((int) (mass * 10), (int) (mass * 10));
        image.setColor(colour);
        image.fillOval(0, 0, (int) (mass * 10), (int) (mass * 10));
        setImage(image);
    }
    
    public void setMass(double mass) {
        this.mass = mass;
    }
    
    public void setVelocity(double velocity) {
        this.velocity = new Velocity(velocity, 0);
    }
}
