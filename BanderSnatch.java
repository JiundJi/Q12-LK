import java.util.Scanner;
import java.util.concurrent.*;

public class BanderSnatch {
    public static String level = "eg";
    public static int wooziness = 0;
    public static int hour = 7;
    public static int min = 0;
    public static int fatigue = 0;
    public static int day = 1;
    public static int hp = 100;
    public static int stress = 0;
    public static int bladder = 0;
    public static int philosophy = 0;
    public static int acting = 0;
    public static int math = 0;
    public static int ger = 0;
    public static int eng = 0;
    public static int biology = 0;
    public static int physics = 0;
    public static String [][] book = new String[1][4];
    public static int [] pick = new int[4]; //3 picked books
    public static int bookID = 0; // bookID of the last book
    public static String bookOpt = ""; // for output
    public static boolean hasMouse = false;
    public static boolean hasGivenTeacher = false;
    public static boolean hasReadBook = false;
    public static boolean hasToldTeacher = false;
    public static boolean hasPattedFox = false;

    public static Scanner sc = new Scanner(System.in); 
    public static void wait(int n) {
        try {
            TimeUnit.MILLISECONDS.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void resetStats() {
        level = "eg";
        wooziness = 0;
        hour = 7;
        min = 0;
        fatigue = 0;
        day = 1;
        hp = 100;
        stress = 0;
        bladder = 0;
        hasMouse = false;
        hasReadBook = false;
        hasPattedFox = false;
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
                wait(200);
                actionsSchool();
            }
            while (!homeEnd()) {
                status();
                wait(200);
                actionsHome();
            }
        }
    }

    public static void status() {                                                                                       //! STATUS
        System.out.println("\n\n\n");
        woozinessCheck();
        fatigueCheck();
        System.out.println("***************************************************");                                                 
        System.out.println("|| Du bist " + levelCheck() + ". Es ist momentan " + time() + " Uhr.");
        System.out.println("|| Du fuehlst dich " + fatigueCheck());                                                  //! no checking needed
        if (wooziness > 0) {                                                                                            //! check if 0
            System.out.println("|| Du bist " + woozinessCheck());
        }
        System.out.println("***************************************************");                                                   
    }

    public static void statCheck() {
        System.out.println("HP: " + hp);
        System.out.println("Deutschkenntnisse: " + ger);
        System.out.println("Englischkenntnisse: " + eng);
        System.out.println("Biologiekenntnisse: " + biology);
        System.out.println("Physikkenntnisse: " + physics);
        System.out.println("Kenntnisse in Philosophie: " + philosophy);
        System.out.println("Kenntnisse in Darstellendes Spiel: " + acting);
        System.out.println("Du bist zu " + stress + "% gestresst.");
        if (hasMouse) {
            System.out.println("Du hast eine Maus.");
        }
    }

