/**
 * Class representing acceleration vectors
 * 
 * @author Austin
 * @version 0
 */
public class Acceleration extends Vector {
    /**
     * Constructor for Acceleration with starting values
     * 
     * @param x     The x component of acceleration
     * @param y     The y component of acceleration
     */
    public Acceleration(double x, double y) {
        super(x, y);
    }
    
    /**
     * Constructor for a 0 Acceleration
     */
    public Acceleration() {
        super(0, 0);
    }
}
