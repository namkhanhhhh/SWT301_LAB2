/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class Mana {
      HashMap<String, Doctor> d = new HashMap<>();
      public void Add(Doctor e){
          d.put(e.id, e);
}
      public void Remove(Doctor e){
         Doctor s = d.remove(e.id);
    if(s == null) {
      System.out.println("Không tìm thấy sinh viên có mã " + e.id);
    } else {
      System.out.println("Đã xóa sinh viên: " + s); 
    }
}
      public Doctor Search(String id ){
         if(d.containsKey(id)) return d.get(id);
           return null;
      }
      public void Update(Doctor e){
          d.replace(e.id, e);
      }
       public void Display(Doctor e){
          System.out.println(e);
      }
}