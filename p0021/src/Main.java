/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.Scanner;

/**
 * TRONG CLASS MAIN THÌ MÌNH KHÔNG ĐƯỢC CODE Ở TRONG CHỈ ĐƯỢC GỌI HÀM, VÀ KHAI
 * CÁC BIẾN
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Validation validation = new Validation();
        Manager manager = new Manager();
        ArrayList<Student> listStudent = new ArrayList<>();
        int choice;
        // loop use to allow user select option till to user input option 5 
        while (true) {
            // show menu to select choice option 
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Student studentInfo = new Student();
                    while (true) {
                        studentInfo.input();
                        manager.createStudent(studentInfo);
                        // declear length of list student 
                        if (manager.getStudentList().size() > 10) {
                            if (!validation.checkYesNo("Do you want to continue (Y/N) ")) {
                                break;
                            }
                        }
                        else {
                            System.out.println("Add Student Success !");
                        }
                    }
                case 2:
                    // find and sort
                    manager.findAndSortStudent(listStudent);
                    break;
                case 3:
                    // update / delete student
                    manager.updateOrDeleteStudentByID(listStudent);
                    break;
                case 4:
                    // report student
                    manager.displayReport(listStudent);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("ERROR!!!");
            }
        }
    }
}
