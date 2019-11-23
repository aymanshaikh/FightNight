import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KirbyHealth here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class KirbyHealth extends Actor
{
    private int kHealth;

    public KirbyHealth()
    {
        kHealth=100;
    }

    public void decreaseHealth()
    {
        kHealth -=2;
    }

    public void decreaseHealthFall()
    {
        kHealth -=10;
    }

    public void increaseHealth()
    {
        kHealth += 5;
    }

    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (kHealth <= 0)
        {
            getWorld().addObject(new MetaKnightWins(), 490, 290);
            Greenfoot.stop();
        }
        GreenfootImage background=getWorld().getBackground();
        GreenfootImage health=new GreenfootImage("Health:"+kHealth,24,new Color(0,0,0),new Color(232, 169, 222));
        background.drawImage(health,355,725);
    }   

}