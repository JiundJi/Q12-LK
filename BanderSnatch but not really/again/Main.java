import java.util.concurrent.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        game.menu();
        while (!game.stop()) {
            game.start();
        }
        System.exit(0);
    }
}