import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Box here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Box extends RigidBody {
    private final int groundLevel = 71;
    
    private Force normal;
    private Force friction;
    private Force gravity;
    
    private Ramp ramp;
    
    private double mu;
    
    public Box(Ramp ramp) {
        super(0, 0, 1);
        this.gravity = new Force(0, -9.8);
        
        this.ramp = ramp;
        
        this.position = new Position(0, ramp.getHeight());
        this.mu = 0;

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
        } else {
            position = new Position(0, ramp.getHeight());
            setRotation((int) Math.toDegrees(ramp.getAngle()));
        }

        setLocation((int) position.getX(), getWorld().getHeight() - (int) position.getY() - groundLevel);

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
        normal = calculateNormal();
        friction = calculateFriction();
        
        force = gravity.add(normal).add(friction);
        
        acceleration = force.getAcceleration(mass);
        velocity.updateWithAcceleration(acceleration, dt);
        position.updateWithVelocity(velocity, dt);
        
        if (position.getY() == 0) {
            setRotation(0);
            hideForces();
        }
    }
    
    protected void createImage() {
        getImage().scale(44, 44);
    }
    
    @Override
    public void addToWorld(World world) {
        world.addObject(this, (int) position.getX(), world.getHeight() - groundLevel - (int) position.getY());
    }

    private Force calculateNormal() {
        double theta = ramp.getAngle();
        double magnitude = mass * 9.8 * Math.cos(theta);
        double x = magnitude * Math.sin(theta);
        double y = magnitude * Math.cos(theta);

        return new Force(x, y);
    }
    
    private Force calculateFriction() {
        double theta = Math.PI - ramp.getAngle();
        double magnitude = mu * calculateNormal().getMagnitude();
        magnitude = Math.min(Math.abs(gravity.getMagnitude() * Math.sin(theta)), magnitude);
        double x = magnitude * Math.cos(theta);
        double y = magnitude * Math.sin(theta);

        return new Force(x, y);
    }
    
    public void setMu(double mu) {
        this.mu = mu;
    }
}
