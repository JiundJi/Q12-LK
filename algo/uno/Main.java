public class Main {
  public static void main(String[] args) {
    Deck deck = new Deck(10);
    System.out.println(deck.toString());
    deck.insertionsort();
    System.out.println(deck.toString());
  }
}
