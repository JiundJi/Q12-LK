public class Deck {
  private Card cardfield[];
  public Deck(int count) {
    cardfield = new Card[count];
  }
  public void sort(){
    Card zw = new Card(-1);
    int pos = cardfield.length - 1;
    for (int i=cardfield.length-1; i>0;i--) {
      if (cardfield[i].getNumber() > zw.getNumber()) {
        zw = cardfield[i];
        pos = i;
      }
    }
    cardfield[pos] = cardfield[cardfield.length-1];
    cardfield[cardfield.length-1] = zw;
    for (int og=cardfield.length-1; i>=0; i--){
      zw = cardfield[og];
      for (int j=0; j<og; j++) {
        if (cardfield[j].getNumber()>zw.getNumber()) {
          cardfield[zw] = cardfield[j];
          pos = j;
        }
      }
      cardfield[og] = cardfield[pos];
      cardfield[pos] = zw;
    }
  }
}