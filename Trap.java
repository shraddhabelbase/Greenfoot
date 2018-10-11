import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Trap class should remove the first five spiders that
 * touch it, and then remove itself from the World.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trap extends Actor
{ 
    private int kill;//variable to keep count of the Spiders being killed by the Trap
   
    
    /**
     * Gives value of the Spiders being killed 
     */
    public int Trap()
    { 
        kill = 0; //Starts with the value 0
        return kill;

    }

    /**
     * Act - do whatever the Trap wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * 
     */

    public void act() {
        MyWorld spiderCount = (MyWorld) getWorld();
        if ((isTouching(Spider.class) && (kill < 6) && spiderCount.getSpiderCount()>1))
        { 
            removeTouching(Spider.class); //Removes the Spider if it is Touching the TRap
            kill ++; //Increases the value of killed Spiders
        }

        if (kill == 5) 
        {
            getWorld().removeObject(this); //Removes the trap once it kills more than 5 Spiders
        }

    }

}
