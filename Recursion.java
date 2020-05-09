import java.util.Scanner;

/**
 * Recursion
 */
public class Recursion {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        recursion(1 + " up " + console.nextInt());
        console.close();
    }

    public static void recursion(String code) {
        String[] split = code.split(" ");
        String recurseCode = "";
        if (split[1].equals("up")) {
            if (Integer.parseInt(split[0]) == Integer.parseInt(split[2])) {
                recurseCode = Integer.parseInt(split[2]) + " down " + 1;
            } else {
                recurseCode = (Integer.parseInt(split[0]) + 1) + " up " + Integer.parseInt(split[2]);
            }
        } else {
            if (Integer.parseInt(split[0]) == 1) {
                System.out.println(1);
                return;
            } else {
                recurseCode = (Integer.parseInt(split[0]) - 1) + " down " + 1;
            }
        }
        System.out.println(split[0]);
        recursion(recurseCode);
    }

}