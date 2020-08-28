import java.util.*;

/**
 * BinarySearch
 */
public class BinarySearch {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = console.nextInt();
        } 
        int find = console.nextInt();

        binarySearch(arr, find, 0, n - 1);
        console.close();
    }

    public static void binarySearch(int[] arr, int find, int first, int last) {
        int mid = first + (last - first) / 2;
        if (arr[mid] == find) {
            System.out.println(mid);
        } else if (arr[first] == find) {
            System.out.println(first);
        } else if (arr[last] == find) {
            System.out.println(last);
        }else {
            if (mid == last || mid == first || last < 1 || first > arr.length - 1) {
                System.out.println(-1);
            } else {
                if (arr[mid] > find) {
                    binarySearch(arr, find, first, mid);
                } else if (arr[mid] < find) {
                    binarySearch(arr, find, mid, last);
                }
            }
        }
    }

}