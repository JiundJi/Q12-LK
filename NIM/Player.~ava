//package NIM;
import java.util.Scanner;
public class Player {
  public static Scanner sc = new Scanner(System.in); 
  private String name;
  public Player (String name){
    this.name = name;
  }
  public Player () {
    
  }
  
  public void ziehe(Streichholzhaufen haufen, int anzahl) {
    int n;
    if (haufen.isValidAnzahl(anzahl))  {
      haufen.removeStreichholz(anzahl);
      return;
    }
    else {
      do {
        System.out.println("Ungueltige Zahl. Nochmal");
        n = sc.nextInt();
      } while (!haufen.isValidAnzahl(n));
    }
  }  
  
  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
  }
}
