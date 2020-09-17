import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    Button projectileButton;
    Button shmButton;
    
    // Change
    Button aButton;
    Button bButton;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu() {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        prepare();
        setBackground(new GreenfootImage("Menu.png"));
    }
    
    public void act() {
        if (projectileButton.mouseDown()) {
            Greenfoot.setWorld(new ProjectileMotion());
        }
        
        if (shmButton.mouseDown()) {
            Greenfoot.setWorld(new SHM());
        }
    }
    
    private void prepare() {
        projectileButton = new Button(205, 275, 300, 200, new Color(0, 148, 68, 0));
        projectileButton.addToWorld(this);
        projectileButton.setHoverColour(new Color(0, 148, 68, 120));
        projectileButton.setBorderRadius(15);
        
        shmButton = new Button(695, 275, 300, 200, new Color(0, 148, 68, 0));
        shmButton.addToWorld(this);
        shmButton.setHoverColour(new Color(0, 148, 68, 120));
        shmButton.setBorderRadius(15);
        
        aButton = new Button(205, 526, 300, 200, new Color(0, 148, 68, 0));
        aButton.addToWorld(this);
        aButton.setHoverColour(new Color(0, 148, 68, 120));
        aButton.setBorderRadius(15);
        
        bButton = new Button(695, 526, 300, 200, new Color(0, 148, 68, 0));
        bButton.addToWorld(this);
        bButton.setHoverColour(new Color(0, 148, 68, 120));
        bButton.setBorderRadius(15);
    }
}
