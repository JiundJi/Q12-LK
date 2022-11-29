public class Deck {
  private Card cardfield[];

  public Deck(int count) {
    cardfield = new Card[count];
    for (int i = 0; i < count; i++) {
      cardfield[i] = new Card((int) (Math.random() * 10));
    }
  }

  public void bubblesort(){
    boolean done = false;
    while (!done) {
      done = true;
      for (int i = 0; i < cardfield.length-1; i++) {
        if (cardfield[i].getNumber() > cardfield[i+1].getNumber()) {
          Card stored = cardfield[i+1];
          cardfield[i+1] = cardfield[i];
          cardfield[i] = stored;
          done = false;
        }
      }
    }
  }


  public void selectionsort() {
    int position = 0;
    for (int grenze = 0; grenze < cardfield.length; grenze++) {
      position = grenze;
      for (int i = grenze; i < cardfield.length; i++) {
        if (cardfield[i].getNumber() < cardfield[position].getNumber()) {
          position = i;
        }
      }
      Card stored = cardfield[position];
      cardfield[position] = cardfield[grenze];
      cardfield[grenze] = stored;
      System.out.println(toString());
    }
  }


  public void insertionsort() {
    Card stored = new Card(0);
    int position = -1;
    for (int i = 0; i < cardfield.length-1; i++) {
      if (cardfield[i].getNumber() > cardfield[i+1].getNumber()) {
        stored = cardfield[i+1];
        position = i+1;
        for (int j = i; j >= 0; j--) {
          if (cardfield[j].getNumber() < stored.getNumber()) {
            for (int k = position; k > j; k--) {
              cardfield[k] = cardfield[k-1];
            }
            cardfield[j] = stored;
          }
        }
      }
    }
  }


  public String toString() {
    String foo = "debug\n";
    for (int i = 0; i < cardfield.length; i++) {
      foo += cardfield[i].getNumber() + " ";
    }
    return foo;
  }
}
