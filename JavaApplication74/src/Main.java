
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
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("input");
        int x=sc.nextInt();
        valid(x);
    }
    
    public static int valid(int x){
        do {
            try {
             if (x<0&&Character.isDigit(x)==false) {
               throw new NumberFormatException("false");
            }else{
                 return x;
             }
            } catch (NumberFormatException e) {
                throw new NumberFormatException("false");
            }
            
            
        } while (true);
    }
}
