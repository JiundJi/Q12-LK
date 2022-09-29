import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diamond here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diamond extends Actor
{
    private int color = 0;
   
    /**
     * Act - do whatever the Diamond wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        // Add your action code here.
    }    


    
    private void changeImage() {
       switch(color) {
           case 0: setImage(new GreenfootImage("DiamondBlue.png"));
                   color = 1;
                   break;
           case 1: setImage(new GreenfootImage("DiamondRed.png"));
                   color = 2;
                   break;
           case 2: setImage(new GreenfootImage("DiamondGold.png"));
                   color = 0;
                   break;
       }
    }
    
    public boolean isBlue() {
        if (color == 0) return true;
        return false;
    }
    private boolean isRed() {
        if (color == 1) return true;
        return false;
    }
    protected boolean isGold() {
        if (color == 2) return true;
        return false;
    }

    public String getColor() {
        switch (color) {
            case 0: return "blue";
            case 1: return "red";
            case 2: return "gold";
        }
        return "";
    }

    public boolean goNorth() {
        if (canMove(0)) {
            setLocation(getX(), getY() - 1);
            return true;
        }
        return false;
    }
    public boolean goWest() {
        if (canMove(1)) {
            setLocation(getX() - 1, getY()); 
            return true;
        }
        return false;
    }
    public boolean goSouth() {
        if (canMove(2)) {
            setLocation(getX(), getY() + 1); 
            return true;
        }
        return false;
    }
    public boolean goEast() {
        if (canMove(3)) {
            setLocation(getX() + 1, getY());
            return true;
        }
        return false;
    }
    
        /**
     * Test if we can move forward. 
     * 0 - North
     * 1 - West
     * 2 - South
     * 3 - East
     * Return true if we can, false otherwise.
     */
    public boolean canMove(int direction)
    {
        int x = getX();
        int y = getY();
        switch(direction) {
            case 0 : // NORTH
                y--;
                break;
            case 1 : // WEST
                x--;
                break;
            case 2 : // SOUTH
                y++;
                break;
            case 3 : // EAST
                x++;
                break;
        }
        // test for outside border
        World myWorld = getWorld();
        if (x >= myWorld.getWidth() || y >= myWorld.getHeight()) {
            return false;
        }
        else if (x < 0 || y < 0) {
            return false;
        }
        // test for stone
        Actor stone = getOneObjectAtOffset(x-getX(), y-getY(), Stone.class);
        if (stone != null) return false;
        
        // test for diamonts
        Diamond diamond = (Diamond) getOneObjectAtOffset(x-getX(), y-getY(), Diamond.class);
        if (diamond != null) {
            return false;
        }
        
        return true;
    }
}
