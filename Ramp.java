import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class representing the ramp
 * 
 * @author Austin
 * @version 0
 */
public class Ramp extends Actor {
    private int height = 325;
    private int length = 575;
    
    /**
     * Updates the image
     */
    public void act() {
        createImage();
    }
    
    /**
     * Displays the triangle with length and height to the screen
     */
    public void createImage() {
        // Vertices of triangle
        int[] x = new int[]{0, 0, length};
        int[] y = new int[]{0, height, height};
        
        GreenfootImage image = new GreenfootImage(length, height);
        
        // Draw the triangle to the screen
        image.setColor(new Color(57, 181, 74, 150));
        image.fillPolygon(x, y, 3);
        setImage(image);
        
        setLocation(length / 2, 800 - (height / 2 + 50));
    }
    
    /**
     * Adds the ramp to the world at the suitable location
     * 
     * @param world     The world to add the ramp to
     */
    public void addToWorld(World world) {
        world.addObject(this, length / 2, 800 - (height / 2 + 50));
    }
    
    /**
     * Sets the base length of the triangle
     * 
     * @param length    The length to set the ramp to
     */
    public void setLength(int length) {
        this.length = length;
    }
    
    /**
     * Sets the height of the triangle
     * 
     * @param height    The height to set the ramp to
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    // Getters
    public int getHeight() { return height; }
    
    public int getLength() { return length; }
    
    public double getAngle() { return Math.atan2(height, length); }
}
