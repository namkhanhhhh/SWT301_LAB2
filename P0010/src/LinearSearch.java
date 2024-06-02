
import java.util.Random;
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
public class LinearSearch {

    public static void main(String[] args) {
        //1.Users run the program, display a screen to ask users to enter a number of array.
        int size = inputNumberOfArray("Enter number of array: ", 0, Integer.MAX_VALUE);
        //2.Display a screen to ask users to enter search number.
        int number = searchNumber("Enter search number: ", 0, Integer.MAX_VALUE);
        //3.Generate random integer in number range for each array element.
        int[] array = getRandomIntergerNumber(size);
        //4.Display the array
        Display(array);
        //5.Display the index of search number in array.
        displayIndex(array, number);
    }
    //1.Users run the program, display a screen to ask users to enter a number of array.

    private static int inputNumberOfArray(String mgs, int min, int max) {
        while (true) {
//try..catch to help users input correct format of number
            try {
//Display a screen to ask users input a number of array.
                System.out.println(mgs);
                Scanner scanner = new Scanner(System.in);
                //create  a string function for user to enter data
                String inputString = scanner.next();
                //convert data from character to number
                int input = Integer.parseInt(inputString);
                //if input bigger than min or smaller than max then return input
                if (input >= min && input <= max) {
                    return input;
                    //if it doesn't satisfy then ask user to re-enter
                } else {
                    System.out.println("You must enter a number from:" + min + " to " + max);
                }
            } catch (NumberFormatException e) {
                //If user enter a string not a number, the program will print to help user know
                System.out.println("You must enter a number");
            }
        }
    }

    //2.Display a screen to ask users to enter search number.
    private static int searchNumber(String sn, int min, int max) {
        while (true) {
//try..catch to help users input correct format of number
            try {
//Display a screen to ask users input a search number.
                System.out.println(sn);
                Scanner scanner = new Scanner(System.in);
                //create  a string function for user to enter data
                String inputString = scanner.next();
                //convert data from character to number
                int number = Integer.parseInt(inputString);
                //if input bigger than min or smaller than max then return input
                if (number >= min && number <= max) {
                    return number;
                }else{
            System.out.println("You must enter a number from:" + min + " to " + max);

                }
            } catch (NumberFormatException e) {
                //If user enter a string not a number, the program will print to help user know
                System.out.println("You must enter a number");
            }
        }
    }

    //3.Generate random integer in number range for each array element.
    private static int[] getRandomIntergerNumber(int size) {
        //initializes an array of the same size as the number of elements entered
        //by the user.
        int[] array = new int[size];
        //instantiate class random
        Random random = new Random();
        //Create a random array with size users input by a loop
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(20);
        }
        return array;
    }

    //4.Display the array
    private static void Display(int[] array) {
        System.out.print("The array: [");
        //Create a loop to iterate through the elements in the array and print it out
        for (int i = 0; i < array.length; i++) {
            //If the array runs out,except for the last element,it will add a","after them
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
                //If the array run out, the last element will ass a "]" after them
            } else {
                System.out.println(array[i] + "]");
            }
        }
    }

    //5.Display the index of search number in array.
    private static void displayIndex(int[] array, int number) {
        int index = linearSearch(array, number);
        if (index == -1) {
            System.out.println("Not found");
        } else {
            System.out.println("Found " + number + " at index: " + index);
        }
    }
    // create a function to find position of number user input  

    private static int linearSearch(int[] array, int number) {
        //Create a loop to iterate over the elements in the array
        for (int i = 0; i < array.length; i++) {
            //if find a number = number user search==>return the index of number
            if (array[i] == number) {
                return i;
            }

        }
        //if can not find the number, return -1
        return -1;
    }
}
