import java.util.*;

/**
 * CharactersOnGrid
 */
public class CharactersOnGrid {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        boolean[][] grid = new boolean[n][n];

        floodFill(grid, 0, n / 2);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) System.out.print("C");
                else System.out.print("-");
            }
            System.out.println();
        }
        console.close();
    }

    private static void floodFill(boolean[][] grid, int r, int c) {
        grid[r][c] = true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                fillShort(i, j, grid, r, c);
            }
        }
    }

    private static void fillShort(int rTarg, int cTarg, boolean[][] grid, int cR, int cC) {
        if (rTarg >= 0 && cTarg >= 0 && rTarg < grid.length && cTarg < grid.length && !grid[rTarg][cTarg] && !doesThreaten(grid, cR, cC, rTarg, cTarg))
            floodFill(grid, rTarg, cTarg);
    }

    private static boolean doesThreaten(boolean[][] grid, int cR, int cC, int r, int c) {
        for (int i = 0; i < grid.length; i++) {
            if (c != i && grid[r][i]) return true;
            if (r != i && grid[i][c]) return true;
            if (i != 0 && r - i >= 0 && c - i >= 0 && grid[r - i][c - i]) return true;
            if (i != 0 && r + i < grid.length && c + i < grid.length && grid[r + i][c + i]) return true;
        }
        return false;
    }
}