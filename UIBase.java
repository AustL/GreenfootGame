import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Base class for all user interface elements
 * 
 * @author Austin
 * @version 0
 */
public class UIBase extends Actor {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Color colour;
    
    protected boolean enabled = true;
    
    /**
     * Constructor for UIBase elements
     * 
     * @param x         The x-coordinate of the element's top left corner (pixels)
     * @param y         The y-coordinate of the element's top left corner (pixels)
     * @param width     The width of the widget
     * @param height    The height of the widget
     * @param colour    The background colour of the element
     */
    public UIBase(int x, int y, int width, int height, Color colour) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.colour = colour;
    }
    
    /**
     * Checks whether a coordinate is inside a UI element
     * 
     * @param x         The x-coordinate of the point to check
     * @param y         The y-cooridnate of the point to check
     */
    public boolean contains(int x, int y) {
        return this.x < x && x < this.x + this.width && this.y < y && y < this.y + this.height;
    }
    
    /**
     * Adds the UI element to the world
     * 
     * @param world     The world to add the element to
     */
    public void addToWorld(World world) {
        world.addObject(this, getXPos() + getWidth() / 2, getYPos() + getHeight() / 2);
    }
    
    // Getters
    public int getXPos() { return x; }
    
    public int getYPos() { return y; }
    
    public int getWidth() { return width; }
    
    public int getHeight() { return height; }
    
    public Color getColour() { return colour; }
    
    /**
     * Disable the UI element
     */
    public void disable() { enabled = false; }
    
    /**
     * Enable the UI element
     */
    public void enable() { enabled = true; }
}
