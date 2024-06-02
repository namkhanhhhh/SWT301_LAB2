
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
public class Matrix {
    Scanner s=new Scanner(System.in);
    int [][]m;
    int rows,column;

    public Matrix() {
    }

    public Matrix(int[][] m, int rows, int column) {
        this.m = m;
        this.rows = rows;
        this.column = column;
    }

    public int[][] getM() {
        return m;
    }

    public void setM(int[][] m) {
        this.m = m;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
    public void setSize(int rows,int columns){
        this.rows=rows;
        this.column=columns;
        m=new int[rows][columns];
    }
    public void input(){
        System.out.println("Enter row: ");
        rows=s.nextInt();
        System.out.println("Enter column: ");
        column=s.nextInt();
        setSize(rows, column);
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print("matrix["+i+"]["+j+"]: ");
                m[i][j]=s.nextInt();
            }
        }
    }
    public void display()
    {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        } 
    }
    public Matrix add(Matrix matrix2){
        Matrix result=new Matrix();
        result.setSize(rows, column);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                result.m[i][j]=this.m[i][j]+matrix2.m[i][j];
            }
        }
        result.display();
        return result;
    }
    public Matrix subtract(Matrix matrix2){
        Matrix result=new Matrix();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                result.m[i][j]=this.m[i][j]-matrix2.m[i][j];
            }
        }
        result.display();
        return result;
    }
    public Matrix multiple(Matrix matrix2){
        Matrix result=new Matrix();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
               result.m[i][j]=this.m[i][j]*matrix2.m[i][j]; 
            }
        }
        result.display();
        return result;
    }
}
