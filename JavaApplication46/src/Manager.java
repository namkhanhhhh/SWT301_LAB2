
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
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
public class Manager {
    Scanner scanner=new Scanner(System.in);
    private List<Worker>wlist;
    private List<SalaryHistory> shList;
    Validation validation=new Validation();
    public Manager() {
        wlist=new ArrayList<>();
        shList=new ArrayList<>();
    }
    
    public void addWorker(){
        String id,name;
        int age;
        double salary;
        String workLocation;
        System.out.println("Enter code: ");
        id=validation.checkCode(1, wlist);
        System.out.println("Enter name: ");
        name=scanner.nextLine();
        System.out.println("Enter Age: ");
        age=validation.checkInt(18, 50);
        System.out.println("Enter Salary: ");
        salary=validation.checkDouble(1, Double.MAX_VALUE);
        System.out.println("Enter work location: ");
        workLocation=scanner.nextLine();
        wlist.add(new Worker(id, name, age, salary, workLocation));
        System.out.println("Update Successfully!");
    }
    public void update(int mode){
       System.out.println("Enter Code: ");
       String id=validation.checkCode(2, wlist);
        System.out.println("Enter Salary: ");
        double money=validation.checkDouble(1, Double.MAX_VALUE);
        Worker worker=validation.worker(id, wlist);
        double update=0;
        String status="";
        if(mode==1){
            update=money+worker.getSalary();
            status="UP";
        }else if (mode==2) {
            if(money>worker.getSalary()){
                update=0;
                status="DOWN";
            }else{
           update=worker.getSalary()-money;
            }   
        }
        worker.setSalary(update);
        shList.add(new SalaryHistory(id,worker.getName(), worker.getAge(),worker.getSalary(),status, java.time.LocalDate.now()));
}
    public void display(){
        if (shList.isEmpty()) {
            System.out.println("NOTHING TO DISPLAY");
        }
        for (SalaryHistory salaryHistory : shList) {
            System.out.println(salaryHistory);
        }
}
}
