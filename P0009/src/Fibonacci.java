/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("The 45 sequence fibonacci:");
        for (int i = 0; i <= 45; i++) {
            System.out.print(arrayOfFibonacci(i)+", ");
        }
    }
    
    public static int arrayOfFibonacci(int n){
       if(n<2){
           return n;
       }else{
           return arrayOfFibonacci(n-2)+arrayOfFibonacci(n-1);
       }
}
}
