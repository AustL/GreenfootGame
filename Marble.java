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
    }
    
    protected void createImage() {
        GreenfootImage image = new GreenfootImage((int) mass * 40, (int) mass * 40);
        image.fillOval(0, 0, (int) mass * 40, (int) mass * 40);
        setImage(image);
    }
    
    public void setVelocity(double velocity) {
        this.velocity = new Velocity(velocity, 0);
    }
    
    public void setMass(double mass) {
        this.mass = mass;
    }
}
