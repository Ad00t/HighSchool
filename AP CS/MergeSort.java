import java.util.*;

/**
 * MergeSort
 */
public class MergeSort {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(console.nextInt());
        }
        console.close();

        System.out.println("mergeSort");
        System.out.println(list);
        split(list, 0, list.size() - 1);
        System.out.println(list);
    }

    private static void split(List<Integer> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            split(list, left, mid);
            split(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }
    
    private static void merge(List<Integer> list, int left, int mid, int right) {
        List<Integer> L = new ArrayList<Integer>();
        for (int i = left; i <= mid; i++) {
            L.add(list.get(i));
        }
        List<Integer> R = new ArrayList<Integer>();
        for (int i = mid + 1; i <= right; i++) {
            R.add(list.get(i));
        }

        int i = 0, j = 0, k = left;
        while (i < L.size() && j < R.size()) {
            if (L.get(i) <= R.get(j)) {
                list.set(k, L.get(i));
                i++;
            } else {
                list.set(k, R.get(j));
                j++;
            }
            k++;
        }

        while (i < L.size()) {
            list.set(k, L.get(i));
            i++;
            k++;
        }
        while (j < R.size()) {
            list.set(k, R.get(j));
            j++;
            k++;
        }
    }

}