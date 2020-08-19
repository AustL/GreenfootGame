import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UIBase here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UIBase extends Actor
{
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Color colour;
    
    protected boolean enabled = true;
    
    public UIBase(int x, int y, int width, int height, Color colour) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.colour = colour;
    }
    
    public boolean contains(int x, int y) {
        return this.x < x && x < this.x + this.width && this.y < y && y < this.y + this.height;
    }
    
    public int getXPos() { return x; }
    
    public int getYPos() { return y; }
    
    public int getWidth() { return width; }
    
    public int getHeight() { return height; }
    
    public Color getColour() { return colour; }
    
    public void disable() { enabled = false; }
    
    public void enable() { enabled = true; }
}
