/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int k;
        Mana h = new Mana();
        Scanner sc = new Scanner(System.in);
        // TODO code application logic here
        do {

            System.out.println("1. Add");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Search");
            System.out.println("5. Exit");
            System.out.println("Enter 1 option: ");
            k = Integer.parseInt(sc.nextLine());
            switch (k) {
                case 1:
                    String newCode;
                    String newName;
                    do {
                        System.out.println("Enter ID: ");
                        newCode = sc.nextLine();
                    } while (h.Search(newCode) != null);
                    System.out.println("Enter name: ");
                    newName = sc.nextLine();
                    System.out.println("Enter Specialization: ");
                    String nspecial = sc.nextLine();
                    System.out.println("Enter Availability: ");
                    int avai = Integer.parseInt(sc.nextLine());
                    h.Add(new Doctor(newCode, newName, nspecial, avai));
                    System.out.println("infor of doctor has been added.");
                    break;
                case 2:
                    do {
                        System.out.println("Enter ID: ");
                        newCode = sc.nextLine();
                    } while (h.Search(newCode) == null);
                    Doctor i = h.Search(newCode);
                    System.out.println("Update name: ");
                    newName = sc.nextLine();
                    i.setName(newName);
                    System.out.println("Update Specialization: ");
                    String newspe = sc.nextLine();
                    i.setSpec(newspe);
                    System.out.println("Update Availability: ");
                    int newavai = Integer.parseInt(sc.nextLine());
                    i.setAvai(newavai);
                    h.Update(i);
                    System.out.println("infor of doctor has been updated.");
                    break;
                case 3:
                    String newCode3;
                    do {
                        System.out.println("Enter ID that you wana remove: ");
                        newCode3 = sc.nextLine();
                    } while (h.Search(newCode3) == null);
                    h.Remove(h.Search(newCode3));
                    break;
                case 4:
                    String newCode4;
                    do {
                        System.out.println("Enter ID that you wana search: ");
                        newCode4 = sc.nextLine();
                    } while (h.Search(newCode4) == null);
                    Doctor y = h.Search(newCode4);
                    System.out.println(y.toString());
                    break;
                case 5:
                    return;

            }
        } while (k != 5);
    }
}
