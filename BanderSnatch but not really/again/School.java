public class School extends Game{
    util util = new util();

    public School() {
        Etage k = new Etage(-2);
        Etage ug = new Etage(-1);
        Etage eg = new Etage(0);
        Etage og = new Etage(1);
    }
    

    public void stairsOptions() {
        switch(player.getLevel()) {
            case 1:     util.println("[1] Runter [2] Zurueck"); 
            case 0:     util.println("[1] Runter [2] Hoch [3] Zurueck"); 
            case -1:    util.println("[1] Runter [2] Hoch [3] Zurueck"); 
            case -2:    util.println("[1] Hoch [2] Zurueck"); 
        }
    }
    public void useStairs(String direction) {
        switch(direction) {
            case "up": player.addLevel(1);
            case "down": player.addLevel(-1);
        }
    }
}
