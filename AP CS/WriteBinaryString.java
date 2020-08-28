import java.util.*;

/**
 * WriteBinaryString
 */
public class WriteBinaryString {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = console.nextInt();
        System.out.print("Binary expression: ");
        if (n < 0) System.out.print("-");
        System.out.println(writeBinaryString(Math.abs(n)));
        console.close();    
    }
    
    public static String writeBinaryString(int n) {
        String result = Integer.toString(n % 2);
        if (n > 1) {
            result = writeBinaryString(n / 2) + result;
        }
        return result;
    }

}