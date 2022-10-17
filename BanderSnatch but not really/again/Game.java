import java.util.Scanner;
import java.util.concurrent.*;
public class Game {
    public void wait(int n) {
        try {
            TimeUnit.MILLISECONDS.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static Scanner sc = new Scanner(System.in);
    private int input = -1;
    private String stringInput = "null";
    Player player = new Player();
    School school = new School();

    public void menu() {
        do {
            System.out.println(" \n \n--------------------------------");
            System.out.println("| Willkommen bei JiundJi's RPG!");
            System.out.println("| [1] Starten [2] Anleitung");
            System.out.println("-------------------------------- \n");
            input = sc.nextInt();
            if (input == 1) {break;}
            else if (input == 2) {intro(); menu();}
        } while (input != 1 || input != 2);
    }

    public void intro() {
        System.out.println("--------------------------------");
        System.out.println("| [1] In den Garten (2)");
        System.out.println("|  ^        ^        ^");
        System.out.println("|  |        |        |");
        System.out.println("|  Auswahl  |        |");
        System.out.println("|  Beschreibung      |");
        System.out.println("|  Benoetigte Zeit --|");
        System.out.println("--------------------------------");
        wait(2000);
    }

    public void start() {
        do {
            status();
        } while (!player.isDead());
    }

    private void status() {
        System.out.println("\n\n\n");
        System.out.println("***************************************************");                                                 
        System.out.println("|| Du bist " + player.getLevel() + ". Es ist momentan " + player.getTime() + " Uhr.");
        System.out.println("|| Du fuehlst dich " + fatigueCheck());
        if (player.getWooziness() > 0) {
            System.out.println("|| Du bist " + woozinessCheck());
        }
        System.out.println("***************************************************");      
    }

    public boolean stop() {
        System.out.println("Moechtest du nochmal spielen? (y/n)");
        stringInput = sc.nextLine();
        if (stringInput == "y" || stringInput == "Y") {return false;}
        else return true;
    }
}
