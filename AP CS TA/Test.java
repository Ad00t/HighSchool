import java.util.*;

/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        ArrayList<Integer> s = new ArrayList<Integer>(Arrays.asList(new Integer[]{ 1, 6, 2, 0, -1, 1, 8, 5, 9, 3, 6 }));
        for (int i = 0; i < s.size() - 1; i++) {
            int avg = (s.get(i) + s.get(i + 1)) / 2;
            s.set(i, avg);
            s.remove(i + 1);
            System.out.println(s);
        }
    }

}