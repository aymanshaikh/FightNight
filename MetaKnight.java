import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)  
import java.util.*; 
/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */ 
public class MetaKnight  extends Actor  
{  
    //Basic Physics Variables  
    private double locationX = 780;  
    private double locationY = 400;  
    private double speedX = 0;  
    private double speedY = 0;   

    private boolean isFacingRight;
    private boolean hit = false;
    private boolean bulletRight;
    /**
     * Person - constructs the person (mario) class
     */
    public MetaKnight()
    {

    } 

    /** 
     * Act - do whatever the Person wants to do. This method is called whenever 
     * the 'Act' or 'Run' button gets pressed in the environment. 
     */  
    public void act()   
    {  

        //Apply Forces to change acceleration to move the person  
        applyGravity();  
        applyJumpForce();  

        life();
        ifHit();
        moveRightAndLeft();

        teleport();
        hitTop();
        hitSide();

        move();
    }   

    /**
     * onGround - determines if the actor is on the ground
     */
    public boolean onGround()
    {
        Actor coll = getOneObjectAtOffset(0, 40, Platform.class);
        if(coll != null)
        {
            return true;
        }
        return false;
    }

    /** 
     * Accelerates the person downwards except for when they are on a platform 
     */  
    public void applyGravity(){  
        if(onGround()== false)
        {   
            //This is run when the person is not touching a platform  
            //This code adds gravity to our total acceleration.  
            speedY += 0.1;  
        } 
        else {   
            //This is run once we hit a platform  
            //We make our person stop moving in the y direction. (up/down direction).  
            speedY = 0;  
        }  
    }  

    /** 
     * Accelerates the person upwards if space is pressed and we are on a platform 
     */  
    public void applyJumpForce(){  
        if(onGround()==true){  
            //This is run when the person is touching a platform  
            if(Greenfoot.isKeyDown("up")){  
                speedY -= 6;  
                jumpAnimate();
            }  
        }  
    }  

    /**
     * jumpAnimate - changes the picture of mario if he is in the air
     */
    public void jumpAnimate()
    {
        if(isFacingRight==true)
        {
            setImage("Meta Knight Walk Right.png");
        }
        else
        {
            setImage("Meta Knight Walk Left.png");
        }
    }

    public void life()
    {
        if (isTouching(Heart.class))
        {
            ((GameWorld)getWorld()).getMetaHealth().increaseHealth();
            removeTouching(Heart.class);
        }
    }

    public void ifHit()
    {
        if (isTouching(Bullet.class))
        {
            ((GameWorld)getWorld()).getMetaHealth().decreaseHealth();
            hit = true;
            if (((GameWorld)getWorld()).getKirby().getX() > getX())
            {
                bulletRight = true;
            }
            else 
            {
                bulletRight = false;
            }
            removeTouching(Bullet.class);
        }
    }

    /**
     * moveRightAndLeft - moves mario right or left based on the arrow keys pressed
     */
    public void moveRightAndLeft()
    {
        if(hit ==true)
        {
            if(bulletRight==true)
            {
                speedX= -100;
            }
            else
            {
                speedX= +100;
            }            
            hit= false;
        }
        else if(Greenfoot.isKeyDown("enter") && hit ==false)
        {
            shoot();
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            speedX = 1.5;
            isFacingRight = true;
            animate();
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            speedX = -1.5;
            isFacingRight = false;
            animate();
        }
        else if(!Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("right") && !Greenfoot.isKeyDown("enter") && hit ==false)
        {
            speedX = 0;
            if(onGround()==true)
            {
                if(isFacingRight==true)
                {
                    setImage("MetaKnightIdleRight.png");
                }
                else
                {
                    setImage("MetaKnightIdleLeft.png");
                }
            }
            else
            {
                if(isFacingRight==true)
                {
                    setImage("MetaKnightIdleRight.png");
                }
                else
                {
                    setImage("MetaKnightIdleLeft.png");
                }
            }
        }
    }

    /**
     * animate - animates mario running
     */
    public void animate()
    {
        if (onGround()==true)
        {
            if(isFacingRight==true)
            {
                setImage("Meta Knight Walk Right.png");
            }
            else
            {
                setImage("Meta Knight Walk Left.png");
            }
        }
    }

    public void shoot()
    {
        List bullets = getNeighbours(250, false, Bullet2.class);
        if (bullets.isEmpty()) 
        {
            if (isFacingRight)
            {
                getWorld().addObject(new Bullet2(), getX() +10, getY());
            }
            else 
            {
                getWorld().addObject(new Bullet2(), getX() -10, getY());
            }
        }
    }

    /**
     * teleport - puts mario on the oposite side of the map if he walks off
     */
    public void teleport()
    {
        if(locationX >= 950)
        {
            locationX = 5;
        }
        else if(locationX <= 5)
        {
            locationX = 950;
        }
        else if (locationY >= 750)
        {
            ((GameWorld)getWorld()).getMetaHealth().decreaseHealthFall();
            locationY = 5;
        }
    }

    /**
     * hitTop - checks if mario has hit block
     */
    public void hitTop()
    {
        Actor coll = getOneObjectAtOffset(1, -50, Platform.class);
        if(coll != null)
        {
            speedY = +1;
        }
    }

    /**
     * hitSide - checks if mario has hit the side of a platform
     */
    public void hitSide()
    {
        Actor coll = getOneObjectAtOffset(10, 0, Platform.class);
        if(coll != null)
        {
            speedX = 0;
        }
    }

    /**
     * move - moves the actor based on physics varibles
     */
    public void move()
    {  
        locationX += speedX;  
        locationY += speedY;  
        setLocation((int)locationX,(int)locationY);
    }
}  