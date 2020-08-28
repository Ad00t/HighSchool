import java.util.*;

/**
 * SentenceStatic
 */
public class SentenceStatic {

    public static void main(String[] args) {
        System.out.print("Enter a sentence: ");
        Scanner console = new Scanner(System.in);
        String sentence = console.nextLine();
        console.close();    

        System.out.println(getBlankPositions(sentence));
        System.out.println(countWords(sentence));
        String[] words = getWords(sentence);
        System.out.print("{");
        for (int i = 0; i < words.length - 1; i++) {
            System.out.print(words[i] + ", ");
        }
        System.out.println(words[words.length - 1] + "}");
    }

    public static List<Integer> getBlankPositions(String sentence) {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                positions.add(i);
            }
        }
        return positions;
    }

    public static int countWords(String sentence) {
        return getBlankPositions(sentence).size() + 1;
    }

    public static String[] getWords(String sentence) {
        return sentence.split(" ");
    }

}