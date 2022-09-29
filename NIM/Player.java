package NIM;
public class Player {
  private String name();
  public Player (String name){
    this.name = name;
  }
  public void ziehe(Streichholzhaufen haufen, int anzahl) {
    haufen.removeStreichholz();
  }  
  public String getName(){
    return name;
  }
}
