import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.function.Supplier;

/**
 * Class representing linked labels
 * 
 * @author Austin
 * @version 0
 */
public class LinkedLabel extends Label
{
    private Supplier<String> supplier;
    
    /**
     * Constructor for a label linked to a supplier
     * 
     * @param x             Top left coordinate x
     * @param y             Top left coordinate y
     * @param width         Width of label
     * @param height        Height of label
     * @param colour        Background colour of label
     * @param supplier      A string supplier that returns a string determined by a lambda function
     * @param fontSize      Font size of text
     * @param textColour    Colour of text
     */
    public LinkedLabel(int x, int y, int width, int height, Color colour, Supplier<String> supplier, int fontSize, Color textColour) {
        super(x, y, width, height, colour, "", fontSize, textColour);
        this.supplier = supplier;
        
        createImage();
    }
    
    /**
     * Draw the label as a rectangle to the screen
     * Display the text from the supplier in the centre of the rectangle 
     */
    protected void createImage() {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(colour);
        image.fillRect(0, 0, width, height);
        
        GreenfootImage textImage = new GreenfootImage(supplier.get(), fontSize, textColour, new Color(0, 0, 0, 0));
        image.drawImage(textImage, (getWidth() - textImage.getWidth()) / 2, (getHeight() - textImage.getHeight()) / 2);
        
        setImage(image);
    }
}
