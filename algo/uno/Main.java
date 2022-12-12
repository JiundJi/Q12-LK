import java.util.Scanner;

public class Main {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    Deck deck = new Deck(20);
    System.out.println(deck.toString());
    deck.quicksort(0, 19);
    System.out.println(deck.toString());

    // int m = sc.nextInt();
    // while (true) { 
    //   m = sc.nextInt();
    //   System.out.println("::" + deck.search(m));
    // } // end of while
    
  }
}
