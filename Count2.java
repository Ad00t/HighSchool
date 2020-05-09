import java.util.*;

/**
 * Count
 */
public class Count2 {

    public static void main(String[] args) {
        System.out.println("\nPlease enter a sequence of strings separated\nby spaces. The end of the sequence must be signified using\nthe sentinel value lastString, followed by a return.\n");

        Scanner console = new Scanner(System.in);
        ArrayList<String> original = new ArrayList<>();
        while (console.hasNext()) {
            original.add(console.next().toLowerCase());
        }
        original.remove("laststring");

        ArrayList<FreqPair> freqPairs = new ArrayList<>();
        for (String s : original) {
            boolean isDuplicate = false;
            for (FreqPair pair : freqPairs) {
                if (pair.string.equals(s)) {
                    pair.freq++;
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                freqPairs.add(new FreqPair(s));
            }
        }
        Collections.sort(freqPairs);

        for (FreqPair pair : freqPairs) {
            System.out.println(pair);
        }

        console.close();
    }

}

class FreqPair implements Comparable<FreqPair> {

    public String string;
    public int freq = 1;

    public FreqPair(String string) {
        this.string = string;
    }

    @Override
    public int compareTo(FreqPair o) {
        if (freq == o.freq) {
            return string.compareTo(o.string);
        } else {
            return freq - o.freq;
        }
    }

    @Override
    public String toString() {
        return string + " " + freq;
    }

}