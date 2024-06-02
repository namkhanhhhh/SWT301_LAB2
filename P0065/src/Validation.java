
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

    public String checkInputString() {
        //loop until user input true value
                while (true) {            
            try {
        String s;
        s=sc.nextLine();
                if (!s.isEmpty()) {
                    return s;
                }else{
                    System.err.println("NOTHING TO DISPLAY!!!");
                }
            } catch (Exception e) {
                System.err.println("ERROR!!!");
            }
        }
    }

    public int checkInputMark(String nameSubject) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result < 0) {
                    System.err.println(nameSubject + " is greater than equal zero");
                    System.out.print(nameSubject + ":");
                    
                }else if (result > 10) {
                    System.err.println(nameSubject + " is less than equal ten");
                    System.out.print(nameSubject + ":");
                }
                else{
                    return result;
                }
            } catch (NumberFormatException ex) {
                System.err.println(nameSubject + " is digit");
                System.out.print(nameSubject + ":");
            }
        }
    }

    public boolean checkYN() {
        while (true) {            
            String s=sc.nextLine();
            if(s.equalsIgnoreCase("y")){
                return true;
            }else if (s.equalsIgnoreCase("n")) {
                return false;
            }else{
                System.err.println("ERROR!!!");
            }
        }
    }
}
