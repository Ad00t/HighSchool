import java.util.*;

/**
 * Mystery
 */
public class Mystery {

    private static int ways = 1;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the number of stairs to climb (positive integer): ");
        int n = console.nextInt();
        console.close();   

        List<Integer> L = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            L.add(Integer.valueOf(1));
        }

        System.out.println(L);
        mysteryMethod(n, L, n - 2, n - 1); 
        System.out.println("Total number of ways = " + ways);
    }

    private static void mysteryMethod(int n, List<Integer> L, int i0, int i1) {
        if (i0 >= 0 && L.get(i0) != 2) {
            ways++;
            List<Integer> Lnew = merge(L, i0, i1);
            System.out.println(Lnew);
            if (Lnew.get(Lnew.size() - 2) == 1 && Lnew.get(Lnew.size() - 1) == 1) {
                mysteryMethod(n, Lnew, Lnew.size() - 2, Lnew.size() - 1);
            }
            mysteryMethod(n, L, i0 - 1, i1 - 1);
        }
    }

    private static List<Integer> merge(List<Integer> L, int i0, int i1) {
        List<Integer> Lnew = new ArrayList<>(L);
        Lnew.remove(i1);
        Lnew.remove(i0);
        Lnew.add(i0, Integer.valueOf(2));
        return Lnew;
    }

}