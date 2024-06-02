/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author bravee06
 */
public class Validation {
    // declear Scanner class to input field 
    Scanner sc = new Scanner(System.in);
    
    public String inputString(String msg) {
        // vong lap su dung de nguoi dung nhap den khi dung 
        while (true) {
            // allow user input a string 
            System.out.println(msg);
            String input = sc.nextLine();

            // input == null or do dai = 0 => rong 
            if (input == null || input.length() == 0) {
                // error
                System.err.println("Must input a string not empty !!!");
                System.out.println("Please enter again!");
                continue;
            }
            return input;
        }
    }

    // kiem tra so nguyen nam tu min den max 
    public int checkInt(String msg, int min, int max) {
        // vong lap su dung de nguoi dung nhap den khi dung 
        while (true) {

            // allow user input a string 
            String input_raw = inputString(msg);

            try {
                // loi nhap sai dinh dang so
                int input = Integer.parseInt(input_raw);
                // loi nhap ngoai range cho phep
                if (input < min || input > max) {
                    System.err.println("Must input a number from " + min + "to " + max);
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {

                System.err.println("Must enter a number");
                continue;
            }

        }
    }

    // kiem tra id bi trung hay khong 
    public String checkId(String msg, List<Student> slist) {

        while (true) {
            // khai bao bien co de kiem tra xem co trung hay khong, neu trung thi flag = 1 
            int flag = 0;
            // NHAP ID DE CHECK 
            String id = inputString(msg);
            // VONG LAP SU DUNG DE TRUY CAP TU HOC SINH DAU TIEN DEN HOC SINH CUOI CUNG 
            for (Student item : slist) {
                if (item.getId().equals(id)) {
                    System.err.println("Id existed!!Please enter again");
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                continue;
            }
            return id;
        }

    }

    // kiem tra ten khoa hoc 
    public String checkCourseName(String msg) {

        // vong lap su dung de yeu cau nguoi dung nhap den khi dung khoa hoc 
        while (true) {

            String courseName = inputString(msg);
            if (!(courseName.equals("Java") || courseName.equals(".Net") || courseName.equals("C/C++"))) {
                System.err.println("Course name must be one in three course below: Java, .Net, C/C++");
                continue;
            }
            return courseName;
        }
    }

    // check truong dung hoac sai 
    public boolean checkYesNo(String msg) {

        while (true) {
            String input = inputString(msg);
            if (input.equalsIgnoreCase("Y")) {
                return true;
            } else if (input.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.err.println("Must input Y or N to select option");
                continue;
            }
        }
    }

    // check update and delete input 
    public boolean checkUpdateDelete(String msg) {
        while (true) {
            String input = inputString(msg);
            if (input.equalsIgnoreCase("U")) {
                return true;
            } else if (input.equalsIgnoreCase("D")) {
                return false;
            } else {
                System.err.println("Must input U or D to select option");
            }
        }
    }

}
