import java.util.Scanner;

public class AlphabetDiagonal {
    
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int radius = console.nextInt();
        console.close();

        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(".");
            }
            System.out.println((char) (65 + 2 * i));
        }
    }

}
