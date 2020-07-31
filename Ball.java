import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    private Position position = new Position(0, 0);
    private Velocity velocity = new Velocity(0, 0);
    private Acceleration acceleration = new Acceleration(0, -9.8);
    private double dt = 0.1;
    
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        getUserInput();
        updatePosition();
        setLocation((int) position.getX(), getWorld().getHeight() - (int) position.getY());
    }
    
    public void updatePosition() {
        velocity.updateWithAcceleration(acceleration, dt);
        position.updateWithVelocity(velocity, dt, getWorld().getWidth());
    }
    
    public void getUserInput() {
        if (Greenfoot.isKeyDown("up")) {
            velocity.setY(50);
        }
        
        if (Greenfoot.isKeyDown("left")) {
            acceleration.setX(-10);
        }
        
        if (Greenfoot.isKeyDown("right")) {
            acceleration.setX(10);
        }
    }
}
