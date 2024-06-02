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
        Validation validation=new Validation();
        Calculator calculator=new Calculator();
        int choice;
        while (true) {  
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        choice = validation.checkInputIntLimit(1, 3);   
            switch (choice) {
                case 1:
                    calculator.normalCalculator();
                    break;
                case 2:
                    calculator.BMICalculator();
                    break;
                case 3:
                    return;
            }
        }

    }
}
