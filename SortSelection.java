import java.util.*;

/**
 * SortSelection
 */
public class SortSelection {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Integer> L = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            L.add(console.nextInt());
        }
        console.close();

        System.out.println("selectionSort");
        for (int i = 0; i < L.size(); i++) {
            System.out.println(L);
            int min = i;
            for (int j = min + 1; j < L.size(); j++) {
                if (L.get(j) < L.get(min)) min = j;
            }
            int temp = L.get(min);
            L.set(min, L.get(i));
            L.set(i, temp);
        }
        System.out.println();
    }

}