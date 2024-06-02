
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Country> lc = new ArrayList<>();
        ManageEastAsiaCountries meac=new ManageEastAsiaCountries();
        //loop until user want to exist
        while (true) {
            int choice = meac.menu();
            switch (choice) {
                case 1:
                    meac.inputCountry(lc);
                    break;
                case 2:
                    meac.printCountry(lc);
                    break;
                case 3:
                    meac.searchByName(lc);
                    break;
                case 4:
                    meac.printCountrySorted(lc);
                    break;
                case 5:
                    return;
            }
        }
    }
}
