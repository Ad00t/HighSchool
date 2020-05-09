import java.util.*;

/**
 * RemoveInRange
 */
public class RemoveInRange {

    public static void main(String[] args) {
        System.out.println("\nPlease enter an alphabetical sequence of strings separated\nby spaces. The end of the sequence must be signified using\nthe sentinel value lastString, followed by a return.\n");

        Scanner console = new Scanner(System.in);
        ArrayList<String> original = new ArrayList<>();
        String next = "";
        while (!(next = console.next()).equals("lastString")) {
            original.add(next);
        } 
        System.out.println("Your original list: " + original + "\n");

        System.out.println("Now please enter your start String\n");
        String start = console.next();

        System.out.println("Finally, please enter your end String\n");
        String end = console.next();

        ArrayList<String> reduced = new ArrayList<>();
        for (String s : original) {
            if (s.compareTo(start) < 0 || s.compareTo(end) > 0) {
                reduced.add(s);
            }
        }
        System.out.println("Your reduced list: " + reduced);

        console.close();
    }

}