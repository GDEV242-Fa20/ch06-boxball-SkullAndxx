import java.awt.*;
import java.awt.geom.*;
import java.util.Random;
/**
 * Write a description of class BoxBall here.
 * Creates a box and balls that bounce within the box
 *
 * @author Erick Rubio
 * @version 2020-10-11
 */
public class BoxBall
{
    // instance variables - replace the example below with your own
    private static final int GRAVITY = 3;  // effect of gravity

    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;      // y position of ground
    private Canvas canvas;
    private int ySpeed = 1;                // initial downward speed
    private int balls;
    private Random rand;

    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                        int groundPos, Canvas drawingCanvas, int howManyBalls)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        canvas = drawingCanvas;
        balls = howManyBalls;
        
    }


    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        
            canvas.setForegroundColor(color);
            canvas.fillCircle(xPosition, yPosition, diameter);
            
        
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        ySpeed += GRAVITY;
        yPosition += ySpeed;
        xPosition +=2;

        // check if it has hit the ground
        if (yPosition >= (groundPosition - diameter) && ySpeed > 0) {
            yPosition = (int)(groundPosition - diameter);
            ySpeed = -ySpeed + ballDegradation; 
        }

        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
    
    // /**
     // * Random Color Array
       // */
    // public Color getRandomColor(){
        
        // Color circleColor = new Color(rand.nextInt(256), rand.nextInt(256),rand.nextInt(256));
        
        
        
        // return circleColor;
    // }
}
