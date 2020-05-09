import java.util.*;

public class SnakesAndLaddersSimulator {

    private static final StartToEnd[] objects = {
        new StartToEnd( 4, 14, true ), new StartToEnd( 7, 17, false), 
        new StartToEnd( 9, 31, true ), new StartToEnd(20, 38, true ),
        new StartToEnd(19, 62, false), new StartToEnd(24, 87, false),
        new StartToEnd(28, 84, true ), new StartToEnd(34, 54, false),
        new StartToEnd(40, 59, true ), new StartToEnd(51, 67, true ),
        new StartToEnd(60, 64, false), new StartToEnd(63, 81, true ),
        new StartToEnd(71, 91, true ), new StartToEnd(73, 93, false),
        new StartToEnd(76, 95, false), new StartToEnd(78, 99, false)
    };

    private static final DieRoll die = new DieRoll();

    public static void runGame() {
        boolean hasSomeoneWon = false;
        boolean isP1Turn = true;
        int p1 = 0; int p2 = 0;
        Scanner console = new Scanner(System.in);
        while (!hasSomeoneWon) {
            System.out.println("It's player " + (isP1Turn ? 1 : 2) + "'s turn. Press enter to roll the die.");
            String enter = console.nextLine();
            int roll = die.getNextNumber();
            System.out.println("You roll " + roll + ". You move from " + (isP1Turn ? p1 : p2) + " to " + (isP1Turn ? p1 + roll : p2 + roll) + ". ");
            if (isP1Turn) p1 += roll;
            else p2 += roll;
            boolean canContinueClimbingOrFalling = true;
            while (canContinueClimbingOrFalling) {
                canContinueClimbingOrFalling = false;
                for (StartToEnd o : objects) {
                    if (o.isThisLadder() && ((isP1Turn && p1 == o.getLowerPoint()) || (!isP1Turn && p2 == o.getLowerPoint()))) {
                        if (isP1Turn) p1 = o.getUpperPoint();
                        else p2 = o.getUpperPoint();
                        System.out.println("You climb a ladder from " + o.getLowerPoint() + " to " + o.getUpperPoint());
                        canContinueClimbingOrFalling = true;
                        break;
                    } else if (!o.isThisLadder() && ((isP1Turn && p1 == o.getUpperPoint()) || (!isP1Turn && p2 == o.getUpperPoint()))) {
                        if (isP1Turn) p1 = o.getLowerPoint();
                        else p2 = o.getLowerPoint();
                        System.out.println("You fall down a snake from " + o.getUpperPoint() + " to " + o.getLowerPoint());
                        canContinueClimbingOrFalling = true;
                        break;
                    }
                }
            }
            if ((isP1Turn && p1 >= 100) || (!isP1Turn && p2 >= 100)) {
                hasSomeoneWon = true;
                System.out.println((isP1Turn ? "Player 1" : "Player 2") + " wins!");
            }
            System.out.println();
            isP1Turn = !isP1Turn;
        }
        console.close();
    }

    public static void main(String[] args) {
        runGame();
    }

}

class StartToEnd {

    private final int lowerPoint;
    private final int upperPoint;
    private final boolean isLadder;

    public StartToEnd(int lower, int upper, boolean isL) {
        this.lowerPoint = lower;
        this.upperPoint = upper;
        this.isLadder   = isL;
    }

    public int getLowerPoint() {
        return lowerPoint;
    }

    public int getUpperPoint() {
        return upperPoint;
    }

    public boolean isThisLadder() {
        return isLadder;
    }

}

class DieRoll {

    private Random rand;

    public DieRoll() {
        rand = new Random(1);
    }

    // Returns sum of two die rolls on [1, 6]
    public int getNextNumber() {
        return rand.nextInt(6) + rand.nextInt(6) + 2;
    }
}