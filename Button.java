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
    private String text;
    private int fontSize;
    private Color textColour;
    
    private Color normalColour;
    private Color hoverColour;
    // private Color clickedColour;
    
    /**
     * Constructor for a button with text
     * @param x Top left coordinate x
     * @param y Top left coordinate y
     * @param width Width of button
     * @param height Height of button
     * @param colour Background colour of button
     * @param text String to display on the button
     * @param fontSize Font size of text
     * @param textColour Colour of text
     */
    public Button(int x, int y, int width, int height, Color colour, String text, int fontSize, Color textColour) {
        super(x, y, width, height, colour);
        this.text = text;
        this.fontSize = fontSize;
        this.textColour = textColour;
        
        this.normalColour = colour;
        this.hoverColour = colour;
        // this.clickedColour = colour;
        
        createImage();
    }
    
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
        this.text = "";
        this.fontSize = 0;
        this.textColour = new Color(0, 0, 0, 0);
        
        this.normalColour = colour;
        this.hoverColour = colour;
        // this.clickedColour = colour;
        
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
    
    private void createImage() {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(colour);
        image.fillRect(0, 0, width, height);
        
        GreenfootImage textImage = new GreenfootImage(text, fontSize, textColour, new Color(0, 0, 0, 0));
        image.drawImage(textImage, (getWidth() - textImage.getWidth()) / 2, (getHeight() - textImage.getHeight()) / 2);
        
        setImage(image);
    }
    
    public void setColour(Color colour) { this.colour = colour; createImage(); }
    
    public void setText(String text) { this.text = text; createImage(); }
    
    public void setHoverColour(Color colour) { this.hoverColour = colour; }
    
    // public void setClickedColour(Color colour) { this.clickedColour = colour; }
    
    public String getText() { return text; }
    
    public boolean mouseDown() { return Greenfoot.mousePressed(this) && enabled; }
    
    public boolean mouseUp() { return Greenfoot.mousePressed(this) && enabled; }
}
