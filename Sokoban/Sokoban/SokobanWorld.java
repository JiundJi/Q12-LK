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
        prepare();
    }

    public void act() {
        List<Goal>goals = getObjects(Goal.class);
        levelFinished = true;
        for (Goal goal: goals) {
            if (!goal.hasDiamond()) {levelFinished = false;}
            if (Greenfoot.isKeyDown("r"))
        }
        if (levelFinished) {
            level++;
            nextLevel();
            levelFinished = false;
        }
    } 

    public void nextLevel() {
        if (level < 4) {
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
                Stone stone = new Stone();
                addObject(stone,2,3);
                Stone stone2 = new Stone();
                addObject(stone2,3,3);
                Stone stone3 = new Stone();
                addObject(stone3,3,2);
                Stone stone4 = new Stone();
                addObject(stone4,4,2);
                Stone stone5 = new Stone();
                addObject(stone5,1,8);
                Stone stone6 = new Stone();
                addObject(stone6,3,4);
                Stone stone7 = new Stone();
                addObject(stone7,3,5);
                Stone stone8 = new Stone();
                addObject(stone8,3,7);
                Stone stone9 = new Stone();
                addObject(stone9,3,9);
                Stone stone10 = new Stone();
                addObject(stone10,3,10);
                Stone stone11 = new Stone();
                addObject(stone11,6,4);
                Stone stone12 = new Stone();
                addObject(stone12,6,3);
                Stone stone13 = new Stone();
                addObject(stone13,7,3);
                Stone stone14 = new Stone();
                addObject(stone14,5,7);
                Stone stone15 = new Stone();
                addObject(stone15,6,7);
                Stone stone16 = new Stone();
                addObject(stone16,6,8);
                Stone stone17 = new Stone();
                addObject(stone17,10,2);
                Stone stone18 = new Stone();
                addObject(stone18,9,2);
                Stone stone19 = new Stone();
                addObject(stone19,9,4);
                Stone stone20 = new Stone();
                addObject(stone20,8,6);
                Stone stone21 = new Stone();
                addObject(stone21,8,7);
                Stone stone22 = new Stone();
                addObject(stone22,9,7);
                Stone stone23 = new Stone();
                addObject(stone23,8,9);
                Stone stone24 = new Stone();
                addObject(stone24,8,10);

                Man man = new Man();
                addObject(man,1,10);

                goal = new Goal();
                addObject(goal,1,1);
                goal2 = new Goal();
                addObject(goal2,10,1);
                goal3 = new Goal();
                addObject(goal3,10,3);
                goal4 = new Goal();
                addObject(goal4,4,10);

                Diamond diamond = new Diamond();
                addObject(diamond,2,9);
                Diamond diamond2 = new Diamond();
                addObject(diamond2,5,2);
                Diamond diamond3 = new Diamond();
                addObject(diamond3,8,8);
                Diamond diamond4 = new Diamond();
                addObject(diamond4,4,8);
            
            case 3: 
                for (int i=0; i<12;i++) {
                    for (int n=0; i<12;i++) {
                        addObject(new Stone(), i, n);
                    }
                }
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

    }
}