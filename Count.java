import java.util.*;

/**
 * Count
 */
public class Count {

    public static void main(String[] args) {
        System.out.println("\nPlease enter an alphabetical sequence of strings separated\nby spaces. The end of the sequence must be signified using\nthe sentinel value lastString, followed by a return.\n\n");

        Scanner console = new Scanner(System.in);
        ArrayList<String> original = new ArrayList<>();
        while (console.hasNext()) {
            original.add(console.next().toLowerCase());
        }
        original.remove("laststring");

        System.out.println("Your original list: " + original);

        HashMap<String, Integer> countMap = new HashMap<>();
        for (String s : original) {
            if (countMap.keySet().contains(s)) {
                countMap.put(s, countMap.get(s) + 1);
            } else {
                countMap.put(s, 1);
            }
        }

        Collection<Integer> countCol = countMap.values();
        ArrayList<Integer> count = new ArrayList<>();
        for (Integer c : countCol) {
            count.add(c);
        }
        Collections.sort(count);
        System.out.println("Count: " + count);
        console.close();
    }

}