
/**
 *
 * @author thaycacac
 */
public class Main {
    public static void main(String[] args) {
        Validation validation=new Validation();
        System.out.print("Phone number: ");
        String phone = validation.checkInputPhone();
        System.out.print("Date: ");
        String date = validation.checkInputDate();
        System.out.print("Email: ");
        String email = validation.checkInputEmail();
    }
}