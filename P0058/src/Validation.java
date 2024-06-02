
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
    Scanner scanner=new Scanner(System.in);
    public int getInt(int min,int max){
        while (true) {            
            try {
               int n=Integer.parseInt(scanner.nextLine());
               if(n>=min&&n<=max){
                   return n;
               }else{
                   System.err.println("ERROR!!");
               }
            } catch (NumberFormatException e) {
                System.err.println("ERROR!");
            }
        }
    }
    public String getString(){
        while (true) {            
            try {
        String s;
        s=scanner.nextLine();
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
    public boolean getYN(){
        
        while (true) {            
            String s=scanner.nextLine();
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
