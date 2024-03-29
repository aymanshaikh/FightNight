import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet2 extends Actor
{
    private int move;
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (getX() > ((GameWorld)getWorld()).getMetaKnight().getX())
        {
            setLocation (getX()+2, getY());
        }
        else if (getX() < ((GameWorld)getWorld()).getMetaKnight().getX())
        {
            setLocation (getX()-2, getY());
        }
        
        if ((isAtEdge()==true))
        {
            getWorld().removeObject(this);
        }
    }    

}