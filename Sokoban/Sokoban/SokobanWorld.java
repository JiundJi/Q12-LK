import greenfoot.*;  // imports Actor, World, Greenfoot, GreenfootImage

import java.util.Random;
import java.util.List;

public class SokobanWorld extends World
{
    private int level = 1;
    private boolean levelFinished = false;
    /**
     * Create a new world with 8x8 cells and
     * with a cell size of 60x60 pixels
     */
    public SokobanWorld() 
    {
        super(12, 12, 40);        
        setBackground("cell2.jpg");
        populate(1);
    }

    public void act() {
        List<Goal>goals = getObjects(Goal.class);
        levelFinished = true;
        for (Goal goal: goals) {
            if (!goal.hasDiamond()) {levelFinished = false;}
        }
        if (levelFinished) {
            level++;
            nextLevel();
        }
    } 

    public void nextLevel() {
        if (level < 3) {
            populate(level);
        } else {
            Greenfoot.stop();
        }
    }

    /**
     * Populate the world with a fixed scenario of Diamonts, Stones and a Man.
     */    
    public void populate(int level)
    {
        List objects;
        switch (level) {
            case 1: 
                // Entferne alle bisherigen Objekte
                objects = getObjects(null);
                removeObjects(objects);

                // Erzeuge ein neues Szenario
                for (int i=0; i<12-1; i++) {
                    addObject(new Stone(), i, 0);
                    addObject(new Stone(), i+1, 12);
                    addObject(new Stone(), 0, i+1);
                    addObject(new Stone(), 12, i); 
                }
                addObject(new Stone(), 7, 1);
                addObject(new Stone(), 2, 2);
                addObject(new Stone(), 3, 2);
                addObject(new Stone(), 6, 2);
                addObject(new Stone(), 7, 2);
                addObject(new Stone(), 2, 3);
                addObject(new Stone(), 2, 4);
                addObject(new Stone(), 4, 4);
                addObject(new Stone(), 2, 5);
                addObject(new Stone(), 3, 5);
                addObject(new Stone(), 4, 6);
                addObject(new Stone(), 5, 6);
                addObject(new Stone(), 7, 6);
                addObject(new Stone(), 8, 6);
                addObject(new Stone(), 7, 7);
                addObject(new Stone(), 9, 8);
                addObject(new Stone(), 5, 9);
                addObject(new Stone(), 7, 10);

                addObject(new Diamond(), 2, 1);
                addObject(new Diamond(), 5, 3);
                addObject(new Diamond(), 8, 8);
                addObject(new Diamond(), 1, 9);

                Goal goal = new Goal();
                addObject(goal,1,6);
                Goal goal2 = new Goal();
                addObject(goal2,1,1);
                Goal goal3 = new Goal();
                addObject(goal3,3,3);
                Goal goal4 = new Goal();
                addObject(goal4,6,10);

                addObject(new Man(), 1, 10);
                break;
            case 2: 
                objects = getObjects(null);
                removeObjects(objects);

                for (int i=0; i<12;i++) {
                    addObject(new Stone(), i, 0);
                    addObject(new Stone(), i, 12);
                    addObject(new Stone(), 0, i);
                    addObject(new Stone(), 12, i);
                }
        }
    }
}