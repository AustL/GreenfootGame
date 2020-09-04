import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    private final int groundLevel = 70;
    
    private double time;
    
    private Position position = new Position();
    private Velocity velocity = new Velocity();
    private Acceleration acceleration = new Acceleration();
    private final double dt = 0.1;
    private double mass;
    private Force force;
    
    private boolean paused = false;
    private boolean forceVisible = false;
    
    public Ball(double x, double y, double mass) {
        this.position = new Position(x, y);
        this.mass = mass;
        this.force = new Force(0, -9.8 * mass);
        
        time = 0;
        
        createImage();
    }
    
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (!paused) {
            getUserInput();
            updatePosition();
            setLocation((int) position.getX(), getWorld().getHeight() - (int) position.getY() - groundLevel);
        }
        
        if (forceVisible) {
            drawForce();
        }
        
        time += dt;
    }
    
    private void createImage() {
        GreenfootImage image = new GreenfootImage(40, 40);
        image.setColor(new Color(39, 170, 225));
        image.fillOval(0, 0, 40, 40);
        setImage(image);
    }
    
    public void addToWorld(World world) {
        world.addObject(this, 20, world.getHeight() - groundLevel);
    }
    
    public void drawLine(double length, double angle) {
        angle = Math.toRadians(angle);
        
        int x1 = getX();
        int y1 = getY();
        int x2 = x1 + (int) (length * Math.cos(angle));
        int y2 = y1 - (int) (length * Math.sin(angle));
        
        GreenfootImage image = getWorld().getBackground();
        
        image.setColor(Color.BLACK);
        image.drawLine(x1, y1, x2, y2);
        
        getWorld().setBackground(image);
    }
    
    public void drawForce() {
        double angle = force.getAngle();
        double length = force.getMagnitude() * 5;

        drawLine(length, Math.toDegrees(angle));
    }
    
    public void updatePosition() {
        acceleration = force.getAcceleration(mass);
        velocity.updateWithAcceleration(acceleration, dt);
        position.updateWithVelocity(velocity, dt, getWorld().getWidth());
    }
    
    public void getUserInput() {
        if (Greenfoot.getKey() == "space") {
            applyForce(0, 10);
        }
    }
    
    public void showForces() {
        forceVisible = true;
    }
    
    public void applyForce(double x, double y) {
        force = (Force) force.add(new Force(x, y));
    }
    
    public void setVelocity(double x, double y) {
        velocity = new Velocity(x, y);
    }
    
    public void pause() { paused = true; }
    
    public void resume() { paused = false; }
    
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
