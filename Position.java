/**
 * Write a description of class Position here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Position extends Vector 
{
    public Position(double x, double y) {
        super(x, y);
    }
    
    public Position() {
        super(0, 0);
    }
    
    public void updateWithVelocity(Velocity vel, double dt) {
        x += vel.getX() * dt;
        y += vel.getY() * dt;
        
        if (y <= 0) {
            y = 0;
            vel.setY(0);
        }
    }
}
