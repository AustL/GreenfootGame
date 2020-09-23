/**
 * Base class for all vector measurements
 * 
 * @author Austin
 * @version 0
 */
public class Vector {
    protected double x;
    protected double y;

    /**
     * Constructor for Vector
     * 
     * @param x     The x component of the vector
     * @param y     The y component of the vector
     */
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Get the magnitude of the vector
     * 
     * @return      The magnitude of the vector
     */
    public double getMagnitude() {
        return Math.hypot(x, y);
    }
    
    /**
     * Get the angle of the vector
     * 
     * @return      The angle of the vector in radians (0 for y = 0 and x > 0)
     */
    public double getAngle() {
        return Math.atan2(y, x);
    }
    
    // Getters
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    // Setters
    public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    /**
     * Add two Vectors
     * 
     * @param other     Another vector
     * @return          The resultant vector
     */
    public Vector add(Vector other) {
        return new Vector(x + other.getX(), y + other.getY());
    }
}
