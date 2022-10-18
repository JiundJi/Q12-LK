public class Library extends Game{

    public void enterLibrary() {
        int m;
        System.out.println("[1] Etwas lesen\n[2] Tiefer in die Bibliothek gehen\n[3] Zuereck\n[9] Deine Statistiken");
            System.out.println("--------------------");
            m = util.sc.nextInt();
            System.out.println("--------------------");
            if (m == 1) {
                player.addTime("min", 1, false);
                System.out.println("Du gehst zu den Buecherregalen.");
                System.out.println(randomBook());
                m = util.sc.nextInt();
                bookReward(m);
            }
            else if (m == 2) {
                System.out.println("Du findest einen Computer und eine Tuer.");
                System.out.println("____________________");
                do{
                    System.out.println("[1] Zum Computer (1)\n[2] Zur Tuer (1) \n [3] Zurueck");
                    System.out.println("--------------------");
                    m = util.sc.nextInt();
                    System.out.println("--------------------");
                    if (m == 1) {
                        Game.backrooms();
                    }
                    else if (m == 2) {
                        System.out.println("Du findest eine Treppe.");
                        System.out.println("____________________");
                        System.out.println("[1] Treppe runter\n[2] Zurueck");
                        System.out.println("--------------------");
                        m = util.sc.nextInt();
                        System.out.println("--------------------");
                        if (m == 1) {
                            player.addLevel(-2);
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
    public String randomBook() {
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
    public void bookReward(int n) {
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
}
