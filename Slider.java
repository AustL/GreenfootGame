import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Slider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Slider extends UIBase
{
    private int r;
    private double min;
    private double max;
    private Color handleColour;
    private Color handleBorderColour;
    private Color borderColour;
    private int border;
    
    private double value;
    
    private boolean selected = false;
    
    public Slider(int x, int y, int width, int height, Color colour, int r, int min, int max, Color handleColour, Color handleBorderColour, Color borderColour, int border) {
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
     * Act - do whatever the Slider wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (Greenfoot.mouseDragged(this)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse != null) drag(mouse.getX());
        }
    }
    
    public void drag(int mouseX) {
        value = (mouseX - this.x) / (double) width * max + min;
        value = Math.max(Math.min(value, max), min);
        createImage();
    }
    
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
    
    public double getValue() { return Math.round(value * 100.0) / 100.0; }
}
