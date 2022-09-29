package NIM;
public class Streichholzhaufen {
  private int streichholzAnzahl;
  public Streichholzhaufen (int anzahl) {
    this.streichholzAnzahl = anzahl;
  }
  public Streichholzhaufen() {
    this.streichholzAnzahl = 20;
  }
  public int getStreichholzAnzahl() return streichholzAnzahl;
  
  public boolean removeStreichholz(int anzahl) {
    if (anzahl == null) return false;
    if (anzahl > streichholzAnzahl) {
      streichholzAnzahl -= anzahl;
      return true;
    }
      return false;
  }
  
  public boolean isEmpty() {
    if (streichholzAnzahl <= 0) return true;
    return false;
  }

  public boolean isValidAnzahl(int anzahl) {
    if (anzahl != null && anzahl >= 1 && anzahl <= 3) return true;
    return false;
  }
}