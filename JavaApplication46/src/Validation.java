
import java.util.List;
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
public class Validation {
    Scanner scanner=new Scanner(System.in);
    
    public int checkInt(int min, int max){
        while (true) {            
            try {
          int n=Integer.parseInt(scanner.nextLine());
        if(n>min&&n<max){
            return n;
        }else{
            System.err.println("U must enter number from: "+min+" to "+max);
        }      
            } catch (NumberFormatException e) {
            System.err.println("U must enter a number!!!");
            }
        }
    }
    public double checkDouble(double min, double max){
        while (true) {            
            try {
          double n=Integer.parseInt(scanner.nextLine());
        if(n>min&&n<max){
            return n;
        }else{
            System.err.println("U must enter number from: "+min+" to "+max);
        }      
            } catch (NumberFormatException e) {
            System.err.println("U must enter a number!!!");
            }
        }
    }
    public String checkCode(int mode,List<Worker>wlist){
        String s;
        while (true) {            
            s=scanner.nextLine();
            if(!s.isEmpty()){
                if(mode==1&&worker(s, wlist)==null||mode==2&&worker(s, wlist)!=null){
                    break;
                }
            }
            System.err.println("ERROR!!!");
        } 
        return s;
    }
    public Worker worker(String id,List<Worker>wlist){
        for (Worker worker : wlist) {
            if(worker.getId().equals(id)){
                return worker;
            }
        }
        return null;
    }
}
