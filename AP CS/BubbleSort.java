import java.util.*;

/**
 * BubbleSort
 */
public class BubbleSort {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Integer> L = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            L.add(console.nextInt());
        }
        console.close();

        System.out.println("bubbleSort");
        for (int i = 0; i < 10; i++) {
            System.out.println(L);
            for (int j = 0; j < 9; j++) {
                if (L.get(j) > L.get(j + 1)) {
                    int j1 = L.get(j + 1);
                    L.set(j + 1, L.get(j));
                    L.set(j, j1);
                }
            }
        }
        System.out.println();
    }

}