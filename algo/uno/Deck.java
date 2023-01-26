public class Deck {

  private Card cardfield[];

  public Deck(int count) {
    cardfield = new Card[count];
    for (int i=count-1; i>=0; i--) {
      cardfield[i] = new Card((int) (Math.random()*10));
    }
  }

  public void sort(){
    int upperLimit = cardfield.length - 1;
    int savedPosition = -1;
    Card savedCard = new Card(-1);

    for (int i = upperLimit; i >= 0; i--) {
      if (cardfield[i].getNumber() > savedCard.getNumber()) {
        savedCard = cardfield[i];
        savedPosition = i;
      }
    }
    cardfield[savedPosition] = cardfield[upperLimit];
    cardfield[upperLimit] = savedCard;


  }

  @Override
  public String toString(){
    String foo = "\n";
    for (int i=0; i<cardfield.length;i++){
      foo = foo + cardfield[i].getNumber() + " ";
    }
    return foo;
  }
}