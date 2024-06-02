
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
        System.out.println("");
        int choice;
        Manager manager=new Manager();
        do {            
            System.out.println("=========Worker Management========");    
            System.out.println("Add Worker: ");
            System.out.println("Up salary: ");
            System.out.println("Down salary:");
            System.out.println("Display Information Salary: ");
            System.out.println("Exit");
            System.out.println("Enter your choice: ");
            choice=scanner.nextInt();
            switch(choice){
            case 1:
                manager.addWorker();
                break;
            case 2:
                manager.update(1);
                break;
            case 3:
                manager.update(2);
                break;
            case 4:
                manager.display();
                break;
            case 5:
                return;
            }
        } while (true);
    }
}
