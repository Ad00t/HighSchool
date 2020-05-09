import java.util.Scanner;

/**
 * BackTrackTravel
 */
public class BackTrackTravel {

    private static int numMoves = 0;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter (x, y) coordinates as two integers separated by a space: ");

        explore(console.nextInt(), console.nextInt(), 0, 0, "");
        System.out.println("Number of paths = " + numMoves);
        console.close();
    }

    private static void explore(int dX, int dY, int cX, int cY, String path) {
        if (cX == dX && cY == dY) {
            System.out.println("moves:" + path);
            numMoves++;
        } else if (cX <= dX && cY <= dY) {
            explore(dX, dY, cX, cY + 1, path + " N");
            explore(dX, dY, cX + 1, cY + 1, path + " NE");
            explore(dX, dY, cX + 1, cY, path + " E");
        }
    }

}