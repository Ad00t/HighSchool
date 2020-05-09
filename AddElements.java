import java.util.*;

/**
 * AddElements
 */
public class AddElements {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter size of integer array: ");
        int n = console.nextInt();
        System.out.println("Enter n integers separated by spaces: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = console.nextInt();
        }
        recurseSum(0, 0, arr);
        console.close();
    }

    public static void recurseSum(int i, int sum, int[] arr) {
        if (i < arr.length - 1) {
            recurseSum(i + 1, sum + arr[i], arr);
        } else {
            System.out.println("The sum of the elements in your list: " + (sum + arr[i]));
        }
    }

}