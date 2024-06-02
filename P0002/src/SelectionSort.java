
import java.util.Random;
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
public class SelectionSort {

    public static void main(String[] args) {
        //1. display a screen to ask users to enter a positive decimal number.
        int array_size = inputInt("Enter number of array: ", 0);
        //2. Generate random integer in number range for each array element.
        int[] array = RandomIntegerArray(array_size);
        //3. Display array before
        System.out.println("Unsorted Array: ");
        Display(array);
        //4. Sort array
        sortByBubbleSort(array);
        //5. Display array after sorting
        System.out.println("\nSorted Array: ");
        Display(array);
    }
    //1. display a screen to ask users to enter a positive decimal number.

    private static int inputInt(String mgs, int min) {
        while (true) {
            //Dùng try catch để phân loại và định dạng hướng dẫn cho người dùng nhập vào
            try {
                System.out.println(mgs);
                Scanner sc = new Scanner(System.in);
                String input = sc.next();
                //Định dạng số lượng phần tử là 1 số nguyên
                int inputString = Integer.parseInt(input);
                //Nếu số lượng phần tử<min=0==>Người dùng phải nhập lại
                if (inputString < min) {
                    System.out.println("You need to enter a positive number!");
                    continue;
                }
                return inputString;
// Sử dụng NumberFormatException để định dạng số cho người nhập
            } catch (NumberFormatException e) {
                System.out.println("You need to enter number!");
                continue;
            }
        }
    }
    //2. Generate random integer in number range for each array element.

    private static int[] RandomIntegerArray(int array_size) {
        //Khai báo 1 mảng có độ dài bằng số lượng phần tử người dùng nhâp;
        int[] array = new int[array_size];
        //Tạo lớp random để in ra các số ngẫu nhiên
        Random rd = new Random();
        //Tạo 1 vòng lặp để tạo ra các số ngẫu nhiên
        for (int i = 0; i < array_size; i++) {
            array[i] = rd.nextInt(10);
        }
        //Trả về kết quả
        return array;
    }
    //3. Display array before

    private static void Display(int[] array) {
        System.out.print("[");
        //Tạo loop để hiển thị dãy số
        for (int i = 0; i < array.length; i++) {
            //Nếu các số trong vòng lặp ngoại trừ số cuối cùng xuất hiện sẽ đi với dấu phẩy sau chúng
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i] + "]");
            }
        }
    }
    //4. Sort array

    private static void sortByBubbleSort(int[] array) {
        //Tạo vòng lặp i để chạy qua tất cả các số trong vòng lặp
        for (int i = 0; i < array.length-1; i++) {
            //gắn biến nhỏ nhất cho i
            int min_index = i;
            //Tạo vòng lặp j để tìm ra các số chưa được sắp xếp
            for (int j = i+1; j < array.length; j++) {
                //Nếu số nhỏ hơn giá trị min_index thì số đó sẽ trở thành min_index đến khi nào tìm được số nhỏ nhất
                if (array[j] < array[min_index]) {
                    min_index = j;
                }
            }
            //Sau khi tìm được số nhỏ nhất thì sẽ cho chúng vào mảng đã sắp xếp
            int temp = array[min_index];
            array[min_index] = array[i];
            array[i] = temp;
        }
    }
}
