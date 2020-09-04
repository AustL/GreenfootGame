import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EllipseButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EllipseButton extends Button
{
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
    public EllipseButton(int x, int y, int width, int height, Color colour, String text, int fontSize, Color textColour) {
        super(x, y, width, height, colour, text, fontSize, textColour);
    }
    
    /**
     * Constructor for a button with no text or image
     * @param x Top left coordinate x
     * @param y Top left coordinate y
     * @param width Width of button
     * @param height Height of button
     * @param colour Background colour of button
     */
    public EllipseButton(int x, int y, int width, int height, Color colour) {
        super(x, y, width, height, colour);
    }
    
    @Override
    protected void createImage() {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(colour);
        image.fillOval(0, 0, width, height);
        
        GreenfootImage textImage = new GreenfootImage(text, fontSize, textColour, new Color(0, 0, 0, 0));
        image.drawImage(textImage, (getWidth() - textImage.getWidth()) / 2, (getHeight() - textImage.getHeight()) / 2);
        
        setImage(image);
    }
}
