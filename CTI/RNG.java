import java.util.Random;

public class RNG {
    
    public static void main(String[] args) {
        
        Random rand = new Random();

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(rand.nextInt(10) + "  ");
            }
            System.out.println();
        }

    }

}
