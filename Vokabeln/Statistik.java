public class Statistik {
    private int anzahlRichtig = 0;
    private int anzahlFalsch = 0;

    public Statistik() {

    }
    public int getAnzahlRichtig() {
        return anzahlRichtig;
    }
    public int getAnzahlFalsch() {
        return anzahlFalsch;
    }
    public void addRichtigeAntwort() {anzahlRichtig++;}
    public void addFalscheAntwort() {anzahlFalsch++;}
}
