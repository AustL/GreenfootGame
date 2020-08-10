/**
 * Write a description of class Force here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Force extends Vector
{
    public Force(double x, double y) {
        super(x, y);
    }
    
    public Force() {
        super(0, 0);
    }
    
    public Acceleration getAcceleration(double mass) {
        return new Acceleration(x / mass, y / mass);
    }

    public Force add(Force other) {
        return new Force(x + other.getX(), y + other.getY());
    }
}
