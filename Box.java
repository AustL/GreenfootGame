import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Box here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Box extends RigidBody {
    private final int groundLevel = 70;
    
    private Force normal;
    private Force friction;
    private Force gravity;
    
    private Ramp ramp;
    
    public Box(Ramp ramp) {
        super(0, 0, 1);
        this.force = new Force(0, -9.8);
        
        this.ramp = ramp;
        
        this.position = new Position(0, ramp.getHeight());

        createImage();
    }
    
    /**
     * Act - do whatever the Box wants to do. This method is called whenever
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
    
    @Override
    public void drawForce() {
        double angle = friction.getAngle();
        double length = friction.getMagnitude() * 10;

        drawLine(length, Math.toDegrees(angle), Color.BLACK);
        
        angle = gravity.getAngle();
        length = gravity.getMagnitude() * 10;

        drawLine(length, Math.toDegrees(angle), Color.BLACK);
        
        angle = normal.getAngle();
        length = normal.getMagnitude() * 10;

        drawLine(length, Math.toDegrees(angle), Color.BLACK);
        
        angle = force.getAngle();
        length = force.getMagnitude() * 10;

        drawLine(length, Math.toDegrees(angle), Color.RED);
    }
    
    @Override
    protected void updatePosition() {
        acceleration = force.getAcceleration(mass);
        velocity.updateWithAcceleration(acceleration, dt);
        position.updateWithVelocity(velocity, dt, getWorld().getWidth());
    }
    
    protected void createImage() {
        getImage().scale(44, 44);
        setRotation((int) Math.toDegrees(ramp.getAngle()));
    }
    
    @Override
    public void addToWorld(World world) {
        world.addObject(this, (int) position.getX(), world.getHeight() - groundLevel - (int) position.getY());
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
