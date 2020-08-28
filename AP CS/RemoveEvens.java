import java.io.*;
import java.util.*;

/**
 * RemoveEvens
 */
public class RemoveEvens {

    public static void main(String[] args) {
        System.out.println("Removes strings of even length from an array.");
        Scanner console = new Scanner(System.in);
        System.out.print("Enter filename for file containing strings: ");
        String fileName = console.next();
        System.out.println("Enter two indices for range of odd words to be printed out: ");
        int i1 = console.nextInt();
        int i2 = console.nextInt();

        try {
            LinkedList<String> list = new LinkedList<>();
            BufferedReader bR = new BufferedReader(new FileReader(fileName)); 
            String nextLine;
            while ((nextLine = bR.readLine()) != null) {
                StringTokenizer t = new StringTokenizer(nextLine);
                while (t.hasMoreTokens())
                    list.add(t.nextToken());
            }
            System.out.println("initial list.size(): " + list.size());
    
            Iterator<String> iter = list.iterator();
            while (iter.hasNext()) {
                if (iter.next().length() % 2 != 1)
                    iter.remove();
            }
            System.out.println("final   list.size(): " + list.size());

            for (int i = i1; i <= i2; i++) {
                System.out.println(list.get(i));
            }
            bR.close();
            console.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}