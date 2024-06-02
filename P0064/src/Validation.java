
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    Scanner sc = new Scanner(System.in);
    String PHONE_VALID = "^[0-9]{10}$";
    String EMAIL_VALID = "^[A-Z0-9a-z]+@[A-Za-z0-9]+\\.[A-Za-z]{2,4}$";

    public String checkInputString() {
        //loop until user input true value
        while (true) {
            String result = sc.nextLine();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }
    public String checkInputPhone() {
        while (true) {
            try {
                int phoneCheck = Integer.parseInt(checkInputString());
                String resultCheck = String.valueOf(phoneCheck);
                if (resultCheck.matches(PHONE_VALID)) {
                    return resultCheck;
                } else {
                    System.err.println("Phone number must be 10 digits");
                }
            } catch (NumberFormatException ex) {
                System.out.print("Phone number: ");
                System.err.println("Phone number must be number");
            }
        }
    }

    public String checkInputDate() {
        while (true) {
            try {
                String dateCheck = checkInputString();
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateCheck);
                return dateCheck;
            } catch (ParseException e) {
                System.out.print("Date: ");
                System.err.println("Date to correct format(dd/MM/yyyy)");
            }
        }
    }

    public String checkInputEmail() {
        while (true) {
            String emailCheck = checkInputString();
            if (emailCheck.matches(EMAIL_VALID)) {
                return emailCheck;
            } else {
                System.err.println("Email must be correct format");
                System.out.print("Email: ");
            }
        }
    }
}
