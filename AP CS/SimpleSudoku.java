import java.util.*;

public class SimpleSudoku {

    private static int[][] board = new int[9][9];

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            readLine(console.next(), console.nextInt());
        }
        console.close();

        System.out.println(isBoardValid() ? "1" : "0");
    }

    // Adds a row to the board at the specified row
    private static void readLine(String line, int row) {
        for (int i = 0; i < 9; i++) {
            board[row - 1][i] = Integer.valueOf("" + line.charAt(i));
        }
    }

    // Checks if board is valid or not
    private static boolean isBoardValid() {
        for (int i = 0; i < 9; i++) {
            boolean[] rowOccupancy = new boolean[9];
            boolean[] colOccupancy = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (rowOccupancy[board[i][j] - 1] || colOccupancy[board[j][i] - 1]) return false;
                rowOccupancy[board[i][j] - 1] = true;
                colOccupancy[board[j][i] - 1] = true;
            }
        }
        return true;
    }
    
}