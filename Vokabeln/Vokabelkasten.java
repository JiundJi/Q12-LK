public class Vokabelkasten {
  private Vokabel[] vokabelfeld;

  public Vokabelkasten(int n) {
    vokabelfeld = new Vokabel[n];
  }

  public boolean addVokabel(Vokabel v) {
    for (int i=0;i<vokabelfeld.length;i++) {
        if (vokabelfeld[i] == null) {
            vokabelfeld[i] = v;
            return true;
        }
    }
    return false;
  }
  public int getVokabelanzahl() {
    return vokabelfeld.length;
  }
  public Vokabel getVokabel(int id) {
    return vokabelfeld[id];
  }
  public boolean deleteVokabel(String deutsch) {
    for (int i=0;i<vokabelfeld.length;i++) {
        if (vokabelfeld[i].getDeutsch() == deutsch) {
            vokabelfeld[i] = null;
            return true;
        }
    }
    return false;
  }

  public String toString() {
    return "-1";
  }
  
}
