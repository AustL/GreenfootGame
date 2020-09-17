import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.reflect.Method;

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends UIBase
{
    protected int radius = 0;
    
    protected Color normalColour;
    protected Color hoverColour;
    
    /**
     * Constructor for a button with no text or image
     * @param x Top left coordinate x
     * @param y Top left coordinate y
     * @param width Width of button
     * @param height Height of button
     * @param colour Background colour of button
     */
    public Button(int x, int y, int width, int height, Color colour) {
        super(x, y, width, height, colour);

        this.normalColour = colour;
        this.hoverColour = colour;

        createImage();
    }
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            if (contains(mouse.getX(), mouse.getY())) {
                colour = hoverColour;
            } else {
                colour = normalColour;
            }
        }
        
        createImage();
    }
    
    protected void createImage() {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(colour);
        image.fillRect(0, radius, width, height - radius * 2);
        image.fillRect(radius, 0, width - radius * 2, height);
        image.fillOval(0, 0, radius * 2, radius * 2);
        image.fillOval(width - radius * 2, 0, radius * 2, radius * 2);
        image.fillOval(0, height - radius * 2, radius * 2, radius * 2);
        image.fillOval(width - radius * 2, height - radius * 2, radius * 2, radius * 2);

        setImage(image);
    }
    
    public void setColour(Color colour) { this.colour = colour; createImage(); }

    public void setHoverColour(Color colour) { this.hoverColour = colour; }
    
    public void setBorderRadius(int radius) { this.radius = radius; }

    public boolean mouseDown() { return Greenfoot.mousePressed(this) && enabled; }
    
    public boolean mouseUp() { return Greenfoot.mouseClicked(this) && enabled; }
}
