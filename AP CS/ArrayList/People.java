package ArrayList;

import java.util.*;

/**
 * ArrayListPart1
 */
public class People {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();

        String line = "";
        while (!(line = console.nextLine()).equals("stop")) {
            StringTokenizer tokenizer = new StringTokenizer(line);
            people.add(new Person(tokenizer.nextToken(), Integer.valueOf(tokenizer.nextToken()), Double.valueOf(tokenizer.nextToken())));
        }

        System.out.println("Original list: \n" + people + "\n");
        Collections.sort(people);
        System.out.println("Sorted list: \n" + people);
        console.close();
    }

}