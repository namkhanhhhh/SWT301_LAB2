/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Doctor {
     int avai;
    String id,name, spec;

    public Doctor(String id, String name, String spec,int avai) {
        this.id = id;
        this.avai = avai;
        this.name = name;
        this.spec = spec;
    }

    public Doctor() {
    }

    public String getId() {
        return id;
    }

    public int getAvai() {
        return avai;
    }

    public String getName() {
        return name;
    }

    public String getSpec() {
        return spec;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAvai(int avai) {
        this.avai = avai;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }
     @Override
    public String toString(){
        return id+", "+name+", "+spec+", "+avai;
    }
}
