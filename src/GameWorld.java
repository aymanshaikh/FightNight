import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An empty small world with a cat.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class GameWorld extends World
{
    GifImage backgroundGif = new GifImage("Background.gif");

    private int platformCounter =0;
    Centre fade = new Centre();

    private Kirby theKirby = new Kirby();
    private MetaKnight theMetaKnight= new MetaKnight();
    private KirbyHealth kirbyHealth = new KirbyHealth();
    private MetaKnightHealth metaHealth = new MetaKnightHealth();
    
    int lifeNum;
    
    GreenfootSound myMusic = new GreenfootSound ("Music.mp3");
    /**
     * Constructor for objects of class CatWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 20x20 cells with a cell size of 10x10 pixels.
        super(1000, 800, 1);

        addObject (new p6(), 480, 300);
        addObject (new  P2(), 197, 273);
        addObject (new  P5(), 750, 295);
        addObject (new  P3(), 910, 150);
        addObject (theKirby, 0, 0);
        addObject (theMetaKnight, 500, 300);
        addObject (new CentreLong(), 475, 300);
        addObject (new Centre(), 170, 447);
        addObject (new Centre(), 780, 447);
        addObject (fade, 815, 150);
        addObject (new Bottom(), 500, 600);
        addObject (kirbyHealth, 320, 725);
        addObject (metaHealth, 650, 725);
        //addObject (new Countdown(), 500, 500);
    }

    public void act ()
    {       
        setBackground(backgroundGif.getCurrentImage());

        platformCounter ++;
        if (platformCounter == 200)
        {
            fade.getImage().setTransparency(255);
            fade.setLocation((int)(Math.random()*1000), 170);
        }
        if (platformCounter >1000)
        {
            fade.getImage().setTransparency(0);
            fade.setLocation(0, 0);
            platformCounter = 0;
        }

       lifeNum = (int)(Math.random()*10000);
       if (lifeNum ==5)
       {
           addObject (new Heart(), (int)(Math.random()*1000), 0);
        }
       
       
       myMusic.play();
    }

    public Kirby getKirby()
    {
        return theKirby;
    }

    public MetaKnight getMetaKnight()
    {
        return theMetaKnight;
    }

    public KirbyHealth getKirbyHealth()
    {
        return kirbyHealth;
    }

    public MetaKnightHealth getMetaHealth()
    {
        return metaHealth;
    }
}
