import java.util.*;

/**
 * Mice
 */
public class Mice {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        int[] me = new int[n];
        for (int i = 0; i < n; i++) {
            me[i] = console.nextInt();
        }
        int numMice = console.nextInt();
        ArrayList<int[]> mice = new ArrayList<>();
        for (int i = 0; i < numMice; i++) {
            int s = console.nextInt();
            int[] mouse = new int[s];
            for (int j = 0; j < s; j++) {
                mouse[j] = console.nextInt();
            }
            mice.add(mouse);
        }
        console.close();

        int escapedFrom = 0;
        for (int[] mouse : mice) {
            if (!canRun(me, mouse)) break;
            escapedFrom++;
        }
        System.out.println(escapedFrom);
    }

    private static boolean canRun(int[] me, int[] mouse) {
        if (mouse.length == 1) { 
            if (index(me, mouse[0]) == -1)
                return false;
        }
        for (int i = 0; i < mouse.length - 1; i++) {
            if (index(me, mouse[i]) > index(me, mouse[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private static int index(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) return i;
        }
        return -1;
    }

}