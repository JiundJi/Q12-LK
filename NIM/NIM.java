package NIM;
import java.util.Scanner;
public class NIM {
  public static Scanner sc = new Scanner(System.in); 
  private Streichholzhaufen haufen = new Streichholzhaufen();

  public NIM() {

  }

  public void startGamePvP() {
    String m;
    System.out.println("Name Spieler 1: ");
    m = sc.nextLine();
    private Player player1 = new Player(m);

    System.out.println("Name Spieler 2: ");
    m = sc.nextLine();
    private Player player2 = new Player(m);

    while (!haufen.isEmpty()) {
      System.out.println("________________________________________________")
      System.out.println("Es sind " + haufen.getStreichholzAnzahl() + " Streichhölzer vorhanden");
      System.out.println("Spieler 1: Wie viele Streichhölzer nimmst du? ");
    }
    
  }
  
  public static void main (String[]args) {
    int modus;
    do {
      System.out.println("Spielmodus wählen");
      modus = sc.nextInt();
      if (modus == 1) startGamePvP();
      else if (modus == 2) startGamePvCleicht();
      else if (modus == 3) startGamePvCschwer();
      System.out.println("Nochmal? (y/n)");
      String nochmal = sc.nextLine();
    } while(nochmal.equals("y") || nochmal.equals("Y"));
  }
}
