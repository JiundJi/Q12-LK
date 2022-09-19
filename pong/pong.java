package pong;
import java.util.Scanner;

public class pong {
  Ball ball = new Ball();
  Player player1 = new Player();
  Player player2 = new Player();

  public static Scanner sc = new Scanner(System.in); 

  public void main(String[]args) {
    String m = "";
    while (m != "n") {
      game();

      m = sc.nextLine();
    }
  }

  public void game () {
    while (player1.getScore() != 10 || player2.getScore() != 10) {
      while (!hasScored()) {
        if (touchesPlayer(1)) {ball.setDirection(90);}
        else if (touchesPlayer(2)) {ball.setDirection(270);}
        move();
      }
      if (ball.getX() == 0) {
        player2.addScore();
      } else if (ball.getX() == 100) {
        player1.addScore();
      }
    }  
  }


  private void move() {
    if (touchesWall()) {

    }
  }
  private boolean hasScored() {
    if (ball.getX() == 0 || ball.getX() == 100) {
      return true;
    }
    return false;
  }

  private boolean touchesPlayer (int n) {
    switch (n) {
      case 1:
      if (player1.getX() == ball.getX()) {
        return true;
      } else {
        return false;
      }

      case 2:
      if (player2.getX() == ball.getX()) {
        return true;
      } else {
        return false;
      }
    }
    return false;
  }
  private boolean touchesWall () {
    if (ball.getY() == 0 || ball.getY() == 100) {
      return true;
    }
    return false;
  }
}