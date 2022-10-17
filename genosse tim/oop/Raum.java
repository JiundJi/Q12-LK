public class Raum{
  
  // Anfang Attribute
  private String beschreibung;
  
  private Raum norden;
  private Raum sueden;
  private Raum westen;
  private Raum osten;
  private String raumId;
  private String raumName;
  private String raumInhalt;
  private boolean nActive = true;
  private boolean sActive = true;
  private boolean wActive = true;
  private boolean oActive = true;
  private Player player;
  // Ende Attribute
  
  public Raum (String raumId,String raumName, String raumBeschreibung) {
    this.raumId = raumId; 
    this.raumName = raumName;  
    this.raumInhalt = raumBeschreibung;
  }   
  // Anfang Methoden
  
  public void setAusgaenge(Raum n, Raum s, Raum w, Raum o){
    this.norden = n;
    this.sueden = s;
    this.westen = w;
    this.osten = o;
    
    if(n == null) nActive = false;
    if(n == null) sActive = false;
    if(n == null) wActive = false;
    if(n == null) oActive = false;
  }   
  
  public String getId(){
    return this.raumId;     
  }
  
  public String getName(){
    return this.raumName;     
  }
  
  public String getBeschreibung(){
    return this.raumInhalt;     
  }
  
  
  
  
  public void getNordAusgang(){
    if(nActive == true)  {
      player.changeRoom(this.norden);
    }
    return;
  }
  
  public void getSuedAusgang(){
    if(sActive == true)  {
      player.changeRoom(this.sueden);
    }
    return;
  }
  
  public void getWestAusgang(){
    if(wActive == true)  {
      player.changeRoom(this.westen);
    }
    return;
  }
  
  public void getOstAusgang(){
    if(oActive == true)  {
      player.changeRoom(this.osten);
    }
    return;
  }
      
  // Ende Methoden
}

