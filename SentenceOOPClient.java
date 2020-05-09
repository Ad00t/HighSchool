import java.util.*;

/**
 * SentenceOOP
 */
public class SentenceOOPClient {

    public static void main(String[] args) {
        System.out.print("enter sentence: ");
        Scanner console = new Scanner(System.in);
        SentenceOOP soop = new SentenceOOP(console.nextLine());
        console.close();    

        System.out.println(soop.getBlankPositions());
        System.out.println(soop.countWords());
        String[] words = soop.getWords();
        System.out.print("{");
        for (int i = 0; i < words.length - 1; i++) {
            System.out.print(words[i] + ", ");
        }
        System.out.println(words[words.length - 1] + "}");
    }

}

class SentenceOOP {

    public String sentence;

    public SentenceOOP(String sentence) {
        this.sentence = sentence;
    }

    public List<Integer> getBlankPositions() {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                positions.add(i);
            }
        }
        return positions;
    }

    public int countWords() {
        return getBlankPositions().size() + 1;
    }

    public String[] getWords() {
        return sentence.split(" ");
    }

}