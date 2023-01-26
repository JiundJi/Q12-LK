public class Vokabel {
  private String deutsch;
  private String englisch;
  private Vokabel nextVokabel;
  
  public Vokabel(String deutsch, String englisch) {
    this.deutsch = deutsch;
    this.englisch = englisch;
    this.nextVokabel = null;
  }
  
  public String toString() {
    return this.deutsch+" - "+this.englisch;
  }
  
  public String getEnglisch() {
    return this.englisch;
  }
  
  public String getDeutsch() {
    return this.deutsch;  
  }
  
  public void setNextVokabel(Vokabel nextVokabel) {
    this.nextVokabel = nextVokabel;
  }
  
  public Vokabel getNextVokabel() {
    return this.nextVokabel;
  }
}
