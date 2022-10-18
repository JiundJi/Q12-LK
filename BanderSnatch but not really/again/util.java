import java.util.concurrent.*;
import java.util.Scanner;

public class util {
    public Scanner sc = new Scanner(System.in);
    public void println(String output) {
        System.out.println(output);
    }
    public void wait(int n) {
        try {
            TimeUnit.MILLISECONDS.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void clear() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
