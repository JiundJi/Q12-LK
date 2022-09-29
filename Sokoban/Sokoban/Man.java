import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

import java.util.List;
import java.util.ArrayList;

/**
 * Man. A Man has to move diamonts to goals..
 */
public class Man extends Actor
{
    /**
     * Do whatever the man likes to do just now.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("up")) {
            goNorth();
        }
        if (Greenfoot.isKeyDown("down")) {
            goSouth();
        }
        if (Greenfoot.isKeyDown("left")) {
            goWest();
        }
        if (Greenfoot.isKeyDown("right")) {
            goEast();
        }
    }
    
    public void goNorth() {
        Stone stone = (Stone) getOneObjectAtOffset(0, -1, Stone.class);
        if (stone == null) {
            Diamond diamond = (Diamond) getOneObjectAtOffset(0, -1, Diamond.class);
            if (diamond == null) {
                setLocation(getX(), getY() - 1); 
            } else {
                if (diamond.goNorth()) {
                    setLocation(getX(), getY() - 1); 
                }
            }
        }
    }
    
    public void goWest() {
        Stone stone = (Stone) getOneObjectAtOffset(-1, 0, Stone.class);
        if (stone == null) {
            Diamond diamond = (Diamond) getOneObjectAtOffset(-1, 0, Diamond.class);
            if (diamond == null) {
                setLocation(getX() - 1, getY()); 
            } else {
                if (diamond.goWest()) {
                    setLocation(getX() - 1, getY()); 
                }
            }
        }
    }
    
    public void goSouth() {
        Stone stone = (Stone) getOneObjectAtOffset(0, 1, Stone.class);
        if (stone == null) {
            Diamond diamond = (Diamond) getOneObjectAtOffset(0, 1, Diamond.class);
            if (diamond == null) {
                setLocation(getX(), getY() + 1); 
            } else {
                if (diamond.goSouth()) {
                    setLocation(getX(), getY() + 1); 
                }
            }
        }
    }    
    
    public void goEast() {
        Stone stone = (Stone) getOneObjectAtOffset(1, 0, Stone.class);
        if (stone == null) {
            Diamond diamond = (Diamond) getOneObjectAtOffset(1, 0, Diamond.class);
            if (diamond == null) {
                setLocation(getX() + 1, getY()); 
            } else {
                if (diamond.goEast()) {
                    setLocation(getX() + 1, getY()); 
                }
            }
        }
    }      

}
