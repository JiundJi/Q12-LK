public class Main {
    public static void main(String[] args) {
        util util = new util();
        Game game = new Game();

        game.menu();
        do {
            game.start();
        } while (!game.stop()); 
        
        System.exit(0);
    }
}