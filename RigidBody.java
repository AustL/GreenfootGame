import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RigidBody here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class RigidBody extends Actor
{
    protected Position position = new Position();
    protected Velocity velocity = new Velocity();
    protected Acceleration acceleration = new Acceleration();
    protected double mass;
    protected Force force;
    
    protected double dt = 0.1;
    protected double time = 0;
    
    protected boolean paused = true;
    protected boolean forceVisible = false;

    public RigidBody(double x, double y, double mass) {
        this.mass = mass;
        this.position = new Position(x, y);
    }
    
    public void act() {
        if (!paused) {
            updatePosition();
            time += dt;
        }
        
        setLocation((int) position.getX(), getWorld().getHeight() - (int) position.getY());
        createImage();
        if (forceVisible) {
            drawForce();
        }
    }
    
    protected abstract void createImage();
    
    protected void updatePosition() {
        acceleration = force.getAcceleration(mass);
        velocity.updateWithAcceleration(acceleration, dt);
        position.updateWithVelocity(velocity, dt);
    }
    
    public void addToWorld(World world) {
        world.addObject(this, (int) position.getX(), world.getHeight() - (int) position.getY());
    }
    
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
    
    public void drawForce() {
        double angle = force.getAngle();
        double length = force.getMagnitude() * 5;

        drawLine(length, Math.toDegrees(angle), Color.RED);
    }
    
    public void showForces() {
        forceVisible = true;
    }
    
    public void hideForces() {
        forceVisible = false;
    }
    
    public void pause() { paused = true; }
    
    public void resume() { paused = false; }
    
    public double getTime() {
        return time;
    }
}
