import java.util.*;
import java.io.*;
import java.awt.*;

/**
 * SavitzkyGolayFilterTest
 */
public class SavitzkyGolayFilterTest {

    public static void main(String[] args) {
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
        int filter = promptCoeffs();
        int[] C = allCoeffs[filter];
        double[] Y = generateDataPointsFile();

        DrawingPanel panel = new DrawingPanel(800,  400);

        // Original
        panel.getGraphics().setColor(Color.RED);
        for (int x = 0; x < 800; x++) {
            panel.getGraphics().drawOval(x, 399 - (int) Math.round(Y[x]), 1, 1);
        }

        // Filtered
        panel.getGraphics().setColor(Color.BLUE);
        for (int x = 4; x < 796; x++) {
            double y = C[0]*Y[x - 4] + C[1]*Y[x - 3] + C[2]*Y[x - 2] + C[3]*Y[x - 1] + C[4]*Y[x] + 
                       C[5]*Y[x + 1] + C[6]*Y[x + 2] + C[7]*Y[x + 3] + C[8]*Y[x + 4];
            if (filter == 8) y *= 4;
            panel.getGraphics().drawOval(x, 399 - (int) Math.round(y), 1, 1);
        }

        // Legend
        panel.getGraphics().setColor(Color.RED);
        panel.getGraphics().drawString("Original", 753, 15);
        panel.getGraphics().setColor(Color.BLUE);
        panel.getGraphics().drawString("Filtered", 755, 30);

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

    public static int promptCoeffs() {
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
        Scanner console = new Scanner(System.in);
        int index = console.nextInt();
        console.close();
        return index;
    }

    public static double[] generateDataPointsFile() {
        // y = 12(x/150)^2 - 5e^(-((x-400)/20)^2)
        double[] dataPoints = new double[800];
        try {
            FileWriter writer = new FileWriter(new File("ParabolaPlusGaussian.txt"));
            for (int x = 0; x < 800; x++) {
                dataPoints[x] = 12.0 * Math.pow(x / 150.0, 2) - 5.0 * Math.pow(Math.E, -Math.pow((x - 400.0) / 20.0, 2));
                writer.write(x + " " + dataPoints[x] + "\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataPoints;
    }

}