import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World representing the menu screen
 * 
 * @author Austin
 * @version 0
 */
public class Menu extends World {
    Button projectileButton;
    Button shmButton;
    Button collisionButton;
    Button frictionButton;

    /**
     * Constructor for objects of class Menu.
     */
    public Menu() {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1, false);
        prepare();
        setBackground(new GreenfootImage("Menu.png"));
    }
    
    /**
     * Listen for button presses
     */
    public void act() {
        if (projectileButton.mouseDown()) {
            Greenfoot.setWorld(new ProjectileMotion());
        }
        
        if (shmButton.mouseDown()) {
            Greenfoot.setWorld(new SHM());
        }
        
        if (collisionButton.mouseDown()) {
            Greenfoot.setWorld(new Collision());
        }
        
        if (frictionButton.mouseDown()) {
            Greenfoot.setWorld(new Friction());
        }
    }
    
    /**
     * Define buttons and add them to the world
     */
    private void prepare() {
        projectileButton = new Button(205, 275, 300, 200, new Color(0, 148, 68, 0));
        projectileButton.addToWorld(this);
        projectileButton.setHoverColour(new Color(0, 148, 68, 120));
        projectileButton.setBorderRadius(15);
        
        shmButton = new Button(695, 275, 300, 200, new Color(0, 148, 68, 0));
        shmButton.addToWorld(this);
        shmButton.setHoverColour(new Color(0, 148, 68, 120));
        shmButton.setBorderRadius(15);
        
        collisionButton = new Button(205, 526, 300, 200, new Color(0, 148, 68, 0));
        collisionButton.addToWorld(this);
        collisionButton.setHoverColour(new Color(0, 148, 68, 120));
        collisionButton.setBorderRadius(15);
        
        frictionButton = new Button(695, 526, 300, 200, new Color(0, 148, 68, 0));
        frictionButton.addToWorld(this);
        frictionButton.setHoverColour(new Color(0, 148, 68, 120));
        frictionButton.setBorderRadius(15);
    }
}
