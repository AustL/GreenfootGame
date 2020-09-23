import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class representing labels
 * 
 * @author Austin
 * @version 0
 */
public class Label extends UIBase {
    protected String text;
    protected int fontSize;
    protected Color textColour;
    
    /**
     * Constructor for a text label
     * 
     * @param x             Top left coordinate x
     * @param y             Top left coordinate y
     * @param width         Width of label
     * @param height        Height of label
     * @param colour        Background colour of label
     * @param text          String to display on the label
     * @param fontSize      Font size of text
     * @param textColour    Colour of text
     */
    public Label(int x, int y, int width, int height, Color colour, String text, int fontSize, Color textColour) {
        super(x, y, width, height, colour);
        this.text = text;
        this.fontSize = fontSize;
        this.textColour = textColour;
    }
    
    /**
     * Update the image
     */
    public void act() {
        createImage();
    }
    
    /**
     * Draw the label as a rectangle to the screen
     * Display the text in the centre of the rectangle 
     */
    protected void createImage() {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(colour);
        image.fillRect(0, 0, width, height);
        
        GreenfootImage textImage = new GreenfootImage(text, fontSize, textColour, new Color(0, 0, 0, 0));
        image.drawImage(textImage, (getWidth() - textImage.getWidth()) / 2, (getHeight() - textImage.getHeight()) / 2);
        
        setImage(image);
    }
    
    /**
     * Set the background colour of the label
     * 
     * @param colour    The colour to set the background to
     */
    public void setColour(Color colour) { this.colour = colour; }
    
    /**
     * Set the text the label displays
     * 
     * @param text      The text to display
     */
    public void setText(String text) { this.text = text; }
    
    // Getters
    public String getText() { return text; }
}
