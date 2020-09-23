import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class representing buttons
 * 
 * @author Austin
 * @version 0
 */
public class Button extends UIBase
{
    protected int radius = 0;
    
    protected Color normalColour;
    protected Color hoverColour;
    
    /**
     * Constructor for a button
     * 
     * @param x         Top left coordinate x
     * @param y         Top left coordinate y
     * @param width     Width of button
     * @param height    Height of button
     * @param colour    Background colour of button
     */
    public Button(int x, int y, int width, int height, Color colour) {
        super(x, y, width, height, colour);

        this.normalColour = colour;
        this.hoverColour = colour;

        createImage();
    }
    
    /**
     * Listen for a mouse hover
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
    
    /**
     * Draws the button to the creen
     */
    protected void createImage() {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(colour);
        
        // Draw rectangles without corners
        image.fillRect(0, radius, width, height - radius * 2);
        image.fillRect(radius, 0, width - radius * 2, height);
        
        // Draw rounded corners
        image.fillOval(0, 0, radius * 2, radius * 2);
        image.fillOval(width - radius * 2, 0, radius * 2, radius * 2);
        image.fillOval(0, height - radius * 2, radius * 2, radius * 2);
        image.fillOval(width - radius * 2, height - radius * 2, radius * 2, radius * 2);

        setImage(image);
    }
    
    /**
     * Set the colour of the button
     * 
     * @param colour    The colour to set the button to
     */
    public void setColour(Color colour) { this.colour = colour; createImage(); }
    
    /**
     * Set the colour of the button when hovered over
     * 
     * @param colour    The colour the button should be when hovered over
     */
    public void setHoverColour(Color colour) { this.hoverColour = colour; }
    
    /**
     * Set the border radius of the button
     * 
     * @param radius    The border radius of the rounded corners
     */
    public void setBorderRadius(int radius) { this.radius = radius; }
    
    /**
     * Check if the button has been clicked
     * 
     * @return          Whether the button has been clicked and is enabled
     */
    public boolean mouseDown() { return Greenfoot.mousePressed(this) && enabled; }
    
    /**
     * Check if the button has been released
     * 
     * @return          Whether the button has been released and is enabled
     */
    public boolean mouseUp() { return Greenfoot.mouseClicked(this) && enabled; }
}
