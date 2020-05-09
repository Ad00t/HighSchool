import java.util.*;

/**
 * MoveDisks
 */
public class MoveDisks {

    private static int moves = 0;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = console.nextInt();
        System.out.print("Enter destination post: ");
        String dest = console.next();

        System.out.println("Moves:");
        move(n, "A", dest, dest.equals("C") ? "B" : "C");
        System.out.println("Number of moves: " + moves);
        console.close();
    }

    private static void move(int n, String from, String to, String other) {
        if (n == 1) { 
            System.out.println(from + " -> " + to); 
            moves++;
        } else {
            move(n - 1, from, other, to); 
            System.out.println(from + " -> " + to); 
            moves++;
            move(n - 1, other, to, from); 
        }
    }

}