import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.reflect.Method;

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Label extends UIBase
{
    private String text;
    private int fontSize;
    private Color textColour;
    
    /**
     * Constructor for a text label
     * @param x Top left coordinate x
     * @param y Top left coordinate y
     * @param width Width of label
     * @param height Height of label
     * @param colour Background colour of label
     * @param text String to display on the label
     * @param fontSize Font size of text
     * @param textColour Colour of text
     */
    public Label(int x, int y, int width, int height, Color colour, String text, int fontSize, Color textColour) {
        super(x, y, width, height, colour);
        this.text = text;
        this.fontSize = fontSize;
        this.textColour = textColour;
        
        createImage();
    }
    
    /**
     * Act - do whatever the Label wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
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

    public String getText() { return text; }
}
