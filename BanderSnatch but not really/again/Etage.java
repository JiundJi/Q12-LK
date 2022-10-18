public class Etage {
    public Etage(int n) {
        switch(n) {
            case -1:Room artRoom = new Room("Kunst", -1);
                    Room musicRoom = new Room("Musik", -1);
            case 0: Room gerRoom = new Room("Deutsch", 0); 
                    Room ethRoom = new Room("Ethik", 0);
            case 1: Room bioRoom = new Room("Biologie", 1);
                    Room phyRoom = new Room("Physik", 1);
                    Room chemRoom = new Room("Chemie", 1);
        }
        
    }
}