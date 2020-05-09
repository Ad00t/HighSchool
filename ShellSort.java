import java.util.*;

/**
 * ShellSort
 */
public class ShellSort {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Integer> L = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            L.add(console.nextInt());
        }
        console.close();

        System.out.println("shellSort");
        for (int gap = L.size() / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < L.size() - gap; i++) {
                if (L.get(i + gap) < L.get(i)) {
                    int temp = L.get(i);
                    L.set(i, L.get(i + gap));
                    L.set(i + gap, temp);
                }
            }
        }
        System.out.println(L);
        System.out.println();
    }

}