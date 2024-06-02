import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    private static Tree tree = new Tree();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        loadCity();
        loadDistrict();
        loadTown();
        loadCitizen();
        int choice = -1;
        while (choice != 3) {
            System.out.println("1. Thong ke");
            System.out.println("2. Tim cong dan");
            System.out.println("3. Thoat");
            System.out.print("Nhap lua chon: ");
            choice = Integer.parseInt(sc.nextLine().trim());
            switch (choice) {
                case 1:
                    tree.report();
                    break;
                case 2:
                    System.out.print("Nhap so cccd: ");
                    String code = sc.nextLine().trim();
                    tree.findCitizenInformation(code);
                    break;
                case 3:
                    System.out.println("Bye.");
                    return;
                default:
                    System.out.println("Lua chon khong ton tai.");
            }
        }
    }
    private static void loadCity() {
        try (FileInputStream file = new FileInputStream("tinh.txt")) {
            String entry = "";
            int i;
            while ((i = file.read()) != -1) {
                if ((char)i == '\n') {
                    String[] props = entry.split(", ");
                    tree.add(new CityNode(props[0], props[1], null));
                    entry = "";
                }
                else entry += (char)i;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    private static void loadDistrict() {
        try (FileInputStream file = new FileInputStream("huyen.txt")) {
            String entry = "";
            int i;
            while ((i = file.read()) != -1) {
                if ((char)i == '\n') {
                    String[] props = entry.split(", ");
                    tree.add(new DistrictNode(props[0], props[1], props[2], null));
                    entry = "";
                }
                else entry += (char)i;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    private static void loadTown() {
        try (FileInputStream file = new FileInputStream("xa.txt")) {
            String entry = "";
            int i;
            while ((i = file.read()) != -1) {
                if ((char)i == '\n') {
                    String[] props = entry.split(", ");
                    tree.add(new TownNode(props[0], props[1], props[2], null));
                    entry = "";
                }
                else entry += (char)i;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    private static void loadCitizen() {
        try (FileInputStream file = new FileInputStream("dancu.txt")) {
            String entry = "";
            int i;
            while ((i = file.read()) != -1) {
                if ((char)i == '\n') {
                    String[] props = entry.split(", ");
                    tree.add(new CitizenNode(props[0], props[1], props[2], props[3], null));
                    entry = "";
                }
                else entry += (char)i;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
