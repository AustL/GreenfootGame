import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Moon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Moon extends RigidBody
{
    private final static double M = 5.972e24;
    private final static double G = 6.674e-11;
    private final static double m = 7.34767e22;
    private final static double r = 3.48e8;
    private final double earthX = 600;
    private final double earthY = 340;
    
    private double massInMoons;
    private double radiusMultiple;
    
    private double radius;
    
    public Moon(double x, double y, double massInMoons, double radiusMultiple) {
        super(x, y, massInMoons * m);
        
        this.massInMoons = massInMoons;
        this.force = new Force(0, 0);
        this.radiusMultiple = radiusMultiple;
        this.radius = radiusMultiple * r;
        
        createImage();
    }
    
    public void createImage() {
        getImage().scale((int) massInMoons * 50, (int) massInMoons * 50);
    }
    
    @Override
    protected void updatePosition() {
        double theta = Math.atan2(position.getY() - earthY, position.getX() - earthX);
        double magnitude = G * M * mass / (radius * radius);
        force = new Force(magnitude * Math.cos(theta), magnitude * Math.sin(theta));
        acceleration = force.getAcceleration(mass);
        velocity.updateWithAcceleration(acceleration, dt);
        position.updateWithVelocity(velocity, dt, getWorld().getWidth());
    }
    
    public void setPosition(double mass, double radius) {
        this.mass = mass * m;
        this.radius = radius * r;
    }
}
