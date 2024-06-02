
import java.util.ArrayList;
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
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        Management management = new Management();
        Validation validation = new Validation();
        int choice;
        do {
            System.out.println("==============WORKER MANAGEMENT================");
            System.out.println("1. Add worker: ");
            System.out.println("2. Up salary: ");
            System.out.println("3. Down salary: ");
            System.out.println("4. Display all information of worker: ");
            System.out.println("5. Display information salary: ");
            System.out.println("6. Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    String id;
                    String name;
                    int age;
                    double salary;
                    String workLocation;
                    System.out.println("Enter worker ID: ");
                    id = validation.getCode(1, management.getWorkersList());
                    scanner.nextLine();
                    System.out.println("Enter worker name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter worker age: ");
                    age = validation.getInt(18, 50);
                    System.out.println("Enter worker salary: ");
                    salary = validation.getDouble(1, Double.MAX_VALUE);
                    System.out.println("Enter worker location: ");
                    workLocation = scanner.nextLine();
                    management.addWorker(new Worker(id, name, age, salary, workLocation));
                    System.out.println("Đã thêm vào danh sách !");
                    break;
                case 2:
                    System.out.println("Enter Code: ");
                    id = validation.getCode(2, management.getWorkersList());
                    System.out.println("Enter Salary: ");
                    double money = validation.getDouble(1, Double.MAX_VALUE);
                    management.updateSalary(1, id, money);
                    System.out.println("Đã update thành công");
                    break;
                case 3:
                    System.out.println("Enter Code: ");
                    id = validation.getCode(2, management.getWorkersList());
                    System.out.println("Enter Salary: ");
                    money = validation.getDouble(1, Double.MAX_VALUE);
                    management.updateSalary(2, id, money);
                    System.out.println("Đã update thành công");
                    break;
                case 4:
                    management.displayAll();
                    break;
                case 5:
                    management.display();
                    break;
                case 6:
                    return;
            }
        } while (choice != 0);
    }
}