    public static void actionsSchool() {                                                                                //! ACTIONS AT SCHOOL
        int m;
        System.out.println("Was moechtest du tun?");
        System.out.println("____________________");
        if (level == "eg") {
            System.out.println("[1] Treppenhaus (2)\n[2] In den Vorhof (2)\n[3] In den Deutschraum (2)\n[4] In den Ethikraum (2)\n[5] In die Bibliothek (2)\n[9] Deine Statistiken");
            System.out.println("--------------------");
            m = sc.nextInt();
            System.out.println("--------------------");
            if (m == 1) {                                                                                               //! [1]
                min += 2; 
                actionsTreppe(); 
                return;
                }
            else if (m == 2) {                                                                                          //! [2]
                min = min + 2;
                do {
                    double b = Math.random() * 101;
                    if (b <= 20) {
                        System.out.println("Du siehst einen Fuchsjunges mit einer Katze spielen!");
                        System.out.println("____________________");
                        System.out.println("[1] Versuche sie zu streicheln\n[2] Schau von der Ferne zu");
                        System.out.println("--------------------");
                        m = sc.nextInt();
                        System.out.println("--------------------");
                        if (m == 1) {
                            min++;
                            System.out.println("Du naeherst dich langsam den Jungen. Der junge Kater schaut hoch zu dir als du dich neben ihm hinkniest.");
                            b = Math.random() * 101;
                            if (b < 10) {
                                System.out.println("Auf einmal hoerst du ein Knurren. Als du dich umdrehst, springt dir ein Fuchs ins Gesicht und zerkratzt dich mit ihren Krallen.");
                                hp -= 30;
                                fatigue += 20;
                                System.out.println("Du schaffst es, den Fuchs abzuschuetteln und rennst zurueck ins Gebaeude.");
                                min++;
                            } else {
                                System.out.println("Der junge Kater drueckt seinen Kopf in deine Hand, waehrend du sein Fell streichelst.");
                                System.out.println("Du streichelst beide Jungtiere fuer eine Weile.");
                                stress -= 25;
                                wooziness -=10;
                                min += 5;
                            }
                        }
                        else if (m == 2) {
                            System.out.println("Du siehst zu wie die zwei Jungtiere spielen.");
                            fatigue -= 15;
                            stress -= 15;
                            hp += 10;
                        }
                    wait(2500);
                    } else {
                        System.out.println("Drauszen stehen ein paar Schueler rum. Es gibt nichts interessantes.");
                        System.out.println("____________________");
                        System.out.println("[1] Wieder rein gehen");
                        System.out.println("--------------------");
                        m = sc.nextInt();
                        System.out.println("--------------------");
                    }
                } while (m != 1);
                return;
            }
            else if (m == 3) {                                                                                          //! [3]
                min = min + 2;
                if (hour == 11 && min <= 35 || min >= 15) {
                    System.out.println("Der Raum ist voll mit Schuelern. Alle drehen sich zu dir um.");
                    System.out.println("____________________");
                    System.out.println("[1] Hinsetzen\n[2] Rausgehen");
                    System.out.println("--------------------");
                    m = sc.nextInt();
                    if (m == 1) {
                        hour++; 
                        System.out.println("Du setzt dich hin und bleibst dort fuer den Rest der Stunde."); 
                        wait(1000);
                        System.out.println("Die Schulklingel laeutet und alle verlassen den Raum.");
                        hour = 13;
                        min = 5;
                        return;
                    }
                    else if (m == 2) {
                        return;
                    }
                } else {
                    System.out.println("Der Raum ist leer.");
                }
            }
            else if (m == 4) {                                                                                          //! [4]
                if (hour == 7 && min <= 55) {
                        System.out.println("Schueler setzen sich hin bevor die Stunde anfaengt.");
                        System.out.println("____________________");
                        System.out.println("[1] Hinsetzen\n[2] Raum verlassen");
                        System.out.println("--------------------");
                        m = sc.nextInt();
                        System.out.println("--------------------");
                        if (m == 1) {
                            System.out.println("Du setzt dich hin und bleibst dort fuer den Rest der Stunde.");
                            wait(1000);
                            System.out.println("Die Schulklingel laeutet und alle verlassen den Raum.");
                            hour = 9;
                            min = 25;
                        }
                    }
                }
            else if (m == 5) {level = "bb"; min += 2;}                                                                  //! [5]
            else if (m == 9) {statCheck();}                                                                             //! [9]
        }
        else if (level == "og") {
            System.out.println("[1] Treppenhaus\n[2] In den Biologieraum\n[3] In die Physiksammelung\n[4] In den Chemieraum\n[9] Deine Statistiken");
            System.out.println("--------------------");
            m = sc.nextInt();
            System.out.println("--------------------");
            if (m == 1) {actionsTreppe();}
            else if(m == 2) {
                min = min + 2;
                if (hour == 11 && min <= 35 || min >= 15) {
                    System.out.println("Der Raum ist voll mit Schuelern. Alle drehen sich zu dir um.");
                    System.out.println("____________________");
                    System.out.println("[1] Hinsetzen\n[2] Rausgehen");
                    System.out.println("--------------------");
                    m = sc.nextInt();
                    if (m == 1) {
                        hour++; 
                        System.out.println("Du setzt dich hin und bleibst dort fuer den Rest der Stunde."); 
                        wait(1000);
                        System.out.println("Die Schulklingel laeutet und alle verlassen den Raum.");
                        hour = 13;
                        min = 5;
                        return;
                    }
                    else if (m == 2) {
                        return;
                    }
                } else {
                    System.out.println("Der Raum ist leer.");
                }
            }
            else if(m == 3) {
                min = min + 2;
                if (hour == 9 && min <= 25) {
                    System.out.println("Der Raum ist voll mit Schuelern. Alle drehen sich zu dir um.");
                    System.out.println("____________________");
                    System.out.println("[1] Hinsetzen\n[2] Rausgehen");
                    System.out.println("--------------------");
                    m = sc.nextInt();
                    if (m == 1) {
                        hour++; 
                        System.out.println("Du setzt dich hin und bleibst dort fuer den Rest der Stunde."); 
                        wait(1000);
                        System.out.println("Die Schulklingel laeutet und alle verlassen den Raum.");
                        hour = 11;
                        min = 15;
                        return;
                    }
                    else if (m == 2) {
                        return;
                    }
                } else {
                    System.out.println("Der Raum ist leer.");
                }
            }
            else if(m == 4) {
                min = min + 2;
                if (hour == 11 && min <= 35 || min >= 15) {
                    System.out.println("Der Raum ist voll mit Schuelern. Alle drehen sich zu dir um.");
                    System.out.println("____________________");
                    System.out.println("[1] Hinsetzen\n[2] Rausgehen");
                    System.out.println("--------------------");
                    m = sc.nextInt();
                    if (m == 1) {
                        hour++; 
                        System.out.println("Du setzt dich hin und bleibst dort fuer den Rest der Stunde."); 
                        wait(1000);
                        System.out.println("Die Schulklingel laeutet und alle verlassen den Raum.");
                        hour = 13;
                        min = 5;
                        return;
                    }
                    else if (m == 2) {
                        return;
                    }
                } else {
                    System.out.println("Der Raum ist leer.");
                }
            }
            else if (m == 9) {statCheck();} 
        }
        else if (level == "ug") {
            System.out.println("[1] Treppenhaus (2)\n[2] In den Kunstraum (2)\n[3] In die Instrumentekammer (2)\n[4] Hinter die Bühne (2)\n[9] Deine Statistiken");
            System.out.println("--------------------");
            m = sc.nextInt();
            System.out.println("--------------------");
            if (m == 1) {actionsTreppe();}
            else if(m == 2) {}
            else if(m == 3) {}
            else if(m == 4) {
                if (hasToldTeacher) {
                    System.out.println("Die Theater-AG ist im Raum.");
                    do {
                        System.out.println("____________________");
                        System.out.println("[1] Zurueck");
                        System.out.println("--------------------");
                        m = sc.nextInt();
                        System.out.println("--------------------");    
                    } while(m != 1);
                    return;
                } else {
                    System.out.println("Ein Lehrer steht im Raum.");
                    System.out.println("'Sein oder nicht sein? Nicht sein oder sein?'");
                    if (hasReadBook) {
                        System.out.println("Du erzaehlst dem Lehrer was du im Buch gelesen hast.");
                        hasReadBook = false;
                        System.out.println("");
                    }
                    else {
                        do {
                        System.out.println("____________________");
                        System.out.println("[1] Zurueck");
                        System.out.println("--------------------");
                        m = sc.nextInt();
                        System.out.println("--------------------");    
                        } while(m != 1);
                        return;
                    }    
                }
            }
            else if (m == 9) {statCheck();} 
        }
        else if (level == "k") {
            System.out.println("[1] Treppenhaus\n[2] Den hellgrauen Kasten untersuchen\n[3] Die linke Tuer oeffnen\n[4] Weiter rein laufen\n[9] Deine Statistiken");
            System.out.println("--------------------");
            m = sc.nextInt();
            System.out.println("--------------------");
            if (m == 1) {actionsTreppe();}
            else if(m == 2) {System.out.println("Das scheint der Stromkasten zu sein."); wait (1000); return;}
            else if(m == 3) {                                                                                           //! BACKROOMS
                System.out.println("Du oeffnest die Tuer. Der Raum dahinter scheint leer zu sein.");
                wait(1000);
                System.out.println("Nach zwei Schritten zieht etwas unsichtbares an deinem Bein! Du versuchst dich loszuziehen, aber du wirst runtergezogen.");
                wait(2000);
                backrooms();
            }
            else if(m == 4) {actionsDeepCellar();}
            else if (m == 9) {statCheck();} 
        }
        else if (level == "bb") {
            System.out.println("[1] Etwas lesen\n[2] Tiefer in die Bibliothek gehen\n[3] Zuereck\n[9] Deine Statistiken");
            System.out.println("--------------------");
            m = sc.nextInt();
            System.out.println("--------------------");
            if (m == 1) {
                min++;
                System.out.println("Du gehst zu den Buecherregalen.");
                System.out.println(randomBook());
                m = sc.nextInt();
                bookReward(m);
            }
            else if (m == 2) {
                System.out.println("Du findest einen Computer und eine Tuer.");
                System.out.println("____________________");
                do{
                    System.out.println("[1] Zum Computer (1)\n[2] Zur Tuer (1) \n [3] Zurueck");
                    System.out.println("--------------------");
                    m = sc.nextInt();
                    System.out.println("--------------------");
                    if (m == 1) {
                        backrooms();
                    }
                    else if (m == 2) {
                        System.out.println("Du findest eine Treppe.");
                        System.out.println("____________________");
                        System.out.println("[1] Treppe runter\n[2] Zurueck");
                        System.out.println("--------------------");
                        m = sc.nextInt();
                        System.out.println("--------------------");
                        if (m == 1) {
                            level = "k";
                            break;
                        }
                        else if (m == 2) {
                            break;
                        }
                    }    
                    else if (m == 3) {
                        break;
                    }
                } while (m != 1 || m != 2 || m != 3);
                
            }
            else if (m == 3) {
                level = "eg";
            }
            else if (m == 9) {statCheck();} 
        }
    }

