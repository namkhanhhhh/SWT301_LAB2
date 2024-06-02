 
import java.util.List;


/**
 *
 * @author thaycacac
 */
public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Validation validation=new Validation();
        while (true) {
            Student studentInfo=new Student();
            studentInfo.input();
            manager.addStudent(studentInfo);
            System.out.print("Do you want to enter more student information? (Y/N): ");
            if (!validation.checkYN()) {
                break;
            }
        }
        manager.displayInformationStudent(manager.getStudentsList());
        manager.displayPercentTypeStudent(manager.getStudentsList());
    }
}