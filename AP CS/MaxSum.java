import java.util.*;

/**
 * MaxSum
 */
public class MaxSum {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        List<Integer> L = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            L.add(console.nextInt());
        }
        int limit = console.nextInt();
        console.close();  

        if (L.size() == 0 || limit <= 0) {
            System.out.println(0);
        } else {
            int[] max = new int[]{ 0 };
            maxSum(L, limit, 0, max);
            System.out.println(max[0]);
        }
    }
    
    private static void maxSum(List<Integer> list, int limit, int sum, int[] max) {
        if (sum > max[0] && sum <= limit) {
            max[0] = sum;
        }
        if (list.size() != 0) {
            int num = list.remove(0);
            maxSum(list, limit, sum + num, max);
            maxSum(list, limit, sum, max);
            list.add(num);
        }
    }

}