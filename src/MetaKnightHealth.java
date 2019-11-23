import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MetaKnightHealth here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MetaKnightHealth extends Actor
{
    private int mHealth;

    public MetaKnightHealth()
    {
        mHealth=100;
    }

    public void decreaseHealth()
    {
        mHealth -=2;
    }

    public void decreaseHealthFall()
    {
        mHealth -=10;
    }

    public void increaseHealth()
    {
        mHealth += 5;
    }
    
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (mHealth <= 0)
        {
            getWorld().addObject(new KirbyWins(), 490, 290);
            Greenfoot.stop();
        }
        GreenfootImage background=getWorld().getBackground();
        GreenfootImage healthBox=new GreenfootImage("Health: " + mHealth,24,new Color(0,0,0),new Color(108, 33, 188));
        background.drawImage(healthBox,657,720);
    }
}
