<<<<<<< HEAD:algo/uno/Uno.java
public class Uno {
=======
import java.util.Scanner;

public class Main {
  static Scanner sc = new Scanner(System.in);

>>>>>>> 717e8f18233c241fbcdfbc7cb875d87a6e9d2d00:algo/uno/Main.java
  public static void main(String[] args) {
    Deck deck = new Deck(20);
    deck.sort();
    System.out.println(deck.toString());
  }
}