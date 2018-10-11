import greenfoot.*; 
import java.util.Random; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Spider simply moves up and down in the world.
 * 
 * After being placed into the world, the spider should
 * not move for a random anount of time between 25 and
 * 375 calls to it's act method. 
 * 
 * When this spider comes back to top of the world, add a 
 * new spider
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spider extends Actor {
   
    private int delay; //Variable that holds the delay time

    protected void addedToWorld(World world)
    {
        turn(90); // Turns the Spider by 90 degrees when its added to the world
        delay = (Greenfoot.getRandomNumber(350)+25); // Sets a delay time between 25 to 375 before the spider starts to move

    }

    /**
     * Act - do whatever the Spider wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    { if (delay == 0){  
            move(1); //Spider moves by 1 pixel
            if (this.isAtEdge())
            {
                turn(180); // Spider turns 180 degree if it reaches the edge
            }
            if (this.isTouching(Scoreboard.class))
            {
                turn(180); //Spider turns 180 degrees when it touches the Scoreboard        
                Spider spider = new Spider(); //Adds new Spider to the World
                getWorld().addObject(spider,Greenfoot.getRandomNumber(800),90); //Gives location to where the Spider should be placed
                
                

            }
        } 
        else 
        {
            delay--; // Decreases the delay
        }

    }

}   

