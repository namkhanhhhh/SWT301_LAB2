// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 *
 * @author bravee06
 */
public class Manager {
    Validation validation=new Validation();
    private List<Student> slist;
    // init method to initial some date of list student 
    public Manager(){
        slist=new ArrayList<>();
    }
    public List<Student> getStudentList(){
        return slist;
    }
    // 1. create student
    public void createStudent(Student e){
        slist.add(e);
    }
    // get student list by name 
    public ArrayList<Student> getStudentListByName(ArrayList<Student> listStudent, String name){   
        ArrayList<Student> listStudentByName = new ArrayList<>();
        // access first element to last element in list student 
        for(Student s : listStudent){
            // compare part name or full name to name_to_find 
            if(s.getName().contains(name)){
                listStudentByName.add(s);
            }
        }
        return listStudentByName;
    }
    // 2. find and sort student
    public void findAndSortStudent(ArrayList<Student> listStudent){
        if(listStudent.isEmpty()){
            System.out.println("The student list is empty");
            return;
        }
        String name = validation.inputString("Input name to find student by name:");
        ArrayList<Student> listStudentByName = getStudentListByName(listStudent,name);
        if(listStudentByName.isEmpty()){
            System.out.println("Student does not exist !!!");
            return;
        }else{
            // hien thi ra danh sach sinh vien duoc tim kiem boi name 
            displayListStudent(listStudentByName, "List Student Sorted By Name: ");
            // Su dung comparator interface de so sanh name 
            Comparator c = new Comparator<Student>(){
                @Override
                public int compare(Student o1, Student o2) {
                    int d = o1.getName().compareTo(o2.getName());
                    
                    if(d > 0) return 1;
                    else if(d < 0) return -1;
                    return 0;
                }
                
            };
            // sort by name su dung lop Collections 
            Collections.sort(listStudent,c);
            
            displayListStudent(listStudent, "List Student Find By Name Above: ");    
        }
    }
    // display list student 
    public void displayListStudent(ArrayList<Student> list, String msg){
        System.out.println(msg);
        int stt = 1;
        System.out.printf("%-10s%-15s%-15s%-15s\n","STT","Student Name","Student Semester","Course Name");
        
        for(Student s : list){
            System.out.printf("%-10d%-15s%-15d%-15s",stt,s.getName(),s.getSemester(),s.getCourseName());
            // xuong dong su dung println
            System.out.println("");
            stt++;
        }
    }
    // method to return Student object by search id 
    public Student searchStudentByID(List<Student> list,String id_to_find){
        // loop access from first student to last student in list 
        for(Student s : list){
            // check id_to_find equal with id student 
            if(s.getId().equals(id_to_find)){
                return s;
            }
        }
        // does not find id in list match id_to_find 
        return null;
    }
    // 3. update or delete student by ID 
    public void updateOrDeleteStudentByID(ArrayList<Student> list){
        // user input id 
        String id_to_find = validation.inputString("Input a id to find student in list: ");
        // get Student object have id to find 
        Student findedStudent = searchStudentByID(list,id_to_find);
        // id does not exist 
        if(findedStudent == null){
            System.out.println("Student does not exist in system");
            
        }
        // have a student 
        else{ 
            // user choose update or delete
            boolean option = validation.checkUpdateDelete("Do you want to update (U) or delete (D) student");
            if(option){
                // update 
                updateStudent(findedStudent,list);
            }else{
                // delete 
                deleteStudent(findedStudent,list);
            }
        }
        // choose a student 
        
    }
    // method update student 
    public void updateStudent(Student findedStudent, ArrayList<Student> list){
        // show information student before update 
        System.out.println("Data student before update: ");
        findedStudent.printData();
        // new line
        System.out.println("");
        // nhap id student
        String id = validation.checkId("Enter id student: ", list);
        // nhap ten student
        String name = validation.inputString("Enter name student: ");
        // nhao hoc ky 
        int semester = validation.checkInt("Enter semester student", 1, 9);
        // nhap course name 
        String courseName = validation.checkCourseName("Enter course name: ");
        
        // update student by setter method 
        findedStudent.setId(id);
        findedStudent.setCourseName(courseName);
        findedStudent.setName(name);
        findedStudent.setSemester(semester);
        
        // show message 
        System.out.println("Update successful");
        
    }
    // method to delete student 
    public void deleteStudent(Student findedStudent, ArrayList<Student> list){
        list.remove(findedStudent);
        System.out.println("Delete successful");
    }
    // 4. display report with total Courses of this student 
    public void displayReport(ArrayList<Student> studentList){
        ArrayList<Report> listReport = getReportList(studentList);
        for(Report report : listReport){
            report.printData();
            System.out.println("");
        }
        
    }
    public ArrayList<Report> getReportList(ArrayList<Student> studentList){
        ArrayList<Report> listReport = new ArrayList<>();
        HashMap<String,Integer> reports = new HashMap<>();
        for(Student student : studentList){
            String key = student.getName() + "-" + student.getCourseName();
            if(reports.containsKey(key)){
                int old_total = reports.get(key);
                reports.put(key,old_total + 1);
            }else{
                reports.put(key, 1);
            }
        }
        Set keys = reports.keySet();
        for(Object key : keys){
           
            String[] data = key.toString().split("-");
            String studentName = data[0];
            String courseName = data[1];
            int totalCourse = reports.get(key);
            Report newReport = new Report(studentName,courseName,totalCourse);
            listReport.add(newReport);
        }
        return listReport;
    }
    
}