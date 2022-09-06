public class BenderSnatch {
    int level = 0;                                                                                                      //! etage, nicht level
    int wooziness = 0;
    int hour = 7;
    int min = 0;
    int fatigue = 0;
    int day = 1;

    public static void main (String[] args) {
        while (true) {                                                                                                  //! es tut mir leid
            schoolEnd();
            status();
            actions(level);
        }
    }
    public void status() {
        System.out.println("****************************************");                                                 //* status start
        System.out.println("Du bist im " + levelCheck(level) + ". Es ist momentan " + time(); + " Uhr.");
        System.out.println("Du fühlst dich " + fatigueCheck(fatigue));                                                  //! no checking needed
        if (wooziness > 0) {                                                                                            //! check if 0
            System.out.println("Du bist " + woozinessCheck(wooziness));
        }
        System.out.println("****************************************");                                                 //* status end    
    }

    public void actions(int etage) {
        int m;
        System.out.println("Was möchtest du tun?");
        System.out.println("____________________");
        if (etage == 0) {
            System.out.println("[1] Ins Treppenhaus (2) \n
                                [2] In den Vorhof (3)   \n
                                [3] In den Deutschraum (1)");
            m = InOut.readInt();
            if (m == 1) {
                min = min + 2; 
                actionsTreppe(); 
                return;
                }
            else if (m == 2) {
                min = min + 3;
                do {
                    System.out.println("Drauszen stehen ein paar Schueler rum. Es gibt nichts interessantes.");
                    System.out.println("[1] Wieder rein gehen");
                    m = InOut.readInt();
                } while (m != 1)
                return;
            }
            else if (m == 3) {

                if (hour == 11) {
                    System.out.println("Der Raum ist leer.");
                } else {
                    System.out.println("Der Raum ist voll mit Schuelern. Alle drehen sich zu dir um.");
                    System.out.println("[1] Hinsetzen   \n
                                        [2] Rausgehen");
                    m = InOut.readInt();
                    if (m == 1) {hour++; System.out.println("Du setzt dich hin und bleibst dort fuer den Rest der Stunde. \n Die Schulklingel laeutet und alle verlassen den Raum."); return;}
                    else if (m == 2) {return;}
                }
            }
        }
        else if (etage == 1) {
            if (1 == InOut.readInt("[1] Einen Geschoss runter gehen")) {level--;}
            if (2 == InOut.readInt("[2] In den Vorhof")) {}
            if (3 == InOut.readInt("[3] In den Deutschraum")) {}
        }
        else if (etage == -1) {
            if (1 == InOut.readInt("[1] Ins Treppenhaus")) {actionsTreppe(); return;}
            if (2 == InOut.readInt("[2] In den Vorhof")) {}
            if (3 == InOut.readInt("[3] In den Deutschraum")) {}
        }
        else if (etage == -2) {
            if (1 == InOut.readInt("[1] Einen Geschoss hoeher gehen")) {level++;}
            if (2 == InOut.readInt("[2] In den Vorhof")) {}
            if (3 == InOut.readInt("[3] In den Deutschraum")) {}
        }
    }

    public void actionsTreppe () {
        System.out.println("****************************************");
        System.out.println("[1] Einen Geschoss hoeher gehen \n
                            [2] Einen Geschoss runter gehen ");
        System.out.println("****************************************");
        if (1 == InOut.readInt()) {level++; return;}
        else if (2 == InOut.readInt()) {level--; return;}
    }

    public String fatigueCheck (int n) {
        String fat;
        if (n < 30) {
            fat = "aufgefrischt."
        }
        else if (n > 30) {
            fat = "wach.";
        }
        else if (n > 50) {
            fat = "etwas angestrengt.";
        }
        else if (n > 80) {
            fat = "muede."
        }
        else if (n >= 100) {
            tod();
        }
        return fat;
    }
    public String woozinessCheck (int n) {
        String fat;
        if (n < 30) {
            fat = "etwas wärmer als sonst."
        }
        else if (n > 30) {
            fat = "etwas angetrunken.";
        }
        else if (n > 50) {
            fat = "ziemlich behaemmert.";
        }
        else if (n > 80) {
            fat = "sturzbesoffen."
        }
        else if (n >= 100) {
            tod();
        }
        return fat;
    }
    public String levelCheck (int n) {
        String fat;

        if (n == -2) {
            fat = "geheimen Keller";
        }
        else if (n == -1) {
            fat = "Untergeschoss";
        }
        else if (n == 0) {
            fat = "Erdgeschoss";
        }
        else if (n == 1) {
            fat = "Obergeschoss";
        }
        return fat;
    }
    public String time () {
        if (min >= 60) {
            min = min - 60;
            hour++;
        }
        String t = hour + ":" + min;
        return t;
    }
    public void schoolEnd () {
        if (hour == 15) {
            day++; level = 0; wooziness = 0; hour = 7; min = 0; fatigue = 0;
            System.out.println("Die Schule ist für heute vorbei, deswegen gehst du nach Hause."); 
            System.out.flush(); 
            System.out.println("Es ist früher Morgen und du begibst dich zur Schule.");
            return; 
        } else {
            return;
        }
    }
}