/**
 * Problem3
 */
public class Problem2 {

    public static void main(String[] args) {
        integerDivision(10, 3, 0); // 3 r 1
        integerDivision(28, 5, 0); // 5 r 3
    }

    public static void integerDivision(int a, int b, int n) {
        if (a < b) {
            System.out.println(n + " r " + a);
        } else {
            integerDivision(a - b, b, n + 1);
        }
            
    }

}