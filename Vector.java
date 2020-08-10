/**
 * Write a description of class Vector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vector
{
    // instance variables - replace the example below with your own
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
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
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
}
