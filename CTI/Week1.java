import java.util.Scanner;

/**
 * Week1
 */
public class Week1 {

    public static void main(String[] args) {
        
        System.out.println("Hello and welcome.");
        Scanner console = new Scanner(System.in);
        System.out.print("What's your name?");
        String name = console.next();
        if (name.equals("Martin")) {
            System.out.println("That's my name too!");
        }
        System.out.println("Hi " + name);

    }    

}