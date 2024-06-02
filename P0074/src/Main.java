
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
        Matrix matrix=new Matrix();
        Matrix matrix2=new Matrix();
        Scanner scanner=new Scanner(System.in);
        int choice;
        while (true) {            
            System.out.println("Calculator program: ");
            System.out.println("1.Add 2 matrix: ");
            System.out.println("2.Subtract 2 matrix: ");
            System.out.println("3.Multiplication 2 matrix: ");
            System.out.println("4.Exit");
            choice=scanner.nextInt();
            switch(choice){
                case 1: 
                    System.out.println("ADDITION: ");
                    matrix.input();
                    matrix2.input();
                    matrix.add(matrix2);
                    break;
                case 2:
                    System.out.println("SUBTRACTION: ");
                    matrix.input();
                    matrix2.input();
                    matrix.subtract(matrix2);
                    break;
                case 3:
                    System.out.println("MULTIPLICATION: ");
                    matrix.input();
                    matrix2.input();
                    matrix.multiple(matrix2);
                    break;
                case 4:
                    return;
            }
        }   
    }
}
