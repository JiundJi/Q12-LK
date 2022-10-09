import java.util.Scanner;
import java.util.concurrent.*;

public class BanderSnatch {
    public Stats currentPlayer;
    public Books books;
    public String [][] book = new String[1][4];
    public int [] pick = new int[4]; //3 picked books
    public int bookID = 0; // bookID of the last book
    public String bookOpt = ""; // for output
    

    public Scanner sc = new Scanner(System.in); 
    private void wait(int n) {
        try {
            TimeUnit.MILLISECONDS.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void clear() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    public void main(String[] args) {
        game();
    }

    public void game() {

        System.out.println("");

        while (true) {
            while (!schoolEnd()) {
                status();
                wait(200);
                actionsSchool();
            }
            while (!homeEnd()) {
                status();
                wait(200);
                
            }
        }
    }

    public void status() {                                                                                       //! STATUS
        System.out.println("\n\n\n");
        woozinessCheck();
        fatigueCheck();
        System.out.println("***************************************************");                                                 
        System.out.println("|| Du bist " + levelCheck(currentPlayer.getLevel()) + ". Es ist momentan " + time() + " Uhr.");
        System.out.println("|| Du fuehlst dich " + fatigueCheck());
        if (currentPlayer.getWooziness() > 0) {
            System.out.println("|| Du bist " + woozinessCheck());
        }
        System.out.println("***************************************************");                                                   
    }

    public void statCheck() {
        System.out.println("HP: " + currentPlayer.getHp());
        System.out.println("Deutschkenntnisse: " + currentPlayer.getGer());
        System.out.println("Englischkenntnisse: " + currentPlayer.getEng());
        System.out.println("Biologiekenntnisse: " + currentPlayer.getBiology());
        System.out.println("Physikkenntnisse: " + currentPlayer.getPhysics());
        System.out.println("Kenntnisse in Philosophie: " + currentPlayer.getPhilo());
        System.out.println("Kenntnisse in Darstellendes Spiel: " + currentPlayer.getActing());
        System.out.println("Du bist zu " + currentPlayer.getStress() + "% gestresst.");
        if (currentPlayer.hasMouse) {
            System.out.println("Du hast eine Maus.");
        }
    }

    public void actionsSchool() {                                                                                //! ACTIONS AT SCHOOL
        int m;
        System.out.println("Was moechtest du tun?");
        System.out.println("____________________");
        if (currentPlayer.getLevel() == "eg") {
            System.out.println("[1] Treppenhaus (2)\n[2] In den Vorhof (2)\n[3] In den Deutschraum (2)\n[4] In den Ethikraum (2)\n[5] In die Bibliothek (2)\n[9] Deine Statistiken");
            System.out.println("--------------------");
            m = sc.nextInt();
            System.out.println("--------------------");
            if (m == 1) {                                                                                               //! [1]
                currentPlayer.addMin(2);
                actionsTreppe(); 
                return;
                }
            else if (m == 2) {                                                                                          //! [2]
                currentPlayer.addMin(2);
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
                            currentPlayer.addMin(1);
                            System.out.println("Du naeherst dich langsam den Jungen. Der junge Kater schaut hoch zu dir als du dich neben ihm hinkniest.");
                            b = Math.random() * 101;
                            if (b < 10) {
                                System.out.println("Auf einmal hoerst du ein Knurren. Als du dich umdrehst, springt dir ein Fuchs ins Gesicht und zerkratzt dich mit ihren Krallen.");
                                currentPlayer.addHp(-30);
                                currentPlayer.addFatigue(20);
                                System.out.println("Du schaffst es, den Fuchs abzuschuetteln und rennst zurueck ins Gebaeude.");
                                currentPlayer.addMin(1);
                            } else {
                                System.out.println("Der junge Kater drueckt seinen Kopf in deine Hand, waehrend du sein Fell streichelst.");
                                System.out.println("Du streichelst beide Jungtiere fuer eine Weile.");
                                currentPlayer.addStress(-25);
                                currentPlayer.addWooziness(-10);
                                currentPlayer.addMin(5);
                            }
                        }
                        else if (m == 2) {
                            System.out.println("Du siehst zu wie die zwei Jungtiere spielen.");
                            currentPlayer.addFatigue(-15);
                            currentPlayer.addStress(-15);
                            currentPlayer.addHp(10);
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
                currentPlayer.addMin(2);
                if (currentPlayer.getHour() == 11 && currentPlayer.getMin() <= 35 || currentPlayer.getMin() >= 15) {
                    System.out.println("Der Raum ist voll mit Schuelern. Alle drehen sich zu dir um.");
                    System.out.println("____________________");
                    System.out.println("[1] Hinsetzen\n[2] Rausgehen");
                    System.out.println("--------------------");
                    m = sc.nextInt();
                    if (m == 1) {
                        currentPlayer.addHour(1); 
                        System.out.println("Du setzt dich hin und bleibst dort fuer den Rest der Stunde."); 
                        wait(1000);
                        System.out.println("Die Schulklingel laeutet und alle verlassen den Raum.");
                        currentPlayer.set("hour", 13);
                        currentPlayer.addMin(5);
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
                if (currentPlayer.getHour() == 7 && currentPlayer.getMin() <= 55) {
                        System.out.println("Schueler setzen sich hin bevor die Stunde anfacurrentPlayer.getEngt.");
                        System.out.println("____________________");
                        System.out.println("[1] Hinsetzen\n[2] Raum verlassen");
                        System.out.println("--------------------");
                        m = sc.nextInt();
                        System.out.println("--------------------");
                        if (m == 1) {
                            System.out.println("Du setzt dich hin und bleibst dort fuer den Rest der Stunde.");
                            wait(1000);
                            System.out.println("Die Schulklingel laeutet und alle verlassen den Raum.");
                            currentPlayer.set("hour", 9);
                            currentPlayer.addMin(25);
                        }
                    }
                }
            else if (m == 5) {currentPlayer.setLevel("bb"); currentPlayer.addMin(2);}                                                                  //! [5]
            else if (m == 9) {statCheck();}                                                                             //! [9]
        }
        else if (currentPlayer.getLevel() == "og") {
            System.out.println("[1] Treppenhaus\n[2] In den Biologieraum\n[3] In die Physiksammelung\n[4] In den Chemieraum\n[9] Deine Statistiken");
            System.out.println("--------------------");
            m = sc.nextInt();
            System.out.println("--------------------");
            if (m == 1) {actionsTreppe();}
            else if(m == 2) {
                currentPlayer.addMin(2);
                if (currentPlayer.getHour() == 11 && currentPlayer.getMin() <= 35 || currentPlayer.getMin() >= 15) {
                    System.out.println("Der Raum ist voll mit Schuelern. Alle drehen sich zu dir um.");
                    System.out.println("____________________");
                    System.out.println("[1] Hinsetzen\n[2] Rausgehen");
                    System.out.println("--------------------");
                    m = sc.nextInt();
                    if (m == 1) {
                        currentPlayer.addHour(1); 
                        System.out.println("Du setzt dich hin und bleibst dort fuer den Rest der Stunde."); 
                        wait(1000);
                        System.out.println("Die Schulklingel laeutet und alle verlassen den Raum.");
                        currentPlayer.set("hour", 13);
                        currentPlayer.addMin(5);
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
                currentPlayer.addMin(2);
                if (currentPlayer.getHour() == 9 && currentPlayer.getMin() <= 25) {
                    System.out.println("Der Raum ist voll mit Schuelern. Alle drehen sich zu dir um.");
                    System.out.println("____________________");
                    System.out.println("[1] Hinsetzen\n[2] Rausgehen");
                    System.out.println("--------------------");
                    m = sc.nextInt();
                    if (m == 1) {
                        currentPlayer.addHour(1); 
                        System.out.println("Du setzt dich hin und bleibst dort fuer den Rest der Stunde."); 
                        wait(1000);
                        System.out.println("Die Schulklingel laeutet und alle verlassen den Raum.");
                        currentPlayer.set("hour", 11);
                        currentPlayer.addMin(15);
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
                currentPlayer.addMin(2);
                if (currentPlayer.getHour() == 11 && currentPlayer.getMin() <= 35 || currentPlayer.getMin() >= 15) {
                    System.out.println("Der Raum ist voll mit Schuelern. Alle drehen sich zu dir um.");
                    System.out.println("____________________");
                    System.out.println("[1] Hinsetzen\n[2] Rausgehen");
                    System.out.println("--------------------");
                    m = sc.nextInt();
                    if (m == 1) {
                        currentPlayer.addHour(1); 
                        System.out.println("Du setzt dich hin und bleibst dort fuer den Rest der Stunde."); 
                        wait(1000);
                        System.out.println("Die Schulklingel laeutet und alle verlassen den Raum.");
                        currentPlayer.set("hour", 13);
                        currentPlayer.addMin(5);
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
        else if (currentPlayer.getLevel() == "ug") {
            System.out.println("[1] Treppenhaus (2)\n[2] In den Kunstraum (2)\n[3] In die Instrumentekammer (2)\n[4] Hinter die Bühne (2)\n[9] Deine Statistiken");
            System.out.println("--------------------");
            m = sc.nextInt();
            System.out.println("--------------------");
            if (m == 1) {actionsTreppe();}
            else if(m == 2) {}
            else if(m == 3) {}
            else if(m == 4) {
                if (currentPlayer.hasToldTeacher) {
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
                    if (currentPlayer.hasReadBook) {
                        System.out.println("Du erzaehlst dem Lehrer was du im Buch gelesen hast.");
                        currentPlayer.hasReadBook = false;
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
        else if (currentPlayer.getLevel() == "k") {
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
        else if (currentPlayer.getLevel() == "bb") {
            System.out.println("[1] Etwas lesen\n[2] Tiefer in die Bibliothek gehen\n[3] Zuereck\n[9] Deine Statistiken");
            System.out.println("--------------------");
            m = sc.nextInt();
            System.out.println("--------------------");
            if (m == 1) {
                currentPlayer.addMin(1);
                System.out.println("Du gehst zu den Buecherregalen.");
                System.out.println(books.printOptions());
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
                            currentPlayer.setLevel("k");
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
                currentPlayer.setLevel("eg");
            }
            else if (m == 9) {statCheck();} 
        }
    }

    public void bookReward(int n) {
        for (int i = 1; i<4; i++) {
            if (n == i) {
                bookID = pick[n];
            }
        }
            if      (bookID == 0)  {currentPlayer.addStress(-5); currentPlayer.addFatigue(1); currentPlayer.addGer(10); currentPlayer.addPhilo(25);}
            else if (bookID == 1)  {currentPlayer.addStress(-5); currentPlayer.addFatigue(1); currentPlayer.addGer(25);}
            else if (bookID == 2)  {currentPlayer.addStress(-20); currentPlayer.addFatigue(-10); currentPlayer.set("hp", 100);}
            else if (bookID == 3)  {currentPlayer.addStress(5); currentPlayer.addFatigue(1); currentPlayer.addGer(10); currentPlayer.addBiology(25);}
            else if (bookID == 4)  {currentPlayer.addStress(5); currentPlayer.addFatigue(1); currentPlayer.addGer(10); currentPlayer.addPhysics(25);}
            else if (bookID == 5)  {currentPlayer.addStress(5); currentPlayer.addFatigue(1); currentPlayer.addGer(5); currentPlayer.addMath(10);}
            else if (bookID == 6)  {currentPlayer.addStress(1); currentPlayer.addFatigue(1); currentPlayer.addGer(20); currentPlayer.addPhilo(30);}
            else if (bookID == 7)  {currentPlayer.addStress(-10); currentPlayer.addFatigue(1); currentPlayer.addGer(10); currentPlayer.addActing(20); currentPlayer.hasReadBook = true;}
            else if (bookID == 8)  {currentPlayer.addStress(1); currentPlayer.addFatigue(1); currentPlayer.addGer(20); currentPlayer.addPhilo(20);}
            else if (bookID == 9)  {currentPlayer.addStress(1); currentPlayer.addFatigue(1); currentPlayer.addGer(5); currentPlayer.addPhilo(5);}
            else if (bookID == 10) {currentPlayer.addStress(-10); currentPlayer.addFatigue(1); currentPlayer.addGer(10); currentPlayer.addActing(10);}
            else if (bookID == 11) {currentPlayer.addStress(-10); currentPlayer.addFatigue(1); currentPlayer.addGer(10); currentPlayer.addPhilo(10);}
            else if (bookID == 12) {currentPlayer.addStress(-5); currentPlayer.addFatigue(1); currentPlayer.addGer(15); currentPlayer.addPhilo(10);}
            else if (bookID == 13) {currentPlayer.addStress(-20); currentPlayer.addFatigue(1);}
            else if (bookID == 14) {currentPlayer.addStress(-20); currentPlayer.addFatigue(-10);}
            else if (bookID == 15) {currentPlayer.addStress(5); currentPlayer.addFatigue(1); currentPlayer.addGer(5); currentPlayer.addMath(20);}
            else if (bookID == 16) {currentPlayer.addStress(1); currentPlayer.addFatigue(1); currentPlayer.addEng(25);}
            else if (bookID == 17) {currentPlayer.addStress(1); currentPlayer.addFatigue(1); currentPlayer.addEng(25);}
            else if (bookID == 18) {currentPlayer.addStress(1); currentPlayer.addFatigue(1); currentPlayer.addEng(25);}
            else if (bookID == 19) {currentPlayer.addStress(1); currentPlayer.addFatigue(1); currentPlayer.addEng(25);}
    }

    public void actionsDeepCellar() {                                                                            //! ACTIONS IN CELLAR
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
            System.out.println("Du findest einen groszen LacurrentPlayer.getGerraum. Es stehen Sofas auf deiner linken Seite und ein Kasten voll mit Elektroschrott auf deiner rechten.");
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
                    if (!currentPlayer.hasMouse) {
                        System.out.println("Du findest eine funktionierende Maus und nimmst sie mit.");
                        currentPlayer.hasMouse = true;
                        actionsDeepCellar();
                    } else {
                        System.out.println("Du hoerst ein currentPlayer.getGeraeusch und versteckst dich hinter der Kiste. Der Hausmeister schaut hinein: 'Ist da jemand?'");
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
                    currentPlayer.addWooziness((int) (Math.random() * 11 + 10));
                    currentPlayer.addStress((int) (Math.random() * 11 + 5));
                    currentPlayer.addHp(-1);
                } else if (m == 2) {
                    currentPlayer.addWooziness((int) (Math.random() * 11 + 30));
                    currentPlayer.addStress((int) (Math.random() * 11 + 10));
                    currentPlayer.addHp(-5);
                }
            } while (m != 3);
        }
    }

    public void actionsTreppe() {                                                                                //! STAIRCASE
        int m;
        if (currentPlayer.getLevel() == "eg") {
            do {
                System.out.println("***********************************");
                System.out.println("* [1] Einen Geschoss hoeher gehen *\n* [2] Einen Geschoss runter gehen *");
                System.out.println("***********************************");
                m = sc.nextInt();
                if (m == 1) {currentPlayer.addMin(1); currentPlayer.setLevel("og"); return;}
                else if (m == 2) {currentPlayer.addMin(1); currentPlayer.setLevel("ug"); return;}
            } while (m != 1 || m != 2);
        }
        else if (currentPlayer.getLevel() == "og") {
            do {
                System.out.println("****************************************");
                System.out.println("[1] Einen Geschoss runter gehen");
                System.out.println("****************************************");
                m = sc.nextInt();
                if (m == 1) {currentPlayer.addMin(1); currentPlayer.setLevel("eg"); return;}
            } while (m != 1);
        }
        else if (currentPlayer.getLevel() == "ug") {
            do {
                System.out.println("****************************************");
                System.out.println("[1] Einen Geschoss hoeher gehen \n[2] Einen Geschoss runter gehen ");
                System.out.println("****************************************");
                m = sc.nextInt();
                if (m == 1) {currentPlayer.addMin(1); currentPlayer.setLevel("eg"); return;}
                else if (m == 2) {currentPlayer.addMin(1); currentPlayer.setLevel("k"); return;}
            } while (m != 1 || m != 2);
        }
        else if (currentPlayer.getLevel() == "k") {
            do {
                System.out.println("****************************************");
                System.out.println("[1] Einen Geschoss hoeher gehen");
                System.out.println("****************************************");
                m = sc.nextInt();
                if (m == 1) {currentPlayer.addMin(1); currentPlayer.setLevel("ug"); return;}
            } while (m != 1);
        }
    }

    public String fatigueCheck() {
        if (currentPlayer.getStress() > 80) {
            currentPlayer.addFatigue(20);
        }

        String fat = "";
        if (currentPlayer.getFatigue() < 30) {
            fat = "aufgefrischt.";
        }
        else if (currentPlayer.getFatigue() > 30) {
            fat = "wach.";
        }
        else if (currentPlayer.getFatigue() > 50) {
            fat = "etwas angestrcurrentPlayer.getEngt.";
        }
        else if (currentPlayer.getFatigue() > 80) {
            fat = "muede.";
        }
        else if (currentPlayer.getFatigue() >= 100) {
            tod();
        }
        return fat;
    }
    
    public String woozinessCheck() {
        String fat = "";
        if (currentPlayer.getWooziness() < 30) {
            fat = "waermer als sonst.";
            currentPlayer.addStress(-1);
            currentPlayer.addBladder(1);
        }
        else if (currentPlayer.getWooziness() >= 30 && currentPlayer.getWooziness() < 50) {
            fat = "etwas angetrunken.";
            currentPlayer.addStress(-5);
            currentPlayer.addBladder(2);
        }
        else if (currentPlayer.getWooziness() >= 50 && currentPlayer.getWooziness() < 80) {
            fat = "ziemlich behaemmert.";
            currentPlayer.addStress(-10);
            currentPlayer.addBladder(3);
        }
        else if (currentPlayer.getWooziness() >= 80  && currentPlayer.getWooziness() < 100) {
            fat = "sturzbesoffen.";
            currentPlayer.addStress(-20);
            currentPlayer.addBladder(4);
            int b = (int) (Math.random() * 101);
            if (b <= 20) {
                currentPlayer.resetAll();
                currentPlayer.set("hp", 50);
                System.out.println("Dir wird schwarz vor Augen.");
                wait(2000);
                currentPlayer.addDay(1);
                clear();
                System.out.println("Es ist ein Tag vergangen.");
                currentPlayer.set("hour", 17);
            }
        }
        else if (currentPlayer.getWooziness() >= 100) {
            tod();
        }
        return fat;
    }

    public String levelCheck(String fat) {
        if (currentPlayer.getLevel() == "k") {
            fat = "im Keller";
        }
        else if (currentPlayer.getLevel() == "ug") {
            fat = "im Untergeschoss";
        }
        else if (currentPlayer.getLevel() == "eg") {
            fat = "im Erdgeschoss";
        }
        else if (currentPlayer.getLevel() == "og") {
            fat = "im Obergeschoss";
        }
        else if (currentPlayer.getLevel() == "bb") {
            fat = "in der Bibliothek";
        }
        else if (currentPlayer.getLevel() == "wc") {
            fat = "auf der Toilette";
        }
        return fat;
    }
    
    public String time() {
        String t = "";
        if (currentPlayer.getMin() >= 60) {
            currentPlayer.addMin(-60);
            currentPlayer.addHour(1);
        }
        if (currentPlayer.getMin() < 10) {t = currentPlayer.getHour() + ":0" + currentPlayer.getMin();} else {t = currentPlayer.getHour() + ":" + currentPlayer.getMin();}
        return t;
    }
    
    public boolean schoolEnd() {
        if (currentPlayer.getHour() == 17 && currentPlayer.getMin() == 15) {
            System.out.println("Die Schule ist für heute vorbei, deswegen gehst du nach Hause."); 
            return true; 
        } else {
            return false;
        }
    }
    
    public boolean homeEnd() {
        if (currentPlayer.getHour() == 22) {
            currentPlayer.addDay(1);
            currentPlayer.setLevel("eg"); 
            currentPlayer.set("wooziness", 0); 
            currentPlayer.set("hour", 7);
            currentPlayer.set("min", 0); 
            currentPlayer.set("fatigue", 0);
            System.out.println("********************************************************************************");
            System.out.println("Es ist spaet und du gehst schlafen.");
            System.out.println("Es ist früher Morgen und du begibst dich zur Schule.");
            System.out.println("********************************************************************************");
            return true; 
        } else {
            return false;
        }
    }

    public void tod() {
        System.out.println("Du bist gestorben.");
        wait(2000);
        System.out.println("Moechtest du nochmal spielen? \n[1] Ja [2] Nein \n___________________________");
        int m = sc.nextInt();
        if (m == 1) {
            currentPlayer.resetAll();
            game();
        }
        if (m == 2) {System.exit(0);}
    }

    public void backrooms() {
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

}
