import java.util.*;

/**
 * WriteNums
 */
public class WriteNums {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = console.nextInt();
        recurse(1, n);
        System.out.println();
        console.close();
    }

    public static void recurse(int curr, int n) {
        if (curr < n) {
            System.out.print(curr + ", ");
            recurse(curr + 1, n);
        } else if (curr == n) {
            System.out.print(n);
        }
    }
}