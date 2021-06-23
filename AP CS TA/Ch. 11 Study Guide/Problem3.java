/**
 * Problem 4
 */
public class Problem3 {
    
    public static void main(String[] args) {
        allCombinations("123", 0, "");
        allCombinations("24736", 0, "");
    }

    public static void allCombinations(String n, int i, String out) {
        if (i == n.length()) {
            System.out.println(out);
        } else {
            out += n.charAt(i);
            allCombinations(n, i + 1, out + " ");
            if (i < n.length() - 1)
                allCombinations(n, i + 1, out);
        }
    }

}
