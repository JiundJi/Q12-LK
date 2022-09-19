package pong;
public class Ball{
    private int posX;
    private int posY;
    private int direction;

    public int getX () {
        return posX;
    }
    public int getY () {
        return posY;
    }
    public void setX (int n) {
        posX += n;
    }
    public void setY (int n) {
        posY += n;
    }

    public int getDirection() {
        return direction;
    }
    public void setDirection(int n) {
        switch (n) {
            case 90: direction = (int) (Math.random() * 181);
            case 270: direction = (int) (Math.random() * 181 + 180);
        }
    }
}