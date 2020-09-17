import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Satellite here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Satellite extends RigidBody
{
    private final double M = 5.972e24;
    private final double G = 6.674e-11;
    private final double earthX = 1;
    private final double earthY = 1;
    
    public Satellite(double x, double y, double mass, double radius) {
        super(x, y, mass);
        
        this.force = new Force(0, -mass * M);
    }
    
    public void createImage() {
    }
}
