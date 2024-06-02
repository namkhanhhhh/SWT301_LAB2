import java.util.Random;
import java.util.Scanner;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class InsectionSort {

    public static void main(String[] args) {
        //1.	Users input a positive decimal number.
        int size_array=inputInt("Enter number of array: ",0);
        //2.	Generate random integer in number range for each array element.
        int[] size=RandomIntegerArray(size_array);
        //3.	Display array before
        System.out.print("Unsorted array: ");
        Display(size);
        //4.	Sort array by Insection sort
        Sort(size);
        //5.    Display array after use Insection Sort
        Display(size);
    }
    //1.Users input a positive decimal number.
private static int inputInt(String mgs, int min){
   while(true){
       try{
    System.out.println(mgs);
    Scanner sc =new Scanner(System.in);
    String inputString=sc.next();
    int input=Integer.parseInt(inputString);
    if(input<min){
        System.out.println("You must enter a positive number !");
        continue;
    }
    return input;
       }catch(NumberFormatException e){
           System.out.println("You must enter a positive number!");
       }
}
}
  //2.	Generate random integer in number range for each array element.
private static int[] RandomIntegerArray(int size_array){
    int[]size=new int[size_array];
    Random rd=new Random();
    for(int i=0;i<size_array;i++){
        size[i]=rd.nextInt(50);
    }
        return size;
}
        //3.	Display array before
private static void Display(int[] size){
    System.out.print("[");
    for(int i=0;i<size.length;i++){
        if(i<size.length-1){
            System.out.print(size[i]+", ");
        }else{
            System.out.print(size[i]+"]");
        }
    }
}
        //4.	Sort array by Insection sort
private static void Sort(int[] size){
    for(int i=2;i<size.length;i++){
        int temp=size[i];
        for(int j=1;j<size.length;j++){
            while(j>=0 && size[j]<temp){
                size[j]=size[j+1];
                j--;
            }
             size[j+1]=temp;
            }
        }
    }
}

