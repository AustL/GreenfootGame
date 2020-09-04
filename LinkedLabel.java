import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.function.Supplier;

/**
 * Write a description of class LinkedLabel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LinkedLabel extends Label
{
    private Supplier<String> supplier;
    
    /**
     * Constructor for a label linked to a method
     * @param x Top left coordinate x
     * @param y Top left coordinate y
     * @param width Width of label
     * @param height Height of label
     * @param colour Background colour of label
     * @param text String to display on the label
     * @param fontSize Font size of text
     * @param textColour Colour of text
     */
    public LinkedLabel(int x, int y, int width, int height, Color colour, Supplier<String> supplier, int fontSize, Color textColour) {
        super(x, y, width, height, colour, "", fontSize, textColour);
        this.supplier = supplier;
        
        createImage();
    }
    
    protected void createImage() {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(colour);
        image.fillRect(0, 0, width, height);
        
        GreenfootImage textImage = new GreenfootImage(supplier.get(), fontSize, textColour, new Color(0, 0, 0, 0));
        image.drawImage(textImage, (getWidth() - textImage.getWidth()) / 2, (getHeight() - textImage.getHeight()) / 2);
        
        setImage(image);
    }
}
