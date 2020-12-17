package Week6_7;

/**
 * Week6
 */
public class Week6 {

    public static void main(String[] args) {

        exitExample(2);

    }

    public static int countWords(String str) {
        int counter = 1;
        for (int i = 0; i < str.length(); i++) {
            int a = str.charAt(i);
            if (str.charAt(i) == ' ') {
                counter++;
            }
        }

        int a = countWords("The quick brown fox jumps over the");
        System.out.println(a);

        return counter;
    }

    public static int plus2(int a) {
        return a + 2;
    }

    public static void exitExample(int a) {
        if (a >= 5) {
            return;
        }
        System.out.println(a);
        exitExample(a + 1);
    }

}