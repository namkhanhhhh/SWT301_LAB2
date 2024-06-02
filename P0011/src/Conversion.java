
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
public class Conversion {
    static Scanner sc=new Scanner(System.in);
    static Scanner scs=new Scanner(System.in);  
    int baseInput;
    int baseOutput;
    String value;

    public Conversion() {
    }

    public void BaseInput(){
        int n;
        while(true){
            try{
                System.out.print("Enter base (2/10/16) for input: ");
                n=sc.nextInt();
                if(n==2 || n==10 || n==16)  break;
                else throw new Exception("Enter 2, 10 or 16");
            }catch(Exception e){
                System.err.println("Must input (2/10/16");
            }
        }
        this.baseInput=n;
    }

        public void BaseOutput(){
        int n;
        while(true){
            try{
                System.out.print("Enter base (2/10/16) for output: ");
                n=sc.nextInt();
                if(n==2 || n==10 || n==16)  break;
                else throw new Exception("Enter 2, 10 or 16");
            }catch(Exception e){
                System.err.println(e);
            }
        }
        this.baseOutput=n;
    }
        

        
    public  String Convert(){
        System.out.print("Enter value to convert: ");
        this.value=scs.nextLine();
        int Decimal=Integer.parseInt(value,baseInput);
        switch (baseOutput) {
            case 2:
                return Integer.toBinaryString(Decimal);
            case 10:
                return Integer.toString(Decimal);
            case 16:
                return Integer.toHexString(Decimal);
            }   
        return null;
    } 
}
