import java.util.*;

/**
 * Mice2
 */
public class Mice2 {

    private static boolean foundPath = false;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter number of rows and columns, then enter map.");
        int r = console.nextInt();
        int c = console.nextInt();
        char[][] grid = new char[r][c];
        for (int i = 0; i < r; i++) {
            grid[i] = console.next().toCharArray();
        }

        floodFill(grid, 0, 0, r, c);
        System.out.println(foundPath ? "YES" : "NO");

        console.close();
    }

    private static void floodFill(char[][] grid, int r, int c, int rows, int cols) {
        if (grid[r][c] == 'M') {
            foundPath = true;
        } else {
            grid[r][c] = 'S';
            if (r + 1 <= rows - 1 && grid[r + 1][c] != '+' && grid[r + 1][c] != 'S') {
                floodFill(grid.clone(), r + 1, c, rows, cols);
            }
            if (c + 1 <= cols - 1 && grid[r][c + 1] != '+' && grid[r][c + 1] != 'S') {
                floodFill(grid.clone(), r, c + 1, rows, cols);
            }
            if (r - 1 >= 0 && grid[r - 1][c] != '+' && grid[r - 1][c] != 'S') {
                floodFill(grid.clone(), r - 1, c, rows, cols);
            }
            if (c - 1 >= 0 && grid[r][c - 1] != '+' && grid[r][c - 1] != 'S') {
                floodFill(grid.clone(), r, c - 1, rows, cols);
            }
        }
    }
    
}