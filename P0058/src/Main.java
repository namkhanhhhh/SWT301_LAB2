
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        Dictionary d = new Dictionary();
        Validation validation = new Validation();
        int choice;
        while (true) {
            System.out.println("1. Add Word");
            System.out.println("2. Delete Word");
            System.out.println("3. Translate");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter English: ");
                    String eng = validation.getString();
                    System.out.println("Enter VNE: ");
                    String vi = validation.getString();
                    if (d.addWord(eng, vi)==true) {
                        System.out.println("Add Successful!");
                    } else {
                        System.out.println("Word already exists, do you want to continue (Y/N)?");
                        if (validation.getYN()) {       
                            d.addWord(eng, vi);
                            System.out.println("Add Successful!");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter English: ");
                    String wordToDelete = validation.getString();
                    if (d.removeWord(wordToDelete)==true) {
                        System.out.println("Word Removed!");
                    } else {
                        System.out.println("Word not found!");
                    }
                    break;
                case 3:
                    System.out.println("Enter English: ");
                    String wordToTranslate = validation.getString();
                    String translatedWord = d.translate(wordToTranslate);
                    if (translatedWord != null) {
                        System.out.println("Vietnamese: " + translatedWord);
                    } else {
                        System.out.println("Word not found!");
                    }
                    break;
                case 4:
                    return;
            }
        }
    }
}
