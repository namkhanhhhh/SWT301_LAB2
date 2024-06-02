/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author bravee06
 */
public class Student {

    // declear attributes of student
    private String id, name, courseName;
    private int semester;
    Validation validation = new Validation();
    Manager manager = new Manager();
    // constructor not parameter

    public Student() {
    }

    // constructor have parameter
    public Student(String id, String name, String courseName, int semester) {
        this.id = id;
        this.name = name;
        this.courseName = courseName;
        this.semester = semester;
    }

    // getter and setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void printData() {
        System.out.printf("%-15s%-15d%-15s", this.getName(), this.getSemester(), this.getCourseName());
    }

    public void input() {
        // create student
// nhap id student
        id = validation.checkId("Enter id student: ", manager.getStudentList());
// nhap ten student
         name = validation.inputString("Enter name student: ");
// nhao hoc ky 
         semester = validation.checkInt("Enter semester student", 1, 9);
// nhap course name 
         courseName = validation.checkCourseName("Enter course name: ");
    }
}
