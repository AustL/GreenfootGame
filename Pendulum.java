import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pendulum here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pendulum extends RigidBody
{
    private static final int anchorX = 600;
    private static final int anchorY = 563;

    private double radius;
    private Force tension;
    private Force gravity;

    public Pendulum(double radius, double theta) {
        super(anchorX + radius * Math.cos(Math.toRadians(theta)), anchorY + radius * Math.sin(Math.toRadians(theta)), 1);

        this.radius = radius;
        this.gravity = new Force(0, -9.8);
        this.tension = calculateTension(theta);
    }

    public void addToWorld(World world) {
        world.addObject(this, (int) position.getX(), world.getHeight() - (int) position.getY());
        createImage();
    }
    
    protected void createImage() {
        GreenfootImage image = new GreenfootImage(40, 40);
        image.setColor(new Color(39, 170, 225));
        image.fillOval(0, 0, 40, 40);
        setImage(image);
        
        image = getWorld().getBackground();
        
        image.setColor(new Color(57, 181, 74));
        image.drawLine(getX(), getY(), anchorX, getWorld().getHeight() - anchorY);
        getWorld().setBackground(image);
    }
    
    @Override
    public void drawForce() {
        double angle = tension.getAngle();
        double length = tension.getMagnitude() * 10;

        drawLine(length, Math.toDegrees(angle), Color.BLACK);
        
        angle = gravity.getAngle();
        length = gravity.getMagnitude() * 10;

        drawLine(length, Math.toDegrees(angle), Color.BLACK);
        
        angle = force.getAngle();
        length = force.getMagnitude() * 10;

        drawLine(length, Math.toDegrees(angle), Color.RED);
    }
    
    @Override
    protected void updatePosition() {
        double theta = Math.atan2(position.getY() - anchorY, position.getX() - anchorX);
        tension = calculateTension(theta);
        force = gravity.add(tension);
        acceleration = force.getAcceleration(mass);
        velocity.updateWithAcceleration(acceleration, dt);
        position.updateWithVelocity(velocity, dt);
    }
    
    public void setPosition(double radius, double theta) {
        this.radius = radius;
        
        theta = Math.toRadians(theta);
        double x = anchorX + radius * Math.cos(theta);
        double y = anchorY + radius * Math.sin(theta);
        position = new Position(x, y);
    }
    
    private Force calculateTension(double theta) {
        double magnitude = gravity.getMagnitude() * Math.sin(theta) - mass * velocity.getMagnitude() * velocity.getMagnitude() / radius;
        double x = magnitude * Math.cos(theta);
        double y = magnitude * Math.sin(theta);

        return new Force(x, y);
    }
}
