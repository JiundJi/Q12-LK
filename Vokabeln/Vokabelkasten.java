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
            for (int j=i; j<vokabelfeld.length - 1;j++) {
              vokabelfeld[j] = vokabelfeld[j+1];
            }
            vokabelfeld[vokabelfeld.length - 1] = null;
            return true;
        }
    }
    return false;
  }

  public String toString() {
    String text = "\n";
    for (int i=0; i<vokabelfeld.length-1;i++) {
      if (vokabelfeld[i] != null) {
        text = (vokabelfeld[i].getDeutsch() + " = " + vokabelfeld[i].getEnglisch() + "\n");
      }
    }
    return text;
  }
  
}
