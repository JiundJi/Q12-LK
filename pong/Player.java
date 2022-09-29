package pong;
public class Player {
    private int posX;
    private int posY;
    private String name;
    private int score;
    private String direction;

    public int getX () {
        return posX;
    }
    public int getY () {
        return posY;
    }
    public String getName () {
        return name;
    }
    public int getScore () {
        return score;
    }
    public String getDirection() {
        return direction;
    }
    public void setDirection(String n) {
        switch (n) {
            case "up":      direction = "up";
            case "down":    direction = "down";
        }
    }
    public void addScore() {
        score++;
    }
}