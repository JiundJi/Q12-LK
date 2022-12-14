//package NIM;
import java.util.Scanner;
public class NIM {
  public static Scanner sc = new Scanner(System.in); 
  private Streichholzhaufen haufen = new Streichholzhaufen();
  private Player player;
  private Player player1;
  private Player player2;
  private Player computer;
  public String nochmal;

  public NIM() {
    
  }

  public void startGamePvP() {
    String m;
    int n;
    int zuletztGezogen = 0;
    System.out.println("Name Spieler 1: ");
    m = InOut.readString("");
    player1 = new Player(m);

    System.out.println("Name Spieler 2: ");
    m = InOut.readString("");
    player2 = new Player(m);

    while (!haufen.isEmpty()) {
      System.out.println("________________________________________________");
      System.out.println("Es sind " + haufen.getStreichholzAnzahl() + " Streichhölzer vorhanden");
      System.out.println("Spieler 1: Wie viele Streichhölzer nimmst du? ");
      n = sc.nextInt();
      player1.ziehe(haufen, n);
      System.out.println("Du ziehst " + n + " Streichhölzer");
      zuletztGezogen++;

      if (haufen.isEmpty()) break;

      System.out.println("________________________________________________");
      System.out.println("Es sind " + haufen.getStreichholzAnzahl() + " Streichhölzer vorhanden");
      System.out.println("Spieler 2: Wie viele Streichhölzer nimmst du? ");
      n = sc.nextInt();
      player2.ziehe(haufen, n);
      System.out.println("Du ziehst " + n + " Streichhölzer");
      zuletztGezogen--;
    }
    
    System.out.println("________________________________________________\n");
    System.out.println("________________________________________________");
    if (zuletztGezogen == 1) System.out.println("Spieler 1 hat gewonnen!");
    else if (zuletztGezogen == 0) System.out.println("Spieler 2 hat gewonnen!");
  }

  public void startGamePvCleicht() {
    String m;
    int n;
    int zuletztGezogen = 0;
    player = new Player();
    computer = new Player("Computer");

    while (!haufen.isEmpty()) {
      System.out.println("________________________________________________");
      System.out.println("Es sind " + haufen.getStreichholzAnzahl() + " Streichhölzer vorhanden");
      System.out.println("Spieler 1: Wie viele Streichhölzer nimmst du? ");
      n = sc.nextInt();
      player.ziehe(haufen, n);
      System.out.println("Du ziehst " + n + " Streichhölzer");
      zuletztGezogen++;

      if (haufen.isEmpty()) break;

      n = (int)(Math.random()*4);
      computer.ziehe(haufen, n);
      System.out.println("Computer zieht "+ n + " Streichhölzer");
      zuletztGezogen--;
    }
    
    System.out.println("________________________________________________\n");
    System.out.println("________________________________________________");
    if (zuletztGezogen == 1) System.out.println("Spieler hat gewonnen!");
    else if (zuletztGezogen == 0) System.out.println("Computer hat gewonnen!");
  }

  public void startGamePvCschwer() {
    String m;
    int n;
    int zuletztGezogen = 0;
    player = new Player();
    computer = new Player("Computer");

    while (!haufen.isEmpty()) {
      System.out.println("________________________________________________");
      System.out.println("Es sind " + haufen.getStreichholzAnzahl() + " Streichhölzer vorhanden");
      System.out.println("Spieler 1: Wie viele Streichhölzer nimmst du? ");
      n = sc.nextInt();
      player.ziehe(haufen, n);
      System.out.println("Du ziehst " + n + " Streichhölzer");
      zuletztGezogen++;

      if (haufen.isEmpty()) break;

      n = 3 - n;
      if (n == 0) n = 3;
      computer.ziehe(haufen, n);
      System.out.println("Computer zieht "+ n + " Streichhölzer");
      zuletztGezogen--;
    }
    
    System.out.println("________________________________________________\n");
    System.out.println("________________________________________________");
    if (zuletztGezogen == 1) System.out.println("Spieler hat gewonnen!");
    else if (zuletztGezogen == 0) System.out.println("Computer hat gewonnen!");
  }
      
  public void startGame() {
   int modus;
    do {
      System.out.println("Spielmodus wählen");
      System.out.println("[1] Spieler gegen Spieler");
      System.out.println("[2] Spieler gegen leichten Computer");
      System.out.println("[3] Spieler gegen schweren Computer");
      modus = sc.nextInt();
      if (modus == 1) startGamePvP();
      else if (modus == 2) startGamePvCleicht();
      else if (modus == 3) startGamePvCschwer();
      System.out.println("Nochmal? (y/n)");
      nochmal = InOut.readString("");
    } while(nochmal.equals("y") || nochmal.equals("Y"));
  }      

  public static void main (String[]args) {
    NIM nim = new NIM();
    nim.startGame();
  }
}
