public class Stairs extends School{
    public void use() {
        int UIn;
            if (curPlayer.getLevel() == "eg") {
                do {
                    System.out.println("***********************************");
                    System.out.println("* [1] Einen Geschoss hoeher gehen *\n* [2] Einen Geschoss runter gehen *");
                    System.out.println("***********************************");
                    UIn = sc.nextInt();
                    if (UIn == 1) {curPlayer.addMin(1); curPlayer.setLevel("og"); return;}
                    else if (UIn == 2) {curPlayer.addMin(1); curPlayer.setLevel("ug"); return;}
                } while (UIn != 1 || UIn != 2);
            }
            else if (curPlayer.getLevel() == "og") {
                do {
                    System.out.println("****************************************");
                    System.out.println("[1] Einen Geschoss runter gehen");
                    System.out.println("****************************************");
                    UIn = sc.nextInt();
                    if (UIn == 1) {curPlayer.addMin(1); curPlayer.setLevel("eg"); return;}
                } while (UIn != 1);
            }
            else if (curPlayer.getLevel() == "ug") {
                do {
                    System.out.println("****************************************");
                    System.out.println("[1] Einen Geschoss hoeher gehen \n[2] Einen Geschoss runter gehen ");
                    System.out.println("****************************************");
                    UIn = sc.nextInt();
                    if (UIn == 1) {curPlayer.addMin(1); curPlayer.setLevel("eg"); return;}
                    else if (UIn == 2) {curPlayer.addMin(1); curPlayer.setLevel("k"); return;}
                } while (UIn != 1 || UIn != 2);
            }
    }
}
