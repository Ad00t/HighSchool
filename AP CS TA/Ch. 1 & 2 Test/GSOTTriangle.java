import java.util.Scanner;

public class GSOTTriangle {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter height: ");
        int height = console.nextInt();
        console.close();

        for (int h = 0; h < height; h++) {
            for (int row = 0; row < 4; row++) {
                System.out.print(repeat(" ", 4 * (height - h) - 1 - row));
                for (int i = 1; i <= h * 2 + 1; i++) {
                    if (i % 2 == 1) {   
                        System.out.print("/");
                        if (row == 2)
                            System.out.print("0o0\"");
                        else if (row != 3)
                            System.out.print(repeat(" ", row * 2));
                        else
                            System.out.print(repeat("_", 6));
                        System.out.print("\\");
                    } else {
                        System.out.print(repeat(" ", 6 - (row * 2)));
                    }
                }
                System.out.println();
            }
        }
    }

    public static String repeat(String r, int n) {
        String str = "";
        for (int i = 0; i < n; i++) str += r;
        return str;
    }

}