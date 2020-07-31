/**
 * Write a description of class Velocity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Velocity extends Vector 
{
    private final double maxVel = 50;
    
    public Velocity(double x, double y) {
        super(x, y);
    }
    
    public Velocity() {
        super(0, 0);
    }
    
    public void updateWithAcceleration(Acceleration acceleration, double dt) {
        x += acceleration.getX() * dt;
        y += acceleration.getY() * dt;
        
        if (x >= maxVel) {
            x = maxVel;
        } else if (x <= -maxVel) {
            x = -maxVel;
        }
        
        if (y >= maxVel) {
            y = maxVel;
        } else if (y <= -maxVel) {
            y = -maxVel;
        }
    }
}
