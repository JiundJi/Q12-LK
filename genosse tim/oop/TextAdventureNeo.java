public class TextAdventureNeo {
  // Anfang Attribute//
  private Raum physik;
  private Raum chemie;
  private Raum mathe;
  private Raum erdkunde;
  private Raum mensa;
  private Raum sporthalle;
  private Raum eingang;
  private Raum musikraum;
  private Raum deutsch;
  private Raum kunst;
  private Raum atrium;
  private Raum secret1;
  private Raum secret2;
  private Raum secret3;
  private Raum saniraum;
  private Raum bio;
  private Raum schulleiterbüro;
  private Raum lehrerzimmer;
  private Raum bibliothek;
  private Raum computerraum;
  private Raum somethingsWrong;
  private Raum rattenversteck;
  
  private Raum nordflurU;
  private Raum westflurU;
  private Raum suedflurU;
  private Raum ostflurU;
  private Raum nordflurO;
  private Raum westflurO;
  private Raum suedflurO;
  private Raum ostflurO;
  private Raum nordwesttreppenhaus;
  private Raum suedwesttreppenhaus;
  private Raum nordosttreppenhaus;
  private Raum suedosttreppenhaus;
  private Raum kellerflurW;
  private Raum kellerflurO;
  private Raum fahradkeller;
  private Raum hausmeisterraum;
  
  private Player player;
  
  private boolean gameOn = true;
  private String currentId;
  private String currentName;
  private String currentInhalt;
  
  // Ende Attribute
  
  public TextAdventureNeo() {
    physik = new Raum("1","im Physikraum", "Vor dir steht Physikzeug... du solltest das lieber nicht anfassen");
    chemie = new Raum("2","im Chemieraum", "Irgendwas blubbert in ein paar Reagenzgläsern vor dir... riecht wie Zuckerwatte."); 
    mathe = new Raum("3","im Matheraum", "Auf der Tafel stehen Integralrechnungen... renn solange du noch kannst!");  
    erdkunde = new Raum("4","im Erdkunderaum", "Niemand ist da. Einzig ein verstaubter Globus steht auf dem Lehrertisch.");  
    mensa = new Raum("5","in der Mensa", "Du siehst sehr viele Schüler die am Kiosk anstehen.");  
    sporthalle = new Raum("6","in der Sporthalle", "Es liegen ein paar Basketbälle rum.");  
    eingang = new Raum("7","im Eingangsbereich", "Es gibt viel zu entdecken! Erkunde die Schule.");  
    musikraum = new Raum("8","im Musikraum", "Viele verschiedene Instrumente liegen rum."); 
    deutsch = new Raum("9","im Deutschraum", "Du siehst verzweifelte Schüler und ein Aufgabenblatt auf dem eine Gedichtsanalyse gefordert ist.");  
    kunst = new Raum("10","im Kunstraum", "Vor dir ist eine leere Leinwand und ein Wasserfarbkasten.");  
    atrium = new Raum("11","im Atrium", "Es ist so still. Eine leichte Brise weht durch das Atrium.");  
    secret1 = new Raum("12"," ", " ");  
    secret2 = new Raum("13"," ", " ");  
    secret3 = new Raum("14"," ", " ");  
    saniraum = new Raum("15","im Saniraum", "Wenn du dich fit genug fühlst, solltest du lieber deine Erkundung fortsetzen");  
    bio = new Raum("16","im Bioraum", "Vor dir steht ein Plastikskelett.");  
    schulleiterbüro = new Raum("17","im Schulleiterbüro", "Du solltest nicht hier sein... geh zurück.");  
    lehrerzimmer = new Raum("18","im Lehrerzimmer", "Vor dir steht eine Kaffeemaschine.");  
    bibliothek = new Raum("19","in der Bibliothek", "Sehr viele Bücherregale stehen im Raum.");  
    computerraum = new Raum("20","im Computerraum", "01001000 01100101 01101100 01101100 01101111 00100001");  
    somethingsWrong = new Raum("0","in fhsieuvnseolvnesiovnseiuvuesbviusbviesuvbiuvbsivbwvbweiuvbwevuw", "iifjesinjevskvbjsiuvbewvdijkewbviuewkjbvewiuvbewivewbviewbsvbewbivewbvfuiewbiwbevbewbvewuvibevwvjebvebevbe");  
    rattenversteck = new Raum("21","im Rattenversteck", "Es riecht nach Ratte.");  
    
    nordflurU = new Raum("22","im Nordflur, Erdgeschoss", " "); 
    westflurU = new Raum("23","im Westflur, Erdgeschoss", " "); 
    suedflurU = new Raum("24","im Südflur, Erdgeschoss", " "); 
    ostflurU = new Raum("25","im Ostflur, Erdgeschoss", " "); 
    nordflurO = new Raum("26","im Nordflur, Obergeschoss", " "); 
    westflurO = new Raum("27","im Westflur, Obergeschoss", " "); 
    suedflurO = new Raum("28","im Südflur, Obergeschoss", " "); 
    ostflurO = new Raum("29","im Ostflur, Obergeschoss", " "); 
    nordwesttreppenhaus = new Raum("30","im Nord-West Treppenhaus", " "); 
    suedwesttreppenhaus = new Raum("31","im Süd-West Treppenhaus", " "); 
    nordosttreppenhaus = new Raum("32","im Nord-Ost Treppenhaus", " "); 
    suedosttreppenhaus = new Raum("33","im Süd-Ost Treppenhaus", " "); 
    kellerflurW = new Raum("34","im Westflur, Kellergeschoss", "Es ist dunkel."); 
    kellerflurO = new Raum("35","im Ostflur Kellergeschoss", "Es ist dunkel."); 
    fahradkeller = new Raum("36","im Fahradkeller", "Es stehen erstaunlich wenige Fahrräder herum."); 
    hausmeisterraum = new Raum("37","im Hausmeisterraum", "Hier ist sehr viel Hausmeisterzeug... und ein Kasten Bier."); 
    
    
  } 
    
  //(norden, sueden, westen,osten): Diese Reihenfolge nicht vergessen!//  
  public void startGame() {
  
    eingang.setAusgaenge(atrium, null, westflurU, ostflurU);
    westflurU.setAusgaenge(nordwesttreppenhaus, suedwesttreppenhaus, deutsch, eingang);
    deutsch.setAusgaenge(null, null, westflurU, null);
    ostflurU.setAusgaenge(nordosttreppenhaus, suedosttreppenhaus, eingang, mensa);
    mensa.setAusgaenge(sporthalle, lehrerzimmer, ostflurU, null);
    sporthalle.setAusgaenge(null, mensa, null, null);
    lehrerzimmer.setAusgaenge(lehrerzimmer, suedflurU, null, schulleiterbüro);
    schulleiterbüro.setAusgaenge(null, null, lehrerzimmer, null); 
    suedflurU.setAusgaenge(lehrerzimmer, bibliothek, suedwesttreppenhaus, suedosttreppenhaus);
    bibliothek.setAusgaenge(suedflurU, computerraum, null, null);
    computerraum.setAusgaenge(bibliothek, null, null, null);
    nordflurU.setAusgaenge(erdkunde, kunst, nordwesttreppenhaus, nordosttreppenhaus);
    erdkunde.setAusgaenge(null, nordflurU, null, null);
    kunst.setAusgaenge(kunst, null, null, null); 
    nordwesttreppenhaus.setAusgaenge(nordflurO, westflurU, kellerflurW, nordflurU);
    nordosttreppenhaus.setAusgaenge(ostflurO, ostflurU, nordflurU, kellerflurO);
    suedwesttreppenhaus.setAusgaenge(westflurU, kellerflurW, suedflurO, suedflurU);
    suedosttreppenhaus.setAusgaenge(ostflurU, kellerflurO, suedflurU, ostflurO);
  
    player = new Player(10, 1, 0, eingang);
    
    game();
  }  
  
  public void game(){
  
    System.out.println("Willkommen in der Schule!");
  
    while (gameOn == true) { 
      
      
      System.out.println(" "); 
      System.out.println("Du befindest dich " + player.getName());  
    } // end of while
  
  }  
    
  public static void main(String[] args){
    TextAdventureNeo spiel = new TextAdventureNeo();
    spiel.startGame();
  }
    
    
    // Anfang Methoden
    // Ende Methoden
}