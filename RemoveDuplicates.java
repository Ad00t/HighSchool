import java.util.*;

/**
 * RemoveDuplicates
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println("\nPlease enter an alphabetical sequence of strings separated\nby spaces. The end of the sequence must be signified using\nthe sentinel value lastString, followed by a return.\n");
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> original = new ArrayList<>();
        String token = "";
        while (!(token = scanner.next()).equals("lastString")) {
            original.add(token);
        }
        System.out.println("\nYour original list: [" + listStrings(original.toArray()) + "]");

        ArrayList<String> duplicatesRemoved = new ArrayList<>();
        for (String s : original) {
            boolean shouldAdd = true;
            for (String d : duplicatesRemoved) {
                if (d.toLowerCase().equals(s.toLowerCase())) {
                    shouldAdd = false;
                    break;
                }
            }
            if (shouldAdd) {
                duplicatesRemoved.add(s);
            }
        }
        System.out.println("\nYour list with duplicates removed: [" + listStrings(duplicatesRemoved.toArray()) + "]\n");

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