// package Ch6;

import java.util.Scanner;

/**
 * HogwartsMurderMystery
 */
public class HogwartsMurderMystery {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();

        int[] r1 = new int[4];
        int[] r2 = new int[4];
        int setCount = 0;
        for (int i = 0; i < ((n / 4) % 2 == 0 ? n : n - 4); i++) {
            if (setCount < 4) {
                r1[setCount] = console.nextInt();
            } else if (setCount < 8) {
                r2[setCount - 4] = console.nextInt();
            }
            setCount++;
            if (setCount == 8) {
                System.out.print(decoded(r1, r2));
                setCount = 0;
            }
        }
        System.out.println();
    }

    public static String decoded(int[] r1, int[] r2) {
        int tmp1 = r1[1];
        int tmp2 = r1[2];
        r1[1] = r2[1];
        r1[2] = r2[2];
        r2[1] = tmp1;
        r2[2] = tmp2;
        return String.valueOf((char) sum(r1)) + String.valueOf((char) sum(r2));
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int n : arr) sum += n;
        return sum;
    }

}