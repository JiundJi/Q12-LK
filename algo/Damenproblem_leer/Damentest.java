/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 08.11.2019
 * @author 
 */

public class Damentest {
  
  public static void main(String[] args) {
    int brettgroesse = InOut.readInt("Wie groß soll das Schachbrett sein? (1-10) ");
    Damenproblem damenproblem = new Damenproblem(brettgroesse);
    System.out.println("\n\n    "+brettgroesse+"-Damen-Problem");
    System.out.println("***********************************************");
    int anzahl = damenproblem.findeAlleLoesungen();
    System.out.println("\n***********************************************");
    System.out.println("Es konnten "+anzahl+" Lösungen gefunden werden.");
  } // end of main



}

