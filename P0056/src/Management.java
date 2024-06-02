
import java.util.ArrayList;
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
public class Management {
    Scanner scanner=new Scanner(System.in);
    private List<Worker> wList;
    private List<SalaryHistory> shList;
Validation validation=new Validation();
    public Management() {
        wList=new ArrayList<>();
        shList=new ArrayList<>();
    }
     public List<Worker> getWorkersList() {
        return wList;
    }
public void addWorker(Worker e){
    this.wList.add(e);
}   
public void updateSalary(int mode,String id, double money){
        Worker worker=validation.getWorker(id, wList);
        double update=0;
        String status="";
    if (mode==1) {
     update=worker.getSalary()+money;
    status="UP";
    }else if(mode==2){
     if(worker.getSalary()<money){
     update=0;  
     }else{
         update=worker.getSalary()-money;
         status="DOWN";
     }   
    }
    worker.setSalary(update);
    shList.add(new SalaryHistory(id,worker.getName(), worker.getAge(), worker.getSalary(), status, java.time.LocalDate.now()));
}
public void display(){
    if (shList.isEmpty()) {
            System.out.println("NOTHING TO DISPLAY");
            
    }
    for (SalaryHistory salaryHistory : shList) {
        System.out.println(salaryHistory);     
    }
}
public void displayAll(){
    for (Worker worker : wList) {
        if (wList.isEmpty()) {
            System.out.println("NOTHING TO DISPLAY");
        }else{
        System.out.println(worker);
        }
    } 
}
}
