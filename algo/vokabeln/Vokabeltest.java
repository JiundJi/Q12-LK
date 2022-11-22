import java.util.Scanner;

public class Vokabeltest {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Vokabelkasten vk = new Vokabelkasten(10);
        vk.getVokabel(sc.nextLine());
        
    }
}