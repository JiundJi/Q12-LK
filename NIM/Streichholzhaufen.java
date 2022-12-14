//package NIM;
public class Streichholzhaufen {
  private int streichholzAnzahl;
  public Streichholzhaufen (int anzahl) {
    this.streichholzAnzahl = anzahl;
  }
  public Streichholzhaufen() {
    this.streichholzAnzahl = 20;
  }
  public int getStreichholzAnzahl(){
     return streichholzAnzahl;
    }
  
  public boolean removeStreichholz(int anzahl) {
    if (isValidAnzahl(anzahl)) streichholzAnzahl -= anzahl;
    else return false;
    return true;
  }
  
  public boolean isEmpty() {
    if (streichholzAnzahl <= 0) return true;
    return false;
  }

  public boolean isValidAnzahl(int anzahl) {
    if (anzahl >= 1 && anzahl <= 3) return true;
    return false;
  }
}
