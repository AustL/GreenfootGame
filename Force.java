/**
 * Class representing force vectors
 * 
 * @author Austin 
 * @version 0
 */
public class Force extends Vector {
    /**
     * Constructor for Force with starting values
     * 
     * @param x     The x component of force
     * @param y     The y component of force
     */
    public Force(double x, double y) {
        super(x, y);
    }
    
    /**
     * Constructor for a 0 Force
     */
    public Force() {
        super(0, 0);
    }
    
    /**
     * Gets the acceleration of a mass when acted upon by the force
     * 
     * @param mass  The mass of the object
     * @return      The acceleration
     */
    public Acceleration getAcceleration(double mass) {
        return new Acceleration(x / mass, y / mass);
    }
    
    /**
     * Add two Forces. Can be chained
     * 
     * @param other     Another force
     * @return          The resultant force
     */
    public Force add(Force other) {
        return new Force(x + other.getX(), y + other.getY());
    }
}
