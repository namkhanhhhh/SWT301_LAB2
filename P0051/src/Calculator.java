
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
public class Calculator {
     Validation validation=new Validation();
     Scanner in = new Scanner(System.in);

    //allow user input number
    public double inputNumber() {
        System.out.print("Enter number: ");
        double number = validation.checkInputDouble();
        return number;
    }

    //allow user calculator normal
    public void normalCalculator() {
        double memory;
        System.out.print("Enter number: ");
        memory = validation.checkInputDouble();
        while (true) {
            System.out.print("Enter operator: ");
            String operator = validation.checkInputOperator();
            if (operator.equalsIgnoreCase("+")) {
                memory += inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("-")) {
                memory -= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("*")) {
                memory *= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("/")) {
                memory /= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("^")) {
                memory = Math.pow(memory, inputNumber());
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("=")) {
                System.out.println("Result: " + memory);
                return;
            }
        }

    }    
    //display result BMI status
    public String BMIStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard.";
        } else if (bmi >= 19 && bmi < 25) {
            return "Standard.";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight.";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat-should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }
    //allow user BMI calculator
    public void BMICalculator() {
        System.out.print("Enter Weight(kg): ");
        double weight = validation.checkInputDouble();
        System.out.print("Enter Height(m): ");
        double height = validation.checkInputDouble();
        double bmi = weight / (height*height);
        System.out.printf("BMI number: %.2f\n", bmi);
        System.out.println("BMI Status: " + BMIStatus(bmi));
    }
}
