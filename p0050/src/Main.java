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
        //dispaly menu
        Manager manager = new Manager();
        Validation validation = new Validation();
        int choice;

        //loop until user want to exit
        while (true) {
            System.out.println("1. Calculate Superlative Equation");
            System.out.println("2. Calculate Quadratic Equation");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = validation.checkInputIntLimit(1, 3);
            switch (choice) {
                case 1:
                    manager.superlativeEquation();
                    break;
                case 2:
                    manager.quadraticEquation();
                    break;
                case 3:
                    return;
            }
        }
    }
}
