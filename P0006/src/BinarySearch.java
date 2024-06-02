
import java.util.Arrays;
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
public class BinarySearch {

    int[] array;

    public BinarySearch(int size) {
        array=new int[size];
    }
    

    //3.Generate random integer in number range for each array element.
    public void getRandomIntergerNumber() {
        Random random = new Random();
        //Create a random array with size users input by a loop
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(20);
        }
        Arrays.sort(array);
        
    }
            //4.Sort array
public void  display(){
    System.out.print("Sorted array: [");
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.println(array[i] + "]");
            }
        }
    }

public int binarySearch(int value){
    int left=0;
    int right=array.length-1;
        

   while(left<=right){
    int mid=(left+right)/2;
    if(value==array[mid]){
        return mid;
    }else if (value<array[mid]) {
          right=mid-1;
    }else{
         left=mid+1;
    }
}
        return -1;
}
public void displayIndex(int value){
    int index=binarySearch(value);
    if(index==-1){
        System.out.println("Can not find the number!");
    }else{
        System.out.println("Found "+value+" at index "+index);
    }
}
}
