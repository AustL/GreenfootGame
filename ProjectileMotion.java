import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ProjectileMotion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProjectileMotion extends World
{
    private Button startButton;
    private Label testLabel;
    private Slider testSlider;
    private Ball ball;
    
    private double maxHeight = 0;
    private double maxRange = 0;
    /**
     * Constructor for objects of class ProjectileMotion.
     * 
     */
    public ProjectileMotion() {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        prepare();
    }
    
    public void act() {
        if (startButton.mouseUp()) {
            begin();
            startButton.disable();
        }
        
        testLabel.setText(String.valueOf(testSlider.getValue()));
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare() {
        startButton = new Button(400, 200, 300, 150, new Color(0, 0, 0, 50), "Begin", 50, new Color(0, 0, 0));
        startButton.addToWorld(this);
        startButton.setHoverColour(new Color(0, 0, 0, 100));
        
        testSlider = new Slider(100, 500, 500, 20, new Color(0, 0, 100, 255), 20, 0, 100, new Color(0, 100, 0));
        testSlider.addToWorld(this);
        
        testLabel = new Label(200, 600, 200, 100, new Color(100, 100, 0, 255), "Label", 50, new Color(0, 0, 0));
        testLabel.addToWorld(this);
        
        ball = new Ball(20, 0, 1);
        addObject(ball, 20, getHeight() - 60);
        
        for (int i = 0; i < 15; i++) {
            Ground ground = new Ground();
            addObject(ground, 40 + i * 80, 783);
        }
    }
    
    private void begin() {
        ball.setVelocity(testSlider.getValue(), testSlider.getValue());
    }
}
