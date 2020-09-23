/**
 * Class representing the position vector
 * 
 * @author Austin
 * @version 0
 */
public class Position extends Vector {
    /**
     * Constructor for Position with starting values
     * 
     * @param x     The x component of position
     * @param y     The y component of position
     */
    public Position(double x, double y) {
        super(x, y);
    }
    
    /**
     * Constructor for a 0 Position
     */
    public Position() {
        super(0, 0);
    }
    
    /**
     * Updates the position with a velocity over some time
     * 
     * @param vel   The velocity of the object with the position
     * @param dt    The time since the last update
     */
    public void updateWithVelocity(Velocity vel, double dt) {
        x += vel.getX() * dt;
        y += vel.getY() * dt;
        
        // Causes the object to bounce
        if (y <= 0) {
            y = 0;
            vel.setY(vel.getY() * -0.5);
        }
    }
}
