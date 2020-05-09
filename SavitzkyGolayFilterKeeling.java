import java.util.*;
import java.io.*;
import java.awt.*;

/**
 * SavitzkyGolayFilterKeeling
 */
public class SavitzkyGolayFilterKeeling {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int filter = promptCoeffs(console);
        int width = promptWindowWidth(console);
        console.close();

        int[][] allCoeffs = new int[][] {
            new int[]{  0, 0,-3,12,17,12,-3, 0,  0}, 
            new int[]{  0,-2, 3, 6, 7, 6, 3,-2,  0}, 
            new int[]{-21,14,39,54,59,54,39,14,-21}, 
            new int[]{ 0,  5,-30, 75,131, 75,-30,  5, 0}, 
            new int[]{15,-55, 30,135,179,135, 30,-55,15}, 
            new int[]{ 0, 0, 0,-1,0,1,0,0,0}, 
            new int[]{ 0, 0,-2,-1,0,1,2,0,0}, 
            new int[]{ 0,-3,-2,-1,0,1,2,3,0}, 
            new int[]{-4,-3,-2,-1,0,1,2,3,4}, 
            new int[]{ 0,   0,   1,  -8,0,  8, -1,  0,  0}, 
            new int[]{ 0,  22, -67, -58,0, 58, 67,-22,  0}, 
            new int[]{86,-142,-193,-126,0,126,193,142,-86}
        };
        int[] C = allCoeffs[filter];
        double[] Y = readDataPoints();

        DrawingPanel panel = new DrawingPanel(800,  400);

        // Original
        panel.getGraphics().setColor(Color.RED);
        for (int x = 0; x < 697; x++) {
            panel.getGraphics().drawOval(x, 399 - (int) Math.round(Y[x]), 1, 1);
        }

        // Averaged
        double[] A = new double[697 - width];
        panel.getGraphics().setColor(Color.BLUE);
        for (int x = width / 2; x < 697 - width / 2; x++) {
            double y = Y[x];
            for (int i = 1; i <= width / 2; i++) {
                y += Y[x - i] + Y[x + i];
            }
            A[x - width / 2] = y / (width + 1);
            panel.getGraphics().drawOval(x, 399 - (int) Math.round(A[x - width / 2]), 1, 1);
        }

        // Filtered & Scaled Filtered
        for (int x = 4; x < A.length - 4; x++) {
            double y = C[0]*A[x - 4] + C[1]*A[x - 3] + C[2]*A[x - 2] + C[3]*A[x - 1] + C[4]*A[x] + 
                       C[5]*A[x + 1] + C[6]*A[x + 2] + C[7]*A[x + 3] + C[8]*A[x + 4];
            panel.getGraphics().setColor(Color.GREEN);
            panel.getGraphics().drawOval(x, 399 - (int) Math.round(y), 1, 1);
            panel.getGraphics().setColor(Color.CYAN);
            panel.getGraphics().drawOval(x, 399 - (int) Math.round(y * 4.0), 1, 1);
        }

        // Legend
        panel.getGraphics().setColor(Color.RED);
        panel.getGraphics().drawString("Original", 755, 15);
        panel.getGraphics().setColor(Color.BLUE);
        panel.getGraphics().drawString("Averaged", 755, 30);
        panel.getGraphics().setColor(Color.GREEN);
        panel.getGraphics().drawString(" Filtered", 755, 45);
        panel.getGraphics().setColor(Color.CYAN);
        panel.getGraphics().drawString("  Scaled", 755, 60);

        // Tick Marks
        panel.getGraphics().setColor(Color.BLACK);
        panel.getGraphics().setFont(new Font("Arial", Font.PLAIN, 12));
        for (int y = 359; y >= 0; y -= 40) {
            panel.getGraphics().drawLine(0, y, 5, y);
            panel.getGraphics().drawString(String.valueOf(399 - y), 8, y + 5);
        }
        boolean drawYear = true;
        for (int x = 23; x < 800; x += 24) {
            panel.getGraphics().drawLine(x, 399, x, 394);
            if (drawYear)
                panel.getGraphics().drawString(String.valueOf(1960 + (x - 23) / 12), x - 21, 391);
            drawYear = !drawYear;
        }
        panel.getGraphics().drawString("Filter " + filter, 5, 18);
    }

    public static int promptCoeffs(Scanner console) {
        System.out.println("select Savitsky-Golay filter: ");
		System.out.println("smoothing");
		System.out.println(" quadratic or cubic");
		System.out.println("  0   {  0, 0,-3,12,17,12,-3, 0,  0}");
		System.out.println("  1   {  0,-2, 3, 6, 7, 6, 3,-2,  0}");
		System.out.println("  2   {-21,14,39,54,59,54,39,14,-21}");
		System.out.println(" quartic or quintic");
		System.out.println("  3   { 0,  5,-30, 75,131, 75,-30,  5, 0}");
		System.out.println("  4   {15,-55, 30,135,179,135, 30,-55,15}");
		System.out.println();
		System.out.println("1st derivative");
		System.out.println(" linear or quadratic");
		System.out.println("  5   { 0, 0, 0,-1,0,1,0,0,0}");
		System.out.println("  6   { 0, 0,-2,-1,0,1,2,0,0}");
		System.out.println("  7   { 0,-3,-2,-1,0,1,2,3,0}");
		System.out.println("  8   {-4,-3,-2,-1,0,1,2,3,4}");		
		System.out.println(" cubic or quartic");
		System.out.println("  9   { 0,   0,   1,  -8,0,  8, -1,  0,  0}");
		System.out.println("  10  { 0,  22, -67, -58,0, 58, 67,-22,  0}");
		System.out.println("  11  {86,-142,-193,-126,0,126,193,142,-86}");

        System.out.print("Enter an integer 0 - 11 corresponding to desired filter: ");
        return console.nextInt();
    }
    public static int promptWindowWidth(Scanner console) {
        System.out.print("Window Width (months): ");
        return console.nextInt();
    }

    public static double[] readDataPoints() {
        double[] dataPoints = new double[697];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("KeelingDataSavGol.txt")));
            for (int x = 0; x < 697; x++) {
                dataPoints[x] = 4.0 * (Double.parseDouble(reader.readLine()) - 310.0);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataPoints;
    }

}