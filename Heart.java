import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heart extends Actor
{
    GifImage Heart = new GifImage("Heart.gif");
    /**
     * Act - do whatever the Heart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(Heart.getCurrentImage());
        {
            Actor coll = getOneObjectAtOffset(0, 40, Platform.class);
            if(coll != null)
            {
                move(0);
            }

            else 
            {
                setLocation (getX(), getY() + 1);
            }
        }

        if (getY() >= 750)
        {
            getWorld().removeObject(this);
        }
    }    
}
