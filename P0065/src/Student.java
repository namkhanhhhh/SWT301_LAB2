
/**
 *
 * @author thaycacac
 */
public class Student {

    private String studentName;
    private String className;
    private double math;
    private double physical;
    private double chemistry;
    private double average;
    private char type;
    Validation validation=new Validation();
    public Student() {
    }

    public Student(String studentName, String className, double math, double physical, double chemistry, double average, char type) {
        this.studentName = studentName;
        this.className = className;
        this.math = math;
        this.physical = physical;
        this.chemistry = chemistry;
        this.average = average;
        this.type = type;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getPhysical() {
        return physical;
    }

    public void setPhysical(double physical) {
        this.physical = physical;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }
public void input(){
                System.out.print("Name: ");
            studentName = validation.checkInputString();
            System.out.print("Classes: ");
            className = validation.checkInputString();
            System.out.print("Maths: ");
            math = validation.checkInputMark("Maths");
            System.out.print("Chemistry: ");
            chemistry = validation.checkInputMark("Chemistry");
            System.out.print("Physics: ");
            physical = validation.checkInputMark("Physics");
            average = (math + chemistry + physical) / 3;
            if (average > 7.5) {
                type = 'A';
            } else if (average >= 6 && average <= 7.5) {
                type = 'B';
            } else if (average >= 4 && average < 6) {
                type = 'C';
            } else {
                type = 'D';
            }
}
}