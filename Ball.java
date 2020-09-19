import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends RigidBody {
    private final int groundLevel = 70;
    
    public Ball(double x, double y) {
        super(x, y, 1);
        this.force = new Force(0, -9.8);
        
        createImage();
    }
    
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (!paused) {
            updatePosition();
            time += dt;
        }
        
        setLocation((int) position.getX(), getWorld().getHeight() - (int) position.getY() - groundLevel);
        createImage();
        if (forceVisible) {
            drawForce();
        }
    }
    
    protected void createImage() {
        getImage().scale(44, 44);
    }
    
    @Override
    public void addToWorld(World world) {
        world.addObject(this, (int) position.getX(), world.getHeight() - groundLevel - (int) position.getY());
    }

    public void setVelocity(double x, double y) {
        velocity = new Velocity(x, y);
    }
    
    public Position getPosition() {
        return position;
    }
    
    public Velocity getVelocity() {
        return velocity;
    }
    
    public Acceleration getAcceleration() {
        return acceleration;
    }
}
