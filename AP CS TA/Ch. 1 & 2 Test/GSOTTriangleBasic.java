public class GSOTTriangleBasic {

    static final int HEIGHT = 3;

    public static void main(String[] args) {
        for (int i = 1; i <= HEIGHT; i++) {
            drawTriangle(i, HEIGHT - i);
        }
    }

    public static void drawTriangle(int n, int s) {
        drawSegment(n, s, "   /\\   ");
        drawSegment(n, s, "  /  \\  ");
        drawSegment(n, s, " /0o0\"\\ ");
        drawSegment(n, s, "/______\\");
    }

    public static void drawSegment(int n, int s, String k) {
        for (int i = 0; i < s; i++)
            repeat(" ", 4);
        for (int i = 0; i < n; i++)
            System.out.print(k);
        for (int i = 0; i < s; i++)
            repeat(" ", 4);
        System.out.println();
    }

    public static void repeat(String s, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(s);
        }
    }

}