    public static void bookReward(int n) {
        for (int i = 1; i<4; i++) {
            if (n == i) {
                bookID = pick[n];
            }
        }
            if (bookID == 0) {stress -= 5; fatigue++; ger += 10; philosophy += 25;}
            else if (bookID == 1) {stress -= 5; fatigue++; ger += 25;}
            else if (bookID == 2) {stress -= 20; fatigue -= 10; hp = 100;}
            else if (bookID == 3) {stress += 5; fatigue++; ger += 10; biology += 25;}
            else if (bookID == 4) {stress += 5; fatigue++; ger += 10; physics += 25;}
            else if (bookID == 5) {stress += 5; fatigue++; ger += 5; math += 10;}
            else if (bookID == 6) {stress ++; fatigue++; ger += 20; philosophy += 30;}
            else if (bookID == 7) {stress -= 10; fatigue++; ger += 10; acting += 20; hasReadBook = true;}
            else if (bookID == 8) {stress++; fatigue++; ger += 20; philosophy += 20;}
            else if (bookID == 9) {stress++; fatigue++; ger += 5; philosophy += 5;}
            else if (bookID == 10) {stress -= 10; fatigue++; ger += 10; acting += 10;}
            else if (bookID == 11) {stress -= 10; fatigue++; ger += 10; philosophy += 10;}
            else if (bookID == 12) {stress -= 5; fatigue++; ger += 15; philosophy += 10;}
            else if (bookID == 13) {stress -= 20; fatigue++;}
            else if (bookID == 14) {stress -= 20; fatigue -= 10;}
            else if (bookID == 15) {stress += 5; fatigue++; ger += 5; math += 20;}
            else if (bookID == 16) {stress++; fatigue++; eng += 25;}
            else if (bookID == 17) {stress++; fatigue++; eng += 25;}
            else if (bookID == 18) {stress++; fatigue++; eng += 25;}
            else if (bookID == 19) {stress++; fatigue++; eng += 25;}
    }

