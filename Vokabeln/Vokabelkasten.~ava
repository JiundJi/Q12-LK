public class Vokabelkasten {
  private Vokabel[] vokabelfeld;

  public Vokabelkasten(int n) {
    vokabelfeld = new Vokabel[n];
  }

  public boolean addVokabel(Vokabel v) {
    if(v == null || vokabelfeld[vokabelfeld.length-1] != null) {System.out.println("vokabel = null / feld ist voll"); return false;}
    else if (vokabelfeld[0] == null) {vokabelfeld[0] = v; System.out.println("an stelle 0"); return true;}
    else {
      for(int ziel=0; ziel<vokabelfeld.length-1;ziel++) {
        if (v.getDeutsch().compareTo(vokabelfeld[ziel].getDeutsch())==0) {System.out.println("vokabel doppelt"); return false;} //doppelte vokabel
        if (v.getDeutsch().compareTo(vokabelfeld[ziel].getDeutsch())<0) {
          for (int j=vokabelfeld.length-1;j>ziel;j--) {
            vokabelfeld[j] = vokabelfeld[j-1];
          }
          vokabelfeld[ziel] = v;
          System.out.println("hat funktioniert");
          return true;
        }
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
        System.out.println("da ist eine vokabel");
        text = (text + "\n" + vokabelfeld[i].getDeutsch() + " = " + vokabelfeld[i].getEnglisch() + "\n");
      }
    }
    System.out.println(text);
    return (text);
  }
  
}
