import java.util.*;

/**
 * Interleave
 */
public class Interleave {

    public static void main(String[] args) {
        System.out.println("\nPlease enter a sequence of integers separated\nby spaces. End the sequence with the sentinel\nvalue 0, followed by a return.\n");
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> first = new ArrayList<>();
        int token;
        while ((token = scanner.nextInt()) != 0) {
            first.add(Integer.valueOf(token));
        }
        System.out.println("Your first list: [" + listInts(first.toArray()) + "]");

        System.out.println("\nPlease enter a sequence of integers separated\nby spaces. End the sequence with the sentinel\nvalue 0, followed by a return.\n");
        ArrayList<Integer> second = new ArrayList<>();
        while ((token = scanner.nextInt()) != 0) {
            second.add(Integer.valueOf(token));
        }
        System.out.println("Your second list: [" + listInts(second.toArray()) + "]\n");

        ArrayList<Integer> interleaved = new ArrayList<>();
        Iterator<Integer> firstI = first.iterator();
        Iterator<Integer> secondI = second.iterator();
        boolean useFirst = true;
        while (firstI.hasNext() || secondI.hasNext()) {
            if (useFirst) {
                if (firstI.hasNext()) {
                    interleaved.add(firstI.next());
                } else {
                    interleaved.add(secondI.next());
                }
            } else {
                if (secondI.hasNext()) {
                    interleaved.add(secondI.next());
                } else {
                    interleaved.add(firstI.next());
                }
            }
            useFirst = !useFirst;
        }
        
        System.out.println("Your interleaved list: [" + listInts(interleaved.toArray()) + "]");
        scanner.close();
    }

    public static String listInts(Object... strings) {
        String toReturn = "";
        for (int i = 0; i < strings.length; i++) {
            toReturn += String.valueOf(strings[i]) + (i == strings.length - 1 ? "" : ", ");
        }
        return toReturn;
    }

}