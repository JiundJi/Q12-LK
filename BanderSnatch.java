import java.util.Scanner;

public class BanderSnatch {
    public static int level = 0;                                                                                                      //! etage, nicht level
    public static int wooziness = 0;
    public static int hour = 7;
    public static int min = 0;
    public static int fatigue = 0;
    public static int day = 1;
    public static Scanner sc = new Scanner(System.in); 

    public static void main (String[] args) {
        while (true) {                                                                                                  //! es tut mir leid
            schoolEnd();
            status();
            actions(level);
        }
    }
    public static void status() {
        System.out.println("****************************************");                                                 
        System.out.println("Du bist im " + levelCheck(level) + ". Es ist momentan " + time() + " Uhr.");
        System.out.println("Du fuehlst dich " + fatigueCheck(fatigue));                                                  //! no checking needed
        if (wooziness > 0) {                                                                                            //! check if 0
            System.out.println("Du bist " + woozinessCheck(wooziness));
        }
        System.out.println("****************************************");                                                   
    }

    public static void actions(int etage) {
        int m;
        System.out.println("Was moechtest du tun?");
        System.out.println("____________________");
        if (etage == 0) {
            System.out.println("[1] Ins Treppenhaus (2)\n[2] In den Vorhof (3)\n[3] In den Deutschraum (1)");
            m = sc.nextInt();
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
                    m = sc.nextInt();
                } while (m != 1);
                return;
            }
            else if (m == 3) {

                if (hour == 11) {
                    System.out.println("Der Raum ist leer.");
                } else {
                    System.out.println("Der Raum ist voll mit Schuelern. Alle drehen sich zu dir um.");
                    System.out.println("[1] Hinsetzen\n[2] Rausgehen");
                    m = sc.nextInt();
                    if (m == 1) {
                        hour++; 
                        System.out.println("Du setzt dich hin und bleibst dort fuer den Rest der Stunde."); 
                        System.out.println("Die Schulklingel laeutet und alle verlassen den Raum.");
                        return;
                    }
                    else if (m == 2) {return;}
                }
            }
        }
        else if (etage == 1) {
            System.out.println("[1] Einen Geschoss runter gehen \n [2] In den Vorhof \n [3] In den Deutschraum");
            if (1 == sc.nextInt()) {}
            if (2 == sc.nextInt()) {}
            if (3 == sc.nextInt()) {}
        }
        else if (etage == -1) {
            System.out.println("[1] Ins Treppenhaus \n [2] In den Vorhof \n [3] In den Deutschraum");
            if (1 == sc.nextInt()) {actionsTreppe(); return;}
            if (2 == sc.nextInt()) {}
            if (3 == sc.nextInt()) {}
        }
        else if (etage == -2) {
            System.out.println("[1] Einen Geschoss hoeher gehen \n [2] In den Vorhof \n [3] In den Deutschraum");
            if (1 == sc.nextInt()) {}
            if (2 == sc.nextInt()) {}
            if (3 == sc.nextInt()) {}
        }
    }
    public static void actionsTreppe () {
        System.out.println("****************************************");
        System.out.println("[1] Einen Geschoss hoeher gehen \n [2] Einen Geschoss runter gehen ");
        System.out.println("****************************************");
        if (1 == sc.nextInt()) {level++; return;}
        else if (2 == sc.nextInt()) {level--; return;}
    }

    public static String fatigueCheck (int n) {
        String fat = "";
        if (n < 30) {
            fat = "aufgefrischt.";
        }
        else if (n > 30) {
            fat = "wach.";
        }
        else if (n > 50) {
            fat = "etwas angestrengt.";
        }
        else if (n > 80) {
            fat = "muede.";
        }
        else if (n >= 100) {
            tod();
        }
        return fat;
    }
    public static String woozinessCheck (int n) {
        String fat = "";
        if (n < 30) {
            fat = "etwas wärmer als sonst.";
        }
        else if (n > 30) {
            fat = "etwas angetrunken.";
        }
        else if (n > 50) {
            fat = "ziemlich behaemmert.";
        }
        else if (n > 80) {
            fat = "sturzbesoffen.";
        }
        else if (n >= 100) {
            tod();
        }
        return fat;
    }
    public static String levelCheck (int n) {
        String fat = "";

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
    
    public static String time () {
        String t = "";
        if (min >= 60) {
            min = min - 60;
            hour++;
        }
        if (min < 10) {t = hour + ":0" + min;} else {t = hour + ":" + min;}
        return t;
    }
    public static void schoolEnd () {
        if (hour == 15) {
            day++; level = 0; wooziness = 0; hour = 7; min = 0; fatigue = 0;
            System.out.println("Die Schule ist für heute vorbei, deswegen gehst du nach Hause."); 
            System.out.println("Es ist früher Morgen und du begibst dich zur Schule.");
            return; 
        } else {
            return;
        }
    }
    public static void tod() {
        System.out.println("Du bist gestorben.");
    }
}