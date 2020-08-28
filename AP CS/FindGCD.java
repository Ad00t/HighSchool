import java.util.*;

/**
 * FindGCD
 */
public class FindGCD {

    public static void main(String[] args) {
        System.out.print("Enter an integer: ");
        Scanner console = new Scanner(System.in);
        int x = console.nextInt();
        System.out.print("Enter an integer: ");
        int y = console.nextInt();  
        
        GCD(Math.abs(x), Math.abs(y));
        console.close();
    }

    public static void GCD(int x, int y) {
        if (y == 0) {
            System.out.println("GCD = " + Math.abs(x));
        } else {
            int newX = x % y;
            int newY = y;
            if (x < y) {
                newX = y;
                newY = x % y;
            }
            GCD(newX, newY);
        }
    }

}
