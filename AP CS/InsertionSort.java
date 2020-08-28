import java.util.*;

/**
 * InsertionSort
 */
public class InsertionSort {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Integer> L = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            L.add(console.nextInt());
        }
        console.close();

        System.out.println("insertionSort");
        for (int i = 1; i < 10; i++) {
            System.out.println(L);
            int j;
            for (j = 0; j < i; j++) {
                if (L.get(j) >= L.get(i))
                    break;
            }  
            int n = L.get(i);
            L.remove(i);
            L.add(j, n);
        }
        System.out.println(L);
        System.out.println();
    }

}