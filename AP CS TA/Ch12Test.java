/**
 * Ch12Test
 */
public class Ch12Test {

    public static void main(String[] args) {
        // System.out.println(addO("WAW sW OOSOWWOS ARARRWOOSAD DAWWW W WW S"));
        // System.out.println(predict(4));
        // permutations(new char[]{ 'a', 'b' }, 3, "");
        rapTime(2, "");
    }


    /// PROBLEM 5 ///

    /* Adhit loves the letter "O". However, he only likes it after the letter "W".
     * Write a recursive function that appends an "O" after every "W" in a given string and returns it.
     * You may pass only ONE parameter to the method.
     */ 

    public static String addO(String s) {
        if (s.charAt(s.lastIndexOf("W") + 1) == 'O')
            return s;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'W' && s.charAt(i + 1) != 'O') {
                return addO(s.substring(0, i + 1) + 'O' + s.substring(i + 1, s.length()));
            }
        }
        return s;
    }

    /// PROBLEM 6 ///

    /* Oh no! The alien UwUs have come back after an entire semester of absence with Divya as their leader!
     * This time, they are attacking in the following recursive formation:
     * 
     * Level 1 formation: UwU
     * Level 2 formation: UwUUwwUUwU
     * Level 3 formation: UwUUwwUUwUUwwwUUwUUwwUUwU
     * 
     * Notice how Level 1 is used in the Level 2 formation and how Level 2 is used in the Level 3 formation.
     * Please help the remaining survivors of the attack write a method that can predict the formation
     * of a level n formation. You may pass only ONE parameter to the method.
     */

    public static String predict(int n) {
        if (n == 0)
            return "";
        String uwu = "U";
        for (int i = 0; i < n; i++)
            uwu += "w";
        return predict(n - 1) + uwu + "U" + predict(n - 1);
    }

    /// PROBLEM 7 ///

    /* Given a set of characters and a positive integer k, print all possible strings of length k
     * that can be formed from the given set. You may pass multiple parameters to your method.
     * Organize your code however you’d like to, but make sure you use a recursive method to get the
     * string combinations and make sure to print out the strings at the end.
     */ 

    public static void permutations(char[] set, int k, String curr) {
        if (curr.length() == k) {
            System.out.println(curr);
        } else {
            for (int i = 0; i < set.length; i++) {
                permutations(set, k, curr + set[i]);
            }
        }
    }

    public static void rapTime(int n, String num) {
        if (n == 0) {
            if (Integer.parseInt(num) % 3 == 0) {
                System.out.println(num);
            }
        } else {
            for (int j = 1; j <= 3; j++) {
                num += j;
                rapTime(n - 1, num);
                num = num.substring(0, num.length() - 1);
            }
        }
    }

}