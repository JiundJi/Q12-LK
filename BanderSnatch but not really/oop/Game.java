package oop;
import java.util.concurrent.*;

public class Game {
    public Player curPlayer = new Player("AAAAAA");
    public static void main (String[] args) {
        Game Game = new Game();
        Game.menu();
        Game.start();
    }

    private void menu() {
        System.out.println("---------------------------");
        System.out.println("| Wilkommen bei JiundJi's RPG");
        System.out.println("---------------------------");

        
    }

    private void start() {
        School school = new School();
        Home home = new Home();

        while (!curPlayer.isDead()) {
            status();
            action();
        }
    }
    private void status() {
        System.out.println("Es ist " + curPlayer.getHour() + ":" + curPlayer.getMin() + ".");
    }
    private void action() {
        if ("home".equals(curPlayer.getLevel())) {
            actionsHome();
        } else if ("road".equals(curPlayer.getLevel())) {
            actionsRoad();
        } else if ("school".equals(curPlayer.getLevel())) {
            actionsSchool();
        }
    }

    private void actionsSchool() {
        
    }

    private void actionsRoad() {
        
    }

    private void actionsHome() {
        
    }

    
}
