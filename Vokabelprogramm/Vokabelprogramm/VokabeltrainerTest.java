/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 12.11.2019
 * @author 
 */

public class VokabeltrainerTest {
  
  public static void main(String[] args) {
    
    Vokabeltrainer vt = new Vokabeltrainer();
    
    char wahl = 'x';
    while (wahl != 'q') {
      System.out.println("\nWillkommen beim Vokabelnlernen");
      System.out.println("[l] Liste der Vokabeln");
      System.out.println("[a] Eine neue Vokabel hinzuf?gen");
      System.out.println("[v] Eine neue Vokabel vorne hinzuf?gen");
      System.out.println("[s] Eine neue Vokabel sortiert hinzuf?gen");
      System.out.println("[n] Die Vokabel an Index wiedergeben");
      System.out.println("[h] Anzahl der Vokabeln");
      System.out.println("[q] beenden");
      wahl = InOut.readChar("Ihre Wahl: ");
      
      switch (wahl) {
        case 'q': break;
        case 'l': vt.printVokabeln();
                  break;
        case 'a': 
                  String deutsch = InOut.readString("Deutsche Vokabel: ");
                  String englisch = InOut.readString("Englische Vokabel: ");
                  Vokabel v = new Vokabel(deutsch, englisch);
                  vt.addVokabel(v);
                  break;
        case 'v': 
                  deutsch = InOut.readString("Deutsche Vokabel: ");
                  englisch = InOut.readString("Englische Vokabel: ");
                  v = new Vokabel(deutsch, englisch);
                  vt.addVokabelVorne(v);
                  break;
        case 's': 
                  deutsch = InOut.readString("Deutsche Vokabel: ");
                  englisch = InOut.readString("Englische Vokabel: ");
                  v = new Vokabel(deutsch, englisch);
                  vt.addVokabelSorted(v);
                  break;
        case 'n': 
                  int nr = InOut.readInt("Index: ");
                  vt.getVokabel(nr);
                  break;
        case 'h': 
                  System.out.println("" + vt.getVokabelanzahl());
                  break;
      }
    }
  }

}

