import java.util.*;

/**
 * Permute
 */
public class Permute {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);   
        System.out.println("Input string: "); 
        String original = console.nextLine();

        TreeSet<String> permutations = new TreeSet<>();
        permute(original.toCharArray(), permutations, 0);
        for (String s : permutations) {
            System.out.println(s);
        }
        console.close();
    }

    public static void permute(char[] arr, TreeSet<String> permutations, int cI) {
        if (cI == arr.length - 1) {
			permutations.add(String.valueOf(arr));
		}
		for (int i = cI; i < arr.length; i++) {
			swap(arr, cI, i);
			permute(arr, permutations, cI + 1);
			swap(arr, cI, i);
		}
    }

    public static void swap(char[] ch, int i, int j) {
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
	}

}