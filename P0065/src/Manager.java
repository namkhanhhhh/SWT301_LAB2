
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Manager {
    private List<Student> students;

    public Manager() {
        students=new ArrayList<>();
    }
    public List<Student> getStudentsList() {
        return students;
    }
    public void addStudent(Student e){
    students.add(e);
}  
     public void displayInformationStudent(List<Student> students) {
        int i = 0;
        for (Student student : students) {
            System.out.println("----------Student " + (++i) + " info----------");
            System.out.println("Name: " + student.getStudentName());
            System.out.println("Classes: " + student.getClassName());
            System.out.println("AVG: " + student.getAverage());
            System.out.println("Type: " + student.getType());
        }
    }
public HashMap<String, Double> getPercentTypeStudent(List<Student> students) {
        HashMap<String, Double> percentTypeStudent = new HashMap<>();
        int totalStudent = students.size();
        double typeA = 0;
        double typeB = 0;
        double typeC = 0;
        double typeD = 0;
        for (int i = 0; i < totalStudent; i++) {
            switch (students.get(i).getType()) {
                case 'A':
                    typeA++;
                    break;
                case 'B':
                    typeB++;
                    break;
                case 'C':
                    typeC++;
                    break;
                case 'D':
                    typeD++;
                    break;
                default:
                    break;
            }
        }
        percentTypeStudent.put("A", typeA / totalStudent * 100);
        percentTypeStudent.put("B", typeB / totalStudent * 100);
        percentTypeStudent.put("C", typeC / totalStudent * 100);
        percentTypeStudent.put("D", typeD / totalStudent * 100);
        return percentTypeStudent;
    }
    public void displayPercentTypeStudent(List<Student> students) {
        HashMap<String, Double> percentTypeStudent = getPercentTypeStudent(students);
        System.out.println("-------------------------------------");
        for (Map.Entry<String, Double> entry : percentTypeStudent.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "%");
        }
    }
}