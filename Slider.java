import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Slider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Slider extends UIBase {
    private int r;
    private double min;
    private double max;
    private Color handleColour;
    private Color handleBorderColour;
    private Color borderColour;
    private int border;
    
    private double value;
    
    /**
     * Constructor for Slider
     * 
     * @param x                     Top left coordinate x
     * @param y                     Top left coordinate y
     * @param width                 Width of slider
     * @param height                Height of slider
     * @param colour                Background colour of slider
     * @param r                     Radius of slider handle
     * @param min                   Minimum value of the slider
     * @param max                   Maxiumum value of the slider
     * @param handleColour          Colour of the handle
     * @param handleBorderColour    Border colour of the handle
     * @param borderColour          Border colour of the slider
     * @param border                Border width
     */
    public Slider(int x, int y, int width, int height, Color colour, int r, double min, double max, Color handleColour, Color handleBorderColour, Color borderColour, int border) {
        super(x, y, width, height, colour);
        this.r = r;
        this.min = min;
        this.max = max;
        this.handleColour = handleColour;
        this.handleBorderColour = handleBorderColour;
        this.borderColour = borderColour;
        this.border = border;
        
        this.value = (min + max) / 2;
        
        createImage();
    }
    
    /**
     * Listen for a mouse drag
     */
    public void act() {
        if (enabled) {
            if (Greenfoot.mouseDragged(this)) {
                MouseInfo mouse = Greenfoot.getMouseInfo();
                if (mouse != null) drag(mouse.getX());
            }
        }
    }
    
    /**
     * Update the value of the slider based on the mouse's x-position
     * 
     * @param mouseX    The x-coordinate of the mouse
     */
    public void drag(int mouseX) {
        value = (mouseX - this.x) / (double) width * (max - min) + min;
        value = Math.max(Math.min(value, max), min);
        createImage();
    }
    
    /**
     * Draw the rectangle and border for the slider
     * Draw the circle and border for the handle
     */
    private void createImage() {
        GreenfootImage image = new GreenfootImage(width, r * 2);
        image.setColor(borderColour);
        image.fillRect(r, (r * 2 - height) / 2, width - r * 2, height);
        image.setColor(colour);
        image.fillRect(r + border, (r * 2 - height) / 2 + border, width - r * 2 - border * 2, height - border * 2);
        image.setColor(handleBorderColour);
        image.fillOval((int) ((value - min) / (max - min) * (width - 2 * r)), 0, r * 2, r * 2);
        image.setColor(handleColour);
        image.fillOval((int) ((value - min) / (max - min) * (width - 2 * r)) + border, border, (r - border) * 2, (r - border) * 2);
        setImage(image);
    }
    
    /**
     * Get the value of the slider
     * 
     * @return      The value of the slider rounded to 2 decimal places
     */
    public double getValue() { return Math.round(value * 100.0) / 100.0; }
}
