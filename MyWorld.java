import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The World for CSC14400 Project#1 (Spring 2018)
 * 
 * @author Stephen Blythe
 * @version 1/2018
 */
public class MyWorld extends World
{ 
    private Scoreboard scoreboard; // gets scoreboard
    private int highscore; // gets the highscore
    private int xx; // gets the Width of the world
    private int yy; //gets the height of the world

    /**
     * Constructor for objects of class MyWorld.
     * 
     * 
     */

    public MyWorld()
    {    

        super(800, 600, 1); //Creates a world of 800 Width, 600 Height and 1*1 pixels.

        Person person = new Person(); // Adds a person in the world
        addObject(person,30,558); // Gives location to where the person should be added

        xx = this.getWidth();
        yy = this.getHeight();

        scoreboard = new Scoreboard(); // Adds a Scoreboard in the World
        addObject(scoreboard,400,20); // Gives location to where the Scoreboard should be placed

        Spider spider = new Spider(); //Adds a SPider in the World
        addObject(spider,Greenfoot.getRandomNumber(xx),61); // Gives location to where the Spider should be added

        prepare();
    }

    /**
     * returns the number of spiders found in the World.
     * 
     * @return number of spiders found. 
     */
    public int getSpiderCount()
    {
        // get list of all spiders and return count found
        //   inside of that list.
        return getObjects(Spider.class).size();
    }

    /** 
     * removes all Spider objects from the world. 
     */
    public void removeAllSpiders()
    {
        // get list of all spiders and remove each
        //   spider inside of that list
        removeObjects(getObjects(Spider.class));
    }

    /** 
     * removes all Trap objects from the world. 
     */
    public void removeAllTraps()
    {
        // get list of all spiders and remove each
        // spider inside of that list
        removeObjects(getObjects(Trap.class));

    }

    /**
     * yes! a World can have an act() method, too. 
     * It might just check to see if a key has been
     * pressed, etc...
     */
    public void act()
    {
        highscore = getScoreboard().getHighScore();
        
        if(Greenfoot.isKeyDown("n") && getScoreboard().getHealth() == 0)
        { 
            removeAllSpiders(); //Removes all the Spiders from the world

            removeAllTraps(); //Removes all the Traps from the World

            Person person = new Person(); //Adds the actor Person in the World
            addObject(person,58,558); //Gives location to where the Person should be added

            scoreboard = new Scoreboard();//Adds a new Scoreboard in the World
            addObject(scoreboard,400,20); //Gives location to where the Scoreboard should be added

            getScoreboard().setHighScore(highscore);//Adds highscore in the newly created scoreboar

            Spider spider = new Spider();//Adds a new Spider in the world
            addObject(spider,Greenfoot.getRandomNumber(xx),61); //Gives location to where the Spider should be added

            showText("        ",xx/2,yy/2);//Overwrites the "Game Over" text 

        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }

    /**
     * This method returns the scoreboard
     */
    public Scoreboard getScoreboard()
    {
        return scoreboard; 
    }

}