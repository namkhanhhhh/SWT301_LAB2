
import java.util.Arrays;
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
        Scanner scanner=new Scanner(System.in);
        int size,value;
        System.out.println("Enter number of array:");
        size=scanner.nextInt();
        BinarySearch bs=new BinarySearch(size);
        System.out.println("Enter search number:");
        value=scanner.nextInt();
        bs.getRandomIntergerNumber();
        bs.display();
        bs.displayIndex(value);
    }
}
