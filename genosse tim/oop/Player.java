public class Player {
  private Raum currentRoom;
  
  private int hp;
  private int money;
  private int coins;
  private int inventar [] = {1, 2, 3, 4, 5, 6, 7, 8}; 
  private String currentId;
  private String currentName;
  private String currentBeschreibung;
  
  public Player(int hp, int money, int coins, Raum startRaum) {
    this.hp = hp;
    this.money = money;
    this.coins = coins;
    currentRoom = startRaum;
  }

  public void changeRoom(Raum raum) {
    currentRoom = raum;
  }
  
  public String getRoom() {
    currentId = currentRoom.getId();
    return currentId;
  }
  
  public String getName() {
    currentId = currentRoom.getName();
    return currentName;
  }
  
  public String getBeschreibung() {
    currentId = currentRoom.getBeschreibung();
    return this.currentBeschreibung;
  }
} 