public class Game {
    util util = new util();
    
    private int input = -1;
    private String stringInput = "null";
    Player player = new Player();
    School school = new School();

    public void menu() {
        do {
            util.println(" \n \n--------------------------------");
            util.println("| Willkommen bei JiundJi's RPG!");
            util.println("| [1] Starten [2] Anleitung");
            util.println("-------------------------------- \n");
            input = util.sc.nextInt();
            if (input == 1) {break;}
            else if (input == 2) {intro(); menu();}
        } while (input != 1 || input != 2);
    }

    public void intro() {
        util.println("--------------------------------");
        util.println("| [1] In den Garten (2)");
        util.println("|  ^        ^        ^");
        util.println("|  |        |        |");
        util.println("|  Auswahl  |        |");
        util.println("|  Beschreibung      |");
        util.println("|  Benoetigte Zeit --|");
        util.println("--------------------------------");
        util.wait(2000);
    }

    public void start() {
        do {
            status();
            action();
        } while (!player.isDead());
    }

    public void action() {

    }

    private void status() {
        util.println("\n\n\n");
        util.println("***************************************************");                                                 
        util.println("|| Du bist " + player.getLevelDesc() + ". Es ist momentan " + player.getTime() + " Uhr.");
        util.println("|| Du fuehlst dich " + player.fatigueCheck());
        if (player.getWooziness() > 0) {
            util.println("|| Du bist " + player.woozinessCheck());
        }
        util.println("|| [9] Deine Statistiken");
        util.println("***************************************************");      
    }

    public boolean stop() {
        util.println("Moechtest du nochmal spielen? (y/n)");
        stringInput = util.sc.nextLine();
        if (stringInput == "y" || stringInput == "Y") {return false;}
        else {return true;}
    }

    public void backrooms() {
        util.clear();
        System.out.println("."); util.wait(500); util.clear(); System.out.println(".."); util.wait(500); util.clear(); System.out.println("..."); util.wait(1000);
        System.out.println("$CORRUPT");
        util.wait(500);
        util.clear();
        System.out.println("CO R UPT T ED");
        System.out.println("ERR癖R");
        util.wait(500);
        System.out.println("癖癖癖癖癖癖癖");
        util.wait(500);
        util.clear();
        System.out.println("dU b癖ST IN B癖癖k癖癖O癖癖");
        System.out.println("癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖");
        System.out.println("SYSTEM C癖RRUPTED");
        for (int i = 0; i<101; i++) {
            System.out.println(i + "% 癖OA癖癖癖G 癖癖 癖癖癖癖癖癖癖癖癖癖癖");
            System.out.println("as癖g癖öl癖sd癖");
            System.out.println("癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖");
        }
        String m = util.sc.next();
        while (m != "cd ..") {
                System.out.println("W癖ITING FOR U癖ER INPUT");
                m = util.sc.next();
                util.wait(500);
        }
    }
}
