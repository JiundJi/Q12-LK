public class pong {
  public static void main(String[]args) {
    Ball ball = new Ball();
    Player player1 = new Player();
    Player player2 = new Player();
  }
}
public class Ball {
  private int posX;
  private int posY;
}

public class Player {
  private int posX;
  private int poxY;
  private String name;
  private int score;
}