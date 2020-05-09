import java.util.*;

/**
 * MegaSort
 */
public class MegaSort {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Integer> Lorig = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Lorig.add(console.nextInt());
        }
        console.close();

        ArrayList<Integer> L = new ArrayList<>(Lorig);
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
        
        L = new ArrayList<>(Lorig);
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

        L = new ArrayList<>(Lorig);
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

        L = new ArrayList<>(Lorig);
        System.out.println("mergeSort");
        System.out.println(L);
        split(L, 0, L.size() - 1);
        System.out.println(L);
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