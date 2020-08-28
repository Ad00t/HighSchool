import java.util.*;

public class Calculator {

    public Calculator() {
        
    }

    public static void main(String[] args) {
        System.out.println("Enter two integers, space separated: ");
        Scanner console = new Scanner(System.in);
        int i1 = console.nextInt();
        int i2 = console.nextInt();
        console.close();

        Calculator calc = new Calculator();
        System.out.println(calc.add(i1, i2));
        System.out.println(calc.sub(i1, i2));
        System.out.println(calc.mult(i1, i2));
        System.out.println(calc.div(i1, i2));
    }

    public int add(int i1, int i2) {
        for (int i = 0; i < i2; i++) {
            i1++;
        }
        return i1;
    }

    public int sub(int i1, int i2) {
        for (int i = 0; i < i2; i++) {
            i1--;
        }
        return i1;
    }

    public int mult(int i1, int i2) {
        int toAdd = i1;
        i1 = 0;
        for (int i = 0; i < i2; i++) {
            i1 = add(i1, toAdd);
        }
        return i1;
    }

    public int div(int i1, int i2) {
        int orig = i1;
        int result = 0;
        while (i1 >= i2 && result <= orig) {
            i1 = sub(i1, i2);
            result++;
        }
        return result;
    }

}