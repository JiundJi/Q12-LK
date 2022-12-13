/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 01.10.2017
  * @author 
  */

public class Damenproblem {

  private int zaehler;
  private boolean[][] feld;
  
  public Damenproblem(int anzahl) {
    this.feld = new boolean[anzahl][anzahl];
    for (int i=0; i<anzahl; i++)
      for (int a=0; a<anzahl; a++)
        feld[i][a]=false;

    this.zaehler = 0;    
  }
  
  public int findeAlleLoesungen() {
    this.zaehler = 0;
    dame(0);
    return this.zaehler;
  }
  
  private void dame(int zeile) {
    for (int spalte=0; spalte<=feld[0].length-1; spalte++) {
      feld[zeile][spalte] = true;
      if (isZugGueltig(zeile, spalte)){
        if (zeile >= feld[0].length-1) {
          zaehler++;
          System.out.println("\n" + zaehler + ". Lösung gefunden:");
          printField();
        } else {
          dame(zeile+1);
        }
      }
      feld[zeile][spalte] = false;
    }
  }

  private boolean isZugGueltig(int zeile, int spalte) {
     // waagerecht und senkrecht
     for (int i=0; i<feld[0].length; i++) {
        if ((i!=spalte) && (feld[zeile][i]==true)) return false;
        if ((i!=zeile) &&  (feld[i][spalte]==true)) return false;
     }
    // diagonal nach links oben
    int z = zeile-1;
    int s = spalte-1;
    while((z>=0) && (s>=0)) {
      if (feld[z][s] == true) return false;
      z--; s--;
    }

    // diagonal nach rechts unten
    z = zeile+1;
    s = spalte+1;
    while((z<feld[0].length) && (s<feld[0].length)) {
      if (feld[z][s] == true) return false;
      z++; s++;
    }

    // diagonal nach links unten
    z = zeile-1;
    s = spalte+1;
    while((z>=0) && (s<feld[0].length)) {
      if (feld[z][s] == true) return false;
      z--; s++;
    }

    // diagonal nach rechts oben
    z = zeile-1;
    s = spalte+1;
    while((z>=0) && (s<feld[0].length)) {
      if (feld[z][s] == true) return false;
      z--; s++;
    }

    return true;
  }

  private void printField() {
    for (int zeile = 0; zeile < feld[0].length; zeile++) {
      System.out.print("+");
      for (int i=0; i<feld[0].length; i++) System.out.print("---+");
      System.out.println("");
      System.out.print("|");
      for (int spalte = 0; spalte < feld[0].length; spalte++) {
         if (feld[zeile][spalte]) System.out.print(" D |");
         else System.out.print("   |");
      }
      System.out.println("");
    }
    System.out.print("+");
    for (int i=0; i<feld[0].length; i++) System.out.print("---+");
    System.out.println("");
  }

} // end of class Damenproblem
