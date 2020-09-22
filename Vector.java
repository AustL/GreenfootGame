/**
 * Write a description of class Vector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vector
{
    protected double x;
    protected double y;

    /**
     * Constructor for objects of class Vector
     */
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getMagnitude() {
        return Math.hypot(x, y);
    }
    
    public double getAngle() {
        return Math.atan2(y, x);
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    public Vector add(Vector other) {
        return new Vector(x + other.getX(), y + other.getY());
    }
}
