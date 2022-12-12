public class Deck {
  private Card cardfield[];

  public Deck(int count) {
    cardfield = new Card[count];
    for (int i = 0; i < count; i++) {
      cardfield[i] = new Card((int) (Math.random() * 100));
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

  public void quicksort(int left, int right) {
    if (left >= right) {
      return;
    }
    Card temp;
    int middle;
    int pivot = this.cardfield[left].getNumber();
    int i = left++;
    int j = right;
    while (i <= j) {
      while (j >= i && this.cardfield[j].getNumber() > pivot) {
        j--;
      }
      while (i <= j && this.cardfield[i].getNumber() < pivot) {
        i++;
      }
      if (i <= j) {
        temp = this.cardfield[i];
        this.cardfield[i] = this.cardfield[j];
        this.cardfield[j] = temp;
        i++;
        j--;
      }
    }
    temp = this.cardfield[j];
    this.cardfield[j] = this.cardfield[left];
    this.cardfield[left] = temp;
    middle = j;
    System.out.println(toString());
    quicksort(left, middle--);
    quicksort(middle++, right);
  }

  public Card search(int number) {
    return searchBinary(number, 0, cardfield.length-1);
  }

  private Card searchBinary(int number, int left, int right) {
    int m = (int) ((right+left)/2);

    if (number == cardfield[m].getNumber()) return cardfield[m];
    else if ((right-left) <= 1) return null;
    else if (number > cardfield[m].getNumber()) {
      if (cardfield[m++].getNumber() == cardfield[right].getNumber()) return cardfield[right];
      return searchBinary(number, m, right);
    }
    else if (number < cardfield[m].getNumber()) {
      if (cardfield[m--].getNumber() == cardfield[left].getNumber()) return cardfield[left];
      return searchBinary(number, left, m);
    }
    return null;
  }


  public String toString() {
    String foo = "debug\n";
    for (int i = 0; i < cardfield.length; i++) {
      foo += cardfield[i].getNumber() + " ";
    }
    return foo;
  }
}
