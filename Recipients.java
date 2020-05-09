import java.util.*;

public class Recipients {

    public List<String> lines;

    // public static void main(String[] args) {
    //     String mailingList = "Mr. J. Adams\n6 Rose St.\nIthaca, NY 14850\n\nJack S. Smith\n12 Posy Way\nSuite 2A\nGlendale, CA 91203\n\nMs. M.K. Delgado\n2 River Dr.\nNew York, NY 10013";
    //     Recipients r = new Recipients(mailingList);
    //     r.printNames();
    //     System.out.println(r.getAddress(r.lines.get(4)));
    //     System.out.println(r.extractCity(r.lines.get(11)));
    // }

    public Recipients(String mailingList) {
        lines = new ArrayList<>(Arrays.asList(mailingList.split("\n")));
    }

    public String extractCity(String cityZip) {
        return cityZip.substring(0, cityZip.indexOf(","));
    }

    public void printNames() {
        boolean isNextName = true;
        for (String line : lines) {
            if (isNextName) {
                System.out.println(line);
                isNextName = false;
            } else if (line.isEmpty()) {
                isNextName = true;
            }
        }
    }

    public String getAddress(String name) { 
        int nI = lines.indexOf(name);
        String addrLine; int incr = 1;
        String toReturn = "";
        while (!(addrLine = lines.get(nI + incr)).isEmpty()) {
            toReturn += addrLine + "\n";
            incr++;
        }
        return toReturn;
    }

}
