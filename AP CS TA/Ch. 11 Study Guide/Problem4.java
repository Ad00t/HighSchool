/**
 * Problem 5
 */

import java.util.*;

public class Problem4 {
    
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        factorization(16, 2, set, "");
        for (String s : set)
            System.out.println(s);
    }

    public static void factorization(int[] n, int i, Set<String> set, String out) {
        if (i == n) {
            if (!out.isEmpty()) {
                char[] arr = (out + i).toCharArray();
                Arrays.sort(arr);
                set.add(String.join(" ", new String(arr).split("")));
            }
            return;
        }
        if (n % i == 0) {
            factorization(n / i, 2, set, out + i);
        }
        factorization(n, i + 1, set, out);
    }

}
