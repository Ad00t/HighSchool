import java.util.*;

/**
 * Maps
 */
public class Maps {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        int k = console.nextInt();
        int q = console.nextInt();
        
        HashMap<String, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(console.next(), console.nextLong());
        }
        for (int i = 0; i < k; i++) {
            String key = console.next();
            map.put(key, map.get(key) + console.nextLong());
        }

        long sum = 0;
        for (int i = 0; i < q; i++) {
            sum += map.get(console.next());
        }
        System.out.println(Math.round(sum % (Math.pow(10, 9) + 7)));
        console.close();
    }

}