import java.util.*;

/**
 * Reverse3
 */
public class Reverse3 {

    public static void main(String[] args) {
        System.out.println("\nPlease enter a sequence of integers separated\nby spaces. End the sequence with the sentinel\nvalue 0, followed by a return.\n");    
        
        Scanner console = new Scanner(System.in);
        ArrayList<Integer> original = new ArrayList<>();
        int num;
        while ((num = console.nextInt()) != 0) {
            original.add(Integer.valueOf(num));
        }
        System.out.println("Your original list: " + original + "\n");

        int endIndex = original.size() - (original.size() % 3);
        for (int i = 2; i < endIndex; i += 3) {
            Integer iMinus2 = original.get(i - 2);
            original.set(i - 2, original.get(i));
            original.set(i, iMinus2);
        }
        System.out.println("Your reversed3 list: " + original);
        console.close();
    }

}