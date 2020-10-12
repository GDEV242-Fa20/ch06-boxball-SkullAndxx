import java.awt.Color;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Erick Rubio
 * @version 2020.10.11
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private Random rand;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

        // create and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    /**
     * This method draws a rectangle (the box) on screen and between five 
     * and thirty balls that move inside the box.
       */
    public void boxBounce(){
       // Set Box sides
       int bottomBox = 400;   
       int topBox = 50;
       int leftBox = 50;
       int rightBox = 550;
       
       // Make a random amount of balls
       int ballsMin = 5 ;
       int ballsMax = 30 ;
       Random rand = new Random();
       
       // determine difference between max and min and 
       // add 1 to compensate for the 0 (inclusive) then add min to 
       // compensate for the starting point. 
       //   Note: Will never go past 30 in this example because 
       //   max-min removes the extra head room
       int howManyBalls = rand.nextInt(ballsMax-ballsMin+1)+ballsMin; 
       //System.out.println(howManyBalls);
       
       myCanvas.setVisible(true);

        // draw the box
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, bottomBox, 550, bottomBox);
        myCanvas.drawLine(50, topBox, 550, topBox);
        myCanvas.drawLine(leftBox, 50, leftBox, 400);
        myCanvas.drawLine(rightBox, 50, rightBox, 400);
        
       while(howManyBalls != 0){
          myCanvas.wait(50);           // small delay

          int xPos = rand.nextInt(400)+50;
          BoxBall ball = new BoxBall(xPos, 50, 16, Color.BLUE, bottomBox, myCanvas,howManyBalls);
          ball.draw();
          //ball.move();
          // stop once ball has travelled a certain distance on x axis
          // if(ball.getXPosition() >= 550) {
                // howManyBalls--;
          // }
          howManyBalls--;
        }        
        

    }
}
