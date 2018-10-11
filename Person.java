import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Person class. a A person can:
 * 
 *  1) move left or right based on user keypresses
 *  2) lay a trap to kill spiders
 *  3) have their own health reduced by touching a spider
 *  4) Have their own score increased by not touching a spider
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person extends Actor
{   private int x; //Gets the x-Coordinate of the Person
    private int y; //Gets the y-Coordinate of the Person
    private int count; //Counts the delay before the person can set a Trap
    private MyWorld w; //Used to access the World object
    private Scoreboard score; //Used to access the Scoreboard object
    private int sscore; //Used to count the Score

    public Person()
    {
        count = 1000;
    }

    protected void addedToWorld(World world) 
    {  
        x = getX(); //Gives the x-coordinate of the Person's current location
        y = getY(); //Gives the y-coordinate of the Person's current Location
        w = (MyWorld) getWorld(); 
       

    }
    /**
     * Returns the Score to the Scoreboard
     */
    public Scoreboard getScoreboard(){ 
        score = w.getScoreboard(); 
        sscore = score.getScore();
        return score;
    }

    public void act() 
    {   
        if(Greenfoot.isKeyDown("Left"))
        {
            move(-1); //Makes the person move left when LEFT key is pressed
            x = getX();

        }
        if(Greenfoot.isKeyDown("Right"))
        {
            move(1); //Makes the person move right when the Right key is pressed
            x = getX();

        } 

        {
            if ((Greenfoot.isKeyDown("space")) && count > 1000)
            {
                Trap trap = new Trap();
                getWorld().addObject(trap,x,y);

                count = 0; 
                getScoreboard().decTrapsLeft();

            }
            count ++;

        }
        if(!(isTouching(Spider.class)))
        {
            getScoreboard().incScore();
        }
        if(isTouching(Spider.class))
        {
            getScoreboard().decHealth();
        }
        if (getScoreboard().getHealth() == 0 )
        
        {
            getWorld().showText("Game Over",w.getWidth()/2,w.getHeight()/2);
            getWorld().removeObject(this);
            
        if(getScoreboard().getScore() > getScoreboard().getHighScore())
            {
                sscore = getScoreboard().getScore();
                getScoreboard().setHighScore(sscore);

            }
        }

    }
}