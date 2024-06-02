/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Contract {
 private int id;
 private String name;
 private String firstName;
 private String lastNameString;
 private String group;
 private String address;
 private String phone;

    public Contract() {
    }

    public Contract(int id, String name, String firstName, String lastNameString, String group, String address, String phone) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.lastNameString = lastNameString;
        this.group = group;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNameString() {
        return lastNameString;
    }

    public void setLastNameString(String lastNameString) {
        this.lastNameString = lastNameString;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
 public void input(){
 }
}
