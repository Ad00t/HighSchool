import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clump
 */
public class Clump {

    
    public static void main(String[] args) {
        System.out.println("\nPlease enter a sequence of strings separated\nby spaces. End the sequence with the sentinel\nvalue \"stop\", followed by a return.\n");
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> original = new ArrayList<>();
        String token = "";
        while (!(token = scanner.next()).equals("stop")) {
            original.add(token);
        }

        System.out.println("Your original list: [" + listStrings(original.toArray()) + "]\n");
        
        ArrayList<String> clumped = new ArrayList<>();
        for (int i = 0; i < original.size(); i += 2) {
            if (i + 1 <= original.size() - 1) {
                clumped.add("(" + original.get(i) + " " + original.get(i + 1) + ")");
            } else {
                clumped.add(original.get(i));
            }
        }
        System.out.println("Your clumped list: [" + listStrings(clumped.toArray()) + "]");

        scanner.close();
    }

    public static String listStrings(Object... strings) {
        String toReturn = "";
        for (int i = 0; i < strings.length; i++) {
            toReturn += strings[i].toString() + (i == strings.length - 1 ? "" : ", ");
        }
        return toReturn;
    }
    
}