
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Step 1: Ask user to enter content
        System.out.println("Enter your content:");
        String str = getString();
        // Create an instance of WordCharacterCounter
        Counter counter = new Counter(str);

        // Step 2: Count and display number of words
        counter.countAndDisplayNumberOfWords();

        // Step 3: Count and display number of characters
        counter.countAndDisplayNumberOfCharacters();
    }

    private static String getString() {
        Scanner sc = new Scanner(System.in);
        String str;
        do {
            str = sc.nextLine();
            if (!str.isEmpty()) {
                break;
            } else {
                System.out.println("Empty input! Try again!");
            }
        } while (true);
        return str;
    }
}

