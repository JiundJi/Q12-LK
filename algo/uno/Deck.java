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
    for (int i = 0; i < cardfield.length; i++) {
      Card stored = cardfield[i];
      int position = i;
      while (position > 0 && stored.getNumber() < cardfield[position - 1].getNumber()) {
        cardfield[position] = cardfield[position - 1];
        position--;
      }
      cardfield[position] = stored;
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
