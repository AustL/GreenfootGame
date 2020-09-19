import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ramp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ramp extends Actor {
    private int height = 325;
    private int length = 575;
    private int[] x, y;

    public Ramp() {
    }
    
    /**
     * Act - do whatever the Ramp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        createImage();
    }
    
    public void createImage() {
        x = new int[]{0, 0, length};
        y = new int[]{0, height, height};
        
        GreenfootImage image = new GreenfootImage(length, height);
        
        image.setColor(new Color(57, 181, 74));
        image.fillPolygon(x, y, 3);
        setImage(image);
        
        setLocation(length / 2, 800 - (height / 2 + 50));
    }
    
    public void addToWorld(World world) {
        world.addObject(this, length / 2, 800 - (height / 2 + 50));
    }
    
    public void setLength(int length) {
        this.length = length;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public int getHeight() { return height; }
    
    public int getLength() { return length; }
    
    public double getAngle() { return Math.atan2(height, length); }
}
