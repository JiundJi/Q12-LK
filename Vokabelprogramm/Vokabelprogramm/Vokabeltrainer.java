import javax.security.auth.login.CredentialException;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 02.10.2019
 * @author 
 */

public class Vokabeltrainer {
  
  private Vokabel startVokabel;    
  
  public Vokabeltrainer() {
    this.startVokabel = null;
  }
  
  public boolean addVokabel(Vokabel neueVokabel) {
    if (neueVokabel == null) return false;
    if (startVokabel == null) {
      startVokabel = neueVokabel;
    } else {
      Vokabel cursor = startVokabel;
      while (cursor.getNextVokabel() != null) {
        cursor = cursor.getNextVokabel();
      }
      cursor.setNextVokabel(neueVokabel);
    }

    return true;
  }
  
  public int getVokabelanzahl() {
    if (startVokabel == null) return -1;
    int count = 1;
    Vokabel cursor = startVokabel;
    while (cursor.getNextVokabel() != null) {
      cursor = cursor.getNextVokabel();
      count++;
    }
    return count;
  }
  
  public Vokabel getVokabel(int nr) {
    Vokabel cursor = startVokabel;
    while (nr > 0) {
      cursor = cursor.getNextVokabel();
      nr--;
    }
    System.out.println(cursor.getDeutsch());
    return cursor;
  }

  public boolean addVokabelVorne(Vokabel newVokabel) {
    if (newVokabel == null) return false;
    if (startVokabel == null) {startVokabel = newVokabel; return true;}
    else {
      newVokabel.setNextVokabel(startVokabel);
      startVokabel = newVokabel;
    }
    return true;
  }

  public boolean addVokabelSorted(Vokabel newVokabel) {
    if (newVokabel == null) return false;
    if (startVokabel == null) {startVokabel = newVokabel; return true;}
    else {
      Vokabel cursor = startVokabel;
      while (newVokabel.getDeutsch().compareTo(cursor.getDeutsch()) < 0 || newVokabel.getDeutsch().equals(cursor.getDeutsch())) {
        if (cursor.getNextVokabel() == null) {
          cursor.setNextVokabel(newVokabel);
          return true;
        } else {
          cursor = cursor.getNextVokabel();
        }
      }
      newVokabel.setNextVokabel(cursor.getNextVokabel());
      cursor.setNextVokabel(newVokabel);
    }
    return true;
  }

  public void printVokabeln() {
    System.out.println("\nListe der Vokabeln");
    Vokabel cursor = this.startVokabel;
    while (cursor != null) {
      System.out.println(cursor.toString());
      cursor = cursor.getNextVokabel();
    }
  }
  
}

