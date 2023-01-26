public class Uno {
  public static void main(String[] args) {
    Deck deck = new Deck(10);
    System.out.println(deck.toString());
    deck.sort();
    System.out.println(deck.toString());
  }
}