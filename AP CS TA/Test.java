/**
 * Test
 */
public class Test {

    public static void main(String[] args) {

        while (/* condition 1*/) {
            if (/* condition 2 */) {
                // If condition 2 is true,
                // go to the next iteration
                break;
            } else {
                // If condition 2 wasn't true,
                // execute this code block
                // then go to the next iteration
            }
        }

        for (int i = 0; i < 10; i++) {
            // Execute this code block
            if (/* condition */) {
                // If condition is true,
                // go to the next iteration
                // (i += 1 and code block #1
                // is being executed)
                continue;
            }
            // If condition was not true,
            // execute this code block
            // then go to the next iteration
        }

    }

}