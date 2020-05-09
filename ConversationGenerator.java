import java.util.*;

/**
 * ConversationAPPractice
 */
public class ConversationGenerator {

    // Contains all 5 starters
    public String[] starters;

    // Contains all 5 enders
    public String[] enders;

    // Contains all 10 questions
    public String[] questions;

    // Contains all 10 acknowldegements
    public String[] acknowledgements;  

    public ConversationGenerator() {
        starters = new String[]{ "Hi", "Hello", "I would like you to answer a few questions", "Good morning", "Howdy" };
        enders = new String[]{ "Bye", "Thank you for participating in this study", "Have a nice afternoon", "See you later", "Until next time" };
        questions = new String[]{ "What is your name?", "How old are you?", "What did you have for breakfast?", "Do you have a middle name?", "Where are your parents?" };
        acknowledgements = new String[]{ "OK, got it!", "Right!", "Are you sure about that?", "Perfect", "Alright", "Indeed", "Is that so?", "Okay", "Great", "Excellent!" };  
    }

    /* Method to retrieve responses and return them in an array */
    public String[] getResponses() {
        String[] responses = new String[10];
        Scanner console = new Scanner(System.in);
        Random rand = new Random();
        System.out.println(starters[rand.nextInt()]);
        for (int i = 0; i < 10; i++) {
            System.out.println(questions[i]);
            responses[i] = console.nextLine();
            System.out.println(acknowledgements[rand.nextInt()]);
        }
        System.out.println(enders[rand.nextInt()]);
        console.close();
        return responses;
    }

}