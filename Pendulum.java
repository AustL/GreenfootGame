import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pendulum here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pendulum extends Actor
{
    private final int anchorX = 600;
    private final int anchorY = 563;
    
    private Position position = new Position();
    private Velocity velocity = new Velocity();
    private Acceleration acceleration = new Acceleration();
    private final double dt = 0.1;
    
    private double radius;
    private double mass;
    private Force tension;
    private Force gravity;
    
    private double theta;
    private double time;
    
    private boolean paused = true;
    
    public Pendulum(double radius, double theta, double mass) {
        setPosition(radius, theta);
        
        this.radius = radius;
        this.mass = mass;
        this.gravity = new Force(0, -9.8 * mass);
        this.tension = calculateTension(this.theta);
        time = 0;
    }

    /**
     * Act - do whatever the Pendulum wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (!paused) {
            time += dt;
            updatePosition();
        }

        setLocation((int) position.getX(), getWorld().getHeight() - (int) position.getY());
        createImage();
    }

    public void addToWorld(World world) {
        world.addObject(this, (int) position.getX(), world.getHeight() - (int) position.getY());
        createImage();
    }
    
    private void createImage() {
        GreenfootImage image = new GreenfootImage(40, 40);
        image.setColor(new Color(39, 170, 225));
        image.fillOval(0, 0, 40, 40);
        setImage(image);
        
        image = getWorld().getBackground();
        
        image.setColor(new Color(57, 181, 74));
        image.drawLine(getX(), getY(), anchorX, getWorld().getHeight() - anchorY);
        
        getWorld().setBackground(image);
    }
    
    public void setPosition(double radius, double theta) {
        theta = Math.toRadians(theta);
        double x = anchorX + radius * Math.cos(theta);
        double y = anchorY + radius * Math.sin(theta);
        position = new Position(x, y);
    }
    
    private void updatePosition() {
        theta = Math.atan2(position.getY() - anchorY, position.getX() - anchorX);
        tension = calculateTension(theta);

        Force nettForce = gravity.add(tension);
        acceleration = nettForce.getAcceleration(mass);
        velocity.updateWithAcceleration(acceleration, dt);
        position.updateWithVelocity(velocity, dt, getWorld().getWidth());
    }
    
    private Force calculateTension(double theta) {
        double magnitude = gravity.getMagnitude() * Math.sin(theta) - mass * velocity.getMagnitude() * velocity.getMagnitude() / radius;
        double x = magnitude * Math.cos(theta);
        double y = magnitude * Math.sin(theta);

        return new Force(x, y);
    }
    
    public void setRadius(double radius) { this.radius = radius; }
    
    public void setAngle(double angle) { this.theta = Math.toRadians(angle); }
    
    public void pause() { paused = true; }
    
    public void resume() { paused = false; }
    
    public double getTime() {
        return time;
    }
}
