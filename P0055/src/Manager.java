
import java.util.HashMap;
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
    Map<String, Doctor> d;

    public Manager() {
    d=new HashMap<>();
    }
    public void add(Doctor e){
        d.put(e.code, e);
    }
    public void remove(Doctor e){
        Doctor s=d.remove(e.code);
        if(s == null) {
      System.out.println("Không tìm thấy sinh viên có mã " + e.code);
    } else {
      System.out.println("Đã xóa sinh viên: " + s); 
    }
    }
    public Doctor search(String s){
        if (d.containsKey(s)) {
            return d.get(s);
        }else{
            return null;
        }
    }
    public void update(Doctor e){
        d.replace(e.code, e);
    }
    public void display(Doctor e){
        System.out.println(e.toString());
    }
}
