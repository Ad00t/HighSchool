public class Diagonals {

    public static void main(String[] args) {
        int[][] array = { {1, 2, 3, 4, 5},
                          {2, 6, 1, 3, 1},
                          {9, 2, 5, 2, 4},
                          {2, 4, 1, 9, 3},
                          {1, 3, 5, 7, 9} };
        diagonals2(array);
    }

    public static void diagonals1(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int r = 0, c = i; c >= 0; c--, r++) {
                System.out.print(array[r][c] + " ");
            }
            System.out.println();
        }

        for (int i = 1; i < array.length; i++) {
            for (int c = array.length - 1, r = i; c >= i; c--, r++) {
                System.out.print(array[r][c] + " ");
            }
            System.out.println();
        }
    }
    
    public static void diagonals2(int[][] array) {
        for (int i = 0; i < 2 * array.length - 1; i++) {
            for (int j = 0; j < array.length; j++) {
                for (int k = 0; k < array.length; k++) {
                    if (j + k == i) {
                        System.out.print(array[j][k] + " ");
                    }
                }
            }
            System.out.println();
        }
    }

}
