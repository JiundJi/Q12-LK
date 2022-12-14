public class Vokabel {
  
  private String deutsch;
  private String englisch;
  
  public Vokabel(String deutsch, String englisch) {
    this.deutsch = deutsch;
    this.englisch = englisch;
  }
  
  public String getDeutsch() {
    return this.deutsch;
  }
  
  public String getEnglisch() {
    return this.englisch;
  }
  
  public boolean isEnglischKorrekt(String text) {
    return this.englisch.equalsIgnoreCase(text);
  }
  
  public boolean isDeutschKorrekt(String text) {
    return this.deutsch.equalsIgnoreCase(text);
  }
  
  @Override
  public String toString() {
    return this.deutsch + " - " + this.englisch;
  }

}
