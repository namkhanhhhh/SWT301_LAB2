
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
public class Validation {

    Scanner scanner = new Scanner(System.in);

    public Validation() {
    }
    

    public int getInt(int min, int max) {
        int n;
        while (true) {
            try {
                n = Integer.parseInt(scanner.nextLine());
                if (n >= min && n <= max) {
                    return n;
                }else{
                    System.err.println("Please enter an integer number in range from "+min+" to "+max);
                }
            } catch (NumberFormatException e) {
                System.err.println("Please enter an integer number in range from "+min+" to "+max);
            }
        }
    }

    public double getDouble(double min, double max) {
        double n;
        while (true) {
            try {
                n = Integer.parseInt(scanner.nextLine());
                if (n >= min && n <= max) {
                    return n;
                }else{
                    System.err.println("Please enter an integer number in range from "+min+" to "+max);
                }
            } catch (NumberFormatException e) {
                System.err.println("Please enter an integer number in range from "+min+" to "+max);
            }
        }
    }

    public String getCode(int mode, List<Worker> wList) {
        String s;
        while (true) {
            s = scanner.nextLine();
            if (!s.isEmpty()) {
                if (mode == 1 && getWorker(s, wList)==null || mode == 2 && getWorker(s, wList)!=null) {
                    break;
                }
            }
            System.err.println("Error!");
        }
        return s;
    }

    public Worker getWorker(String id, List<Worker> wList) {
        for (Worker worker : wList) {
            if (worker.getId().equals(id)) {
                return worker;
            }
        }
        return null;
    }
}
 