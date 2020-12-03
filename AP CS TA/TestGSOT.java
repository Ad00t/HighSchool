public class TestGSOT {
    
    public static void main(String[] args) {
        triangle();
        System.out.println();
        triangle(); triangle();
        System.out.println();
        triangle(); triangle(); triangle();
    }

    public static void triangle() {
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 4 - i; j++) {
                System.out.print(" ");
            }
            System.out.print("/");
            for (int j = 1; j <= 2 * i - 2; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println(" /0o0\"\\ ");
        System.out.print("/______\\");
    }

}
