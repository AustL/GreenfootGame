import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    private Position position = new Position();
    private Velocity velocity = new Velocity();
    private Acceleration acceleration = new Acceleration();
    private double dt = 0.1;
    private Force force = new Force();
    private double mass = 1;
    
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        getUserInput();
        updatePosition();
        setLocation((int) position.getX(), getWorld().getHeight() - (int) position.getY() - 60);
    }
    
    public void updatePosition() {
        acceleration = force.getAcceleration(mass);
        velocity.updateWithAcceleration(acceleration, dt);
        position.updateWithVelocity(velocity, dt, getWorld().getWidth());
    }
    
    public void getUserInput() {
        if (Greenfoot.getKey() == "space") {
            applyForce(10, 0);
        }
    }
    
    public void applyForce(double x, double y) {
        force = (Force) force.add(new Force(x, y));
    }
}
