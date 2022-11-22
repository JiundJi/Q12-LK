public class Vokabelkasten {
    private Vokabel vf[];

    public Vokabelkasten(int anzahl) {
        vf = new Vokabel[anzahl];
    }
    
    public boolean addVokabel() {
        //!TO-DO
    }

    public int getVokabelanzahl() {
        return vf.length;
    }

    public Vokabel getVokabel(String deutsch) {
        if (deutsch == null) return null;
        for (int = 0; i < vf.length; i++) {
            if (vf[i] != null & vf[i].getDeutsch().equals(deutsch)) {
                return vf[i];
            }
        }
        return null;
    }
    
    public Vokabel getVokabelBinaer(String deutsch) {
        if (deutsch == null) return null;
        int zahl = (int) (vf.length / 2);
        int ug = 0;
        int og = vf.length-1;
        boolean found = false;
        while(!found) {
            if (vf[zahl] == null) {
                og = zahl;
            } else {
                if(vf.getDeutsch[zahl].compareTo(deutsch) == 0){return vf[zahl];}
                else if(vf.getDeutsch[zahl].compareTo(deutsch) > 0) {
                    if (zahl == ug) {
                        return null;
                    }
                    ug = zahl;
                }
                else {
                    if(zahl == og) {
                        return null;
                    }
                    og = zahl;
                }
            }
            zahl = (int) (og/2);
        }
    }
}