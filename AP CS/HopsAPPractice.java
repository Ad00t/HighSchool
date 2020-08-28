import java.util.*;

public class HopsAPPractice {

    public static void main(String[] args) {
        System.out.print("Enter number of hop sizes, followed by the \ncorresponding list of allowed hop sizes, \nfollowed by the staircase height, all space \nseparated: ");
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        int[] hopSizes = new int[n];
        for (int i = 0; i < n; i++) {
            hopSizes[i] = console.nextInt();
        }
        Arrays.sort(hopSizes);
        int height = console.nextInt();
        console.close();

        int remaining = height;
        List<Integer> hops = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            while (remaining >= hopSizes[i]) {
                remaining -= hopSizes[i];
                hops.add(hopSizes[i]);
            }
        }

        System.out.println(hops.size());
        System.out.println(hops);
    }

}