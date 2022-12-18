import java.util.Scanner;

public class Main {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    Deck deck = new Deck(20);
    deck.sort();
    System.out.println(deck.toString());
  }
}
