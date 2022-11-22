public class Vokabelkasten {
  
  private Vokabel[] vokabelfeld;
  
  public Vokabelkasten(int anzahl) {
    vokabelfeld = new Vokabel[anzahl];
  }
  
  public boolean addVokabel(Vokabel v) {
    for(int i=0; i<vokabelfeld.length; i++) {
      if (vokabelfeld[i] == null) {
        vokabelfeld[i] = v;
        return true;
      }
    }
    return false;
  }
  
  public int getVokabelanzahl() {
    return -1;
  }
  
  public Vokabel getVokabel(int nr) {
    return null;
  }
  
  public boolean deleteVokabel(String deutsch) {
    return false; 
  }
  
  @Override
  public String toString() {
    String output = "";
    for (int i=0; i<vokabelfeld.length; i++) {
      if (this.vokabelfeld[i] != null) {
        output = output + "\n" + this.vokabelfeld[i].toString();
      }
    }
    return output;    
  }

}
