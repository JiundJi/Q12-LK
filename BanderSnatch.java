import java.util.Scanner;
import java.util.concurrent.*;

public class BanderSnatch {
    public static int level = 0;
    public static int wooziness = 0;
    public static int hour = 7;
    public static int min = 0;
    public static int fatigue = 0;
    public static int day = 1;
    public static int hp = 100;
    public static int stress = 0;
    public static boolean hasMouse = false;
    public static boolean hasReadBook = false;
    public static boolean hasTouchedFox = false;

    public static Scanner sc = new Scanner(System.in); 
    public static void wait(int n) {
        try {
            TimeUnit.SECONDS.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void clear() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    public static void main(String[] args) {
        game();
    }

    public static void game() {
        while (true) {
            while (!schoolEnd()) {
                status();
                wait(1);
                actionsSchool();
            }
            while (!homeEnd()) {
                status();
                wait(1);
                actionsHome();
            }
        }
    }

    public static void status() {                                                                                       //! STATUS
        System.out.println("\n\n\n\n\n\n\n");
        System.out.println("****************************************");                                                 
        System.out.println("Du bist im " + levelCheck() + ". Es ist momentan " + time() + " Uhr.");
        System.out.println("Du fuehlst dich " + fatigueCheck());                                                  //! no checking needed
        if (wooziness > 0) {                                                                                            //! check if 0
            System.out.println("Du bist " + woozinessCheck());
        }
        System.out.println("****************************************");                                                   
    }

    public static void actionsSchool() {                                                                                //! ACTIONS AT SCHOOL
        int m;
        System.out.println("Was moechtest du tun?");
        System.out.println("____________________");
        if (level == 0) {
            System.out.println("[1] Treppenhaus (2)\n[2] In den Vorhof (2)\n[3] In den Deutschraum (2)\n[4] In den Ethikraum (2)\n[5] In die Bibliothek");
            System.out.println("____________________");
            m = sc.nextInt();
            if (m == 1) {                                                                                               //! [1]
                min = min + 2; 
                actionsTreppe(); 
                return;
                }
            else if (m == 2) {                                                                                          //! [2]
                min = min + 2;
                do {
                    double b = Math.random() * 101;
                    if (b <= 20) {
                        System.out.println("Du siehst einen Fuchsjunges mit einer Katze spielen!");
                        System.out.println("[1] Versuche sie zu streicheln\n[2] Schau von der Ferne zu");
                        m = sc.nextInt();
                        if (m == 1) {
                            min++;
                            System.out.println("Du naeherst dich langsam den Jungen. Der junge Kater schaut hoch zu dir als du dich neben ihm hinkniest.");
                            b = Math.random() * 101;
                            if (b < 10) {
                                System.out.println("Auf einmal hoerst du ein Knurren. Als du dich umdrehst, springt dir ein Fuchs ins Gesicht und zerkratzt dich mit ihren Krallen.");
                                hp = hp - 30;
                                fatigue = fatigue + 20;
                                System.out.println("Du schaffst es, den Fuchs abzuschuetteln und rennst zurueck ins Gebaeude.");
                                min++;
                            } else {
                                System.out.println("Der junge Kater drueckt seinen Kopf in deine Hand, waehrend du sein Fell streichelst.");
                                System.out.println("Du streichelst beide Jungtiere fuer eine Weile.");
                                if (stress != 0) {stress = stress - 25;}
                                if (wooziness != 0) {wooziness = wooziness - 10;}
                                min = min + 5;
                            }
                        }
                    } else {
                        System.out.println("Drauszen stehen ein paar Schueler rum. Es gibt nichts interessantes.");
                        System.out.println("[1] Wieder rein gehen");
                        m = sc.nextInt();
                    }
                } while (m != 1);
                return;
            }
            else if (m == 3) {                                                                                          //! [3]
                min = min + 2;
                if (hour < 11 || min == 30) {
                    System.out.println("Der Raum ist leer.");
                } else {
                    System.out.println("Der Raum ist voll mit Schuelern. Alle drehen sich zu dir um.");
                    System.out.println("[1] Hinsetzen\n[2] Rausgehen");
                    m = sc.nextInt();
                    if (m == 1) {
                        hour++; 
                        System.out.println("Du setzt dich hin und bleibst dort fuer den Rest der Stunde."); 
                        wait(2);
                        System.out.println("Die Schulklingel laeutet und alle verlassen den Raum.");
                        return;
                    }
                    else if (m == 2) {
                        return;
                    }
                }
            }
            else if (m == 4) {}
            else if (m == 5) {}
        }
        else if (level == 1) {
            System.out.println("[1] Treppenhaus\n[2] In den Biologieraum\n[3] In die Physiksammelung\n[4] In den Chemieraum");
            System.out.println("____________________");
            m = sc.nextInt();
            if (m == 1) {actionsTreppe();}
            else if(m == 2) {}
            else if(m == 3) {}
            else if(m == 4) {}
        }
        else if (level == -1) {
            System.out.println("[1] Treppenhaus (2)\n[2] In den Kunstraum (2)\n[3] In die Instrumentekammer (2)\n[4] Hinter die Bühne (2)");
            System.out.println("____________________");
            m = sc.nextInt();
            if (m == 1) {actionsTreppe();}
            else if(m == 2) {}
            else if(m == 3) {}
            else if(m == 4) {}
        }
        else if (level == -2) {
            System.out.println("[1] Treppenhaus\n[2] Den hellgrauen Kasten untersuchen\n[3] Die linke Tuer oeffnen\n[4] Weiter rein laufen");
            System.out.println("____________________");
            m = sc.nextInt();
            if (m == 1) {actionsTreppe();}
            else if(m == 2) {System.out.println("Das scheint der Stromkasten zu sein."); wait (1); return;}
            else if(m == 3) {
                System.out.println("Du oeffnest die Tuer. Der Raum dahinter scheint leer zu sein.");
                wait(1);
                System.out.println("Nach zwei Schritten zieht etwas unsichtbares an deinem Bein! Du versuchst dich loszuziehen, aber du wirst runtergezogen.");
                
                System.out.println("."); wait(1); clear(); System.out.println(".."); wait(1); clear(); System.out.println("...");
                System.out.println("Du bist in den Backrooms gelandet. Viel Glueck.");
            }
            else if(m == 4) {actionsDeepCellar();}
        }
    }
    
    public static void actionsHome() {                                                                                  //! ACTIONS AT HOME

    }

    public static void actionsDeepCellar() {                                                                            //! ACTIONS IN CELLAR
        int m;
        status();
        System.out.println("Was moechtest du tun?");
        System.out.println("____________________");
        System.out.println("[1] Zurueck\n[2] Die linke Tuer oeffnen\n[3] Die rechte Tuer oeffnen\n[4] Die Tuer vorne oeffnen");
            m = sc.nextInt();
            if (m == 1) {return;}
            else if(m == 2) {
                System.out.println("Diese Tuer ist verschlossen.");
                wait(1);
                actionsDeepCellar();
            }
            else if(m == 3) {
                System.out.println("Du findest einen groszen Lagerraum. Es stehen Sofas auf deiner linken Seite und ein Kasten voll mit Elektroschrott auf deiner rechten.");
                System.out.println("[1] Die Sofas untersuchen\n[2] Den Elektroschrott durchsuchen");
                m = sc.nextInt();
                if (m == 1) {
                    System.out.println("x");
                }
                else if (m == 2) {
                    double b = Math.random() * 101;
                    if (b < 10) {
                        System.out.println("Eine Spinne erschreckt dich so sehr, dass du rueckwaerts fliegst und deinen Kopf aufschlaegst.");
                        tod();
                    } else {
                        if (!hasMouse) {
                            System.out.println("Du findest eine funktionierende Maus und nimmst sie mit.");
                            hasMouse = true;
                            actionsDeepCellar();
                        } else {
                            System.out.println("Du hoerst ein Geraeusch und versteckst dich hinter der Kiste. Der Hausmeister schaut hinein: 'Ist da jemand?'");
                            System.out.println("[1] Dich bekannt geben\n[2] Weiter verstecken");
                            m = sc.nextInt();
                            if (m == 1) {
                                System.out.println("'Ich bin hier' sagst du. Er schaut dich an, das Licht seiner Taschenlampe nimmt dir die Sicht. \n'Es ist fuer Schueler verboten, in den Keller zu gehen.' sagt er. 'Du bleibst nach dem Unterricht und gehst Nachsitzen. Sei nicht zu spaet.'");
                                wait(2);
                                System.out.println("Du verlaesst den Keller.");
                                return;
                            }
                            else if (m == 2) {
                                System.out.println("Der Hausmeister scheint mit seiner Taschenlampe einmal durch den Raum. 'Ist wohl abgehauen' murmelt er und schlieszt die Tuer.");
                            }
                        }
                    }
                }
            }
            else if(m == 4) {  
                do {
                    System.out.println("Du findest einen Raum vollgestellt mit Bier.");
                    System.out.println("[1] Eins trinken\n[2] Ein paar trinken \n[3] Verlassen");
                    m = sc.nextInt();
                    if (m == 1) {
                        wooziness += Math.random() * 11 + 10;
                        stress -= Math.random() * 11 + 5;
                        hp--;
                    } else if (m == 2) {
                        wooziness += Math.random() * 11 + 30;
                        stress -= Math.random() * 11 + 10;
                        hp -= 5;
                    }
                } while (m != 3);
            }
    }

    public static void actionsTreppe() {                                                                                //! STAIRCASE
        int m;
        if (level == 0) {
            do {
                System.out.println("****************************************");
                System.out.println("[1] Einen Geschoss hoeher gehen \n[2] Einen Geschoss runter gehen ");
                System.out.println("****************************************");
                m = sc.nextInt();
                if (m == 1) {min++; level++; return;}
                else if (m == 2) {min++; level--; return;}
            } while (m != 1 || m != 2);
        }
        else if (level == 1) {
            do {
                System.out.println("****************************************");
                System.out.println("****************************************");
                System.out.println("[1] Einen Geschoss runter gehen");
                m = sc.nextInt();
                if (m == 1) {min++; level--; return;}
            } while (m != 1);
        }
        else if (level == -1) {
            do {
                System.out.println("****************************************");
                System.out.println("[1] Einen Geschoss hoeher gehen \n[2] Einen Geschoss runter gehen ");
                System.out.println("****************************************");
                m = sc.nextInt();
                if (m == 1) {min++; level++; return;}
                else if (m == 2) {min++; level--; return;}
            } while (m != 1 || m != 2);
        }
        else if (level == -2) {
            do {
                System.out.println("****************************************");
                System.out.println("****************************************");
                System.out.println("[1] Einen Geschoss hoeher gehen");
                m = sc.nextInt();
                if (m == 1) {min++; level++; return;}
            } while (m != 1);
        }
    }

    public static String fatigueCheck() {
        if (stress > 80) {
            fatigue += 20;
        }

        String fat = "";
        if (fatigue < 30) {
            fat = "aufgefrischt.";
        }
        else if (fatigue > 30) {
            fat = "wach.";
        }
        else if (fatigue > 50) {
            fat = "etwas angestrengt.";
        }
        else if (fatigue > 80) {
            fat = "muede.";
        }
        else if (fatigue >= 100) {
            tod();
        }
        return fat;
    }
    
    public static String woozinessCheck() {
        String fat = "";
        if (wooziness < 30) {
            fat = "waermer als sonst.";
            stress--;
        }
        else if (wooziness > 30) {
            fat = "etwas angetrunken.";
            stress -= 5;
        }
        else if (wooziness > 50) {
            fat = "ziemlich behaemmert.";
            stress -= 10;
        }
        else if (wooziness > 80) {
            fat = "sturzbesoffen.";
            stress -= 20;
        }
        else if (wooziness >= 100) {
            tod();
        }
        return fat;
    }

    public static String levelCheck() {
        String fat = "";

        if (level == -2) {
            fat = "Keller";
        }
        else if (level == -1) {
            fat = "Untergeschoss";
        }
        else if (level == 0) {
            fat = "Erdgeschoss";
        }
        else if (level == 1) {
            fat = "Obergeschoss";
        }
        return fat;
    }
    
    public static String time() {
        String t = "";
        if (min >= 60) {
            min = min - 60;
            hour++;
        }
        if (min < 10) {t = hour + ":0" + min;} else {t = hour + ":" + min;}
        return t;
    }
    
    public static boolean schoolEnd() {
        if (hour == 15) {
            System.out.println("Die Schule ist für heute vorbei, deswegen gehst du nach Hause."); 
            return true; 
        } else {
            return false;
        }
    }
    
    public static boolean homeEnd() {
        if (hour == 22) {
            day++; level = 0; wooziness = 0; hour = 7; min = 0; fatigue = 0;
            System.out.println("********************************************************************************");
            System.out.println("Es ist spät und du gehst schlafen.");
            System.out.println("Es ist früher Morgen und du begibst dich zur Schule.");
            System.out.println("********************************************************************************");
            return true; 
        } else {
            return false;
        }
    }

    public static void tod() {
        System.out.println("Du bist gestorben.");
        wait(2);
        System.out.println("Moechtest du nochmal spielen? \n[1] Ja [2] Nein \n___________________________");
        int m = sc.nextInt();
        if (m == 1) {
            level = 0;
            wooziness = 0;
            hour = 7;
            min = 0;
            fatigue = 0;
            day = 1;
            hp = 100;
            hasMouse = false;
            hasReadBook = false;
            hasTouchedFox = false;
            game();
        }
        if (m == 2) {System.exit(0);}
    }
}