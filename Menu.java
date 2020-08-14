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
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        prepare();
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(projectileButton)) {
            ProjectileMotion newWorld = new ProjectileMotion();
            Greenfoot.setWorld(newWorld);
        }
    }
    
    private void prepare() {
        projectileButton = new Button(getWidth() / 2 - 150, getHeight() / 2 - 50, 300, 100, new Color(0, 0, 0), "Projectile Motion", 40, new Color(255, 255, 255));
        addObject(projectileButton, projectileButton.getXPos() + projectileButton.getWidth() / 2, projectileButton.getYPos() + projectileButton.getHeight() / 2);
        projectileButton.setHoverColour(new Color(0, 0, 0, 200));
    }
}