    public static String randomBook() {
        bookOpt = "";
        double rndm = 0;
        for (int i = 1; i<4; i++) {
            do {
                rndm = Math.random() * 20;
            } while((int) rndm == pick[1] || (int) rndm == pick[2]);
            pick[i] = (int) rndm;

            System.out.println("[" + i + "] " + bookName[(int) rndm]);
        }
        return bookOpt;
    }

    public static void actionsHome() {                                                                                  //! ACTIONS AT HOME

    }

    public static void actionsDeepCellar() {                                                                            //! ACTIONS IN CELLAR
        int m;
        status();
        System.out.println("Was moechtest du tun?");
        System.out.println("____________________");
        System.out.println("[1] Zurueck\n[2] Die linke Tuer oeffnen\n[3] Die rechte Tuer oeffnen\n[4] Die Tuer vorne oeffnen");
        System.out.println("--------------------");
        m = sc.nextInt();
        System.out.println("--------------------");
        if (m == 1) {return;}
        else if(m == 2) {
            System.out.println("Diese Tuer ist verschlossen.");
            wait(500);
            actionsDeepCellar();
        }
        else if(m == 3) {
            System.out.println("Du findest einen groszen Lagerraum. Es stehen Sofas auf deiner linken Seite und ein Kasten voll mit Elektroschrott auf deiner rechten.");
            System.out.println("____________________");
            System.out.println("[1] Die Sofas untersuchen\n[2] Den Elektroschrott durchsuchen");
            System.out.println("--------------------");
            m = sc.nextInt();
            System.out.println("--------------------");
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
                        System.out.println("____________________");
                        System.out.println("[1] Dich bekannt geben\n[2] Weiter verstecken");
                        System.out.println("--------------------");
                        m = sc.nextInt();
                        System.out.println("--------------------");
                        if (m == 1) {
                            System.out.println("'Ich bin hier' sagst du. Er schaut dich an, das Licht seiner Taschenlampe nimmt dir die Sicht. \n'Es ist fuer Schueler verboten, in den Keller zu gehen.' sagt er. 'Du bleibst nach dem Unterricht und gehst Nachsitzen. Sei nicht zu spaet.'");
                            wait(2000);
                            System.out.println("Du verlaesst den Keller.");
                            return;
                        }
                        else if (m == 2) {
                            System.out.println("Der Hausmeister scheint mit seiner Taschenlampe einmal durch den Raum. 'Hab ich mir wohl eingebildet' murmelt er und schlieszt die Tuer.");
                        }
                    }
                }
            }
        }
        else if(m == 4) {  
            do {
                woozinessCheck();
                fatigueCheck();
                System.out.println("Du findest einen Raum vollgestellt mit Bier.");
                System.out.println("____________________");
                System.out.println("[1] Eins trinken\n[2] Ein paar trinken \n[3] Verlassen");
                System.out.println("--------------------");
                m = sc.nextInt();
                System.out.println("--------------------");
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
        if (level == "eg") {
            do {
                System.out.println("***********************************");
                System.out.println("* [1] Einen Geschoss hoeher gehen *\n* [2] Einen Geschoss runter gehen *");
                System.out.println("***********************************");
                m = sc.nextInt();
                if (m == 1) {min++; level = "og"; return;}
                else if (m == 2) {min++; level = "ug"; return;}
            } while (m != 1 || m != 2);
        }
        else if (level == "og") {
            do {
                System.out.println("****************************************");
                System.out.println("[1] Einen Geschoss runter gehen");
                System.out.println("****************************************");
                m = sc.nextInt();
                if (m == 1) {min++; level = "eg"; return;}
            } while (m != 1);
        }
        else if (level == "ug") {
            do {
                System.out.println("****************************************");
                System.out.println("[1] Einen Geschoss hoeher gehen \n[2] Einen Geschoss runter gehen ");
                System.out.println("****************************************");
                m = sc.nextInt();
                if (m == 1) {min++; level = "eg"; return;}
                else if (m == 2) {min++; level = "k"; return;}
            } while (m != 1 || m != 2);
        }
        else if (level == "k") {
            do {
                System.out.println("****************************************");
                System.out.println("[1] Einen Geschoss hoeher gehen");
                System.out.println("****************************************");
                m = sc.nextInt();
                if (m == 1) {min++; level = "ug"; return;}
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
            bladder++;
        }
        else if (wooziness >= 30 && wooziness < 50) {
            fat = "etwas angetrunken.";
            stress -= 5;
            bladder += 2;
        }
        else if (wooziness >= 50 && wooziness < 80) {
            fat = "ziemlich behaemmert.";
            stress -= 10;
            bladder += 3;
        }
        else if (wooziness >= 80  && wooziness < 100) {
            fat = "sturzbesoffen.";
            stress -= 20;
            bladder += 4;
            double b = Math.random() * 101;
            if (b <= 20) {
                int d = day;
                resetStats();
                hp = 50;
                System.out.println("Dir wird schwarz vor Augen.");
                wait(2000);
                day = d + 1;
                clear();
                System.out.println("Es ist ein Tag vergangen.");
                hour = 17;
            }
        }
        else if (wooziness >= 100) {
            tod();
        }
        return fat;
    }

    public static String levelCheck() {
        String fat = "";

        if (level == "k") {
            fat = "im Keller";
        }
        else if (level == "ug") {
            fat = "im Untergeschoss";
        }
        else if (level == "eg") {
            fat = "im Erdgeschoss";
        }
        else if (level == "og") {
            fat = "im Obergeschoss";
        }
        else if (level == "bb") {
            fat = "in der Bibliothek";
        }
        else if (level == "wc") {
            fat = "auf der Toilette";
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
        if (hour == 17 && min == 15) {
            System.out.println("Die Schule ist für heute vorbei, deswegen gehst du nach Hause."); 
            return true; 
        } else {
            return false;
        }
    }
    
    public static boolean homeEnd() {
        if (hour == 22) {
            day++; level = "eg"; wooziness = 0; hour = 7; min = 0; fatigue = 0;
            System.out.println("********************************************************************************");
            System.out.println("Es ist sp癖t und du gehst schlafen.");
            System.out.println("Es ist früher Morgen und du begibst dich zur Schule.");
            System.out.println("********************************************************************************");
            return true; 
        } else {
            return false;
        }
    }

    public static void tod() {
        System.out.println("Du bist gestorben.");
        wait(2000);
        System.out.println("Moechtest du nochmal spielen? \n[1] Ja [2] Nein \n___________________________");
        int m = sc.nextInt();
        if (m == 1) {
            resetStats();
            game();
        }
        if (m == 2) {System.exit(0);}
    }

    public static void backrooms() {
        clear();
        System.out.println("."); wait(500); clear(); System.out.println(".."); wait(500); clear(); System.out.println("..."); wait(1000);
        System.out.println("$CORRUPT");
        wait(500);
        clear();
        System.out.println("CO R UPT T ED");
        System.out.println("ERR癖R");
        wait(500);
        System.out.println("癖癖癖癖癖癖癖");
        wait(500);
        clear();
        System.out.println("dU b癖ST IN B癖癖k癖癖O癖癖");
        System.out.println("癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖");
        System.out.println("SYSTEM C癖RRUPTED");
        for (int i = 0; i<101; i++) {
            System.out.println(i + "% 癖OA癖癖癖G 癖癖 癖癖癖癖癖癖癖癖癖癖癖");
            System.out.println("as癖g癖öl癖sd癖");
            System.out.println("癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖癖");
        }
        String m = sc.next();
        while (m != "cd ..") {
                System.out.println("W癖ITING FOR U癖ER INPUT");
                m = sc.next();
                wait(500);
        }
    }

    public static String bookName[] = {
    /*0 */    "Sofies Welt",
    /*1 */    "Das Grosze Woerterbuch der deutschen Sprache",
    /*2 */    "Die Kaenguru Chroniken",
    /*3 */    "Lexikon der Biologie",
    /*4 */    "Ups and Downs - Einfuehrung in Quantenphysik",
    /*5 */    "Algebra 1",
    /*6 */    "Kritik der reinen Vernunft",
    /*7 */    "Was ist sein? Was ist nicht sein?",
    /*8 */    "Gott ist tot",
    /*9 */    "Die Bibel",
    /*10 */    "Romeo und Julia",
    /*11 */    "Emile oder ueber die Erziehung",
    /*12 */    "Also sprach Zarathustra",
    /*13 */    "Das grosze Buch der Witze",
    /*14 */    "Nichts, rein gar nichts: Das Buch fuer alle, die sich nichts wuenschen",
    /*15 */    "Algebra 2",
    /*16 */    "Faith and Misery",
    /*17 */    "With the lights out, its less dangerous",
    /*18 */    "Leave it alone, Find a home, Go back home",
    /*19 */    "I did it my way"
    };
}
