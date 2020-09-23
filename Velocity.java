/**
 * Class representing the velocity vector
 * 
 * @author Austin
 * @version 0
 */
public class Velocity extends Vector {
    /**
     * Constructor for Velocity with starting values
     * 
     * @param x     The x component of velocity
     * @param y     The y component of velocity
     */
    public Velocity(double x, double y) {
        super(x, y);
    }
    
    /**
     * Constructor for a 0 Velocity
     */
    public Velocity() {
        super(0, 0);
    }
    
    /**
     * Updates the velocity with an acceleration over some time
     * 
     * @param acceleration  The accleration of the object with the velocity
     * @param dt            The time since the last update
     */
    public void updateWithAcceleration(Acceleration acceleration, double dt) {
        x += acceleration.getX() * dt;
        y += acceleration.getY() * dt;
    }
}
