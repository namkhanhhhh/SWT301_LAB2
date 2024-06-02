
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN
 */
public class Validation {
    String VALID_PHONE = "[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}"
            + "|[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ a-z0-9]+";
    Scanner sc = new Scanner(System.in);
    public String checkInputString() {
        while (true) {
            String s;
            s = sc.nextLine();
            if (!s.isEmpty()) {
                return s;
            } else {
                System.err.println("NOTHING TO DISPLAY!!!");
            }
        }
    }
    public int checkInt(int min, int max) {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                String inputString = sc.next();
                int input = Integer.parseInt(inputString);
                if (input < min) {
                    System.out.println("You must enter a positive number !");
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.println("You must enter a positive number!");
            }
        }
    }

    public boolean checkYN() {
        while (true) {
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("y")) {
                return true;
            } else if (s.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.err.println("ERROR!!!");
            }
        }
    }
}
