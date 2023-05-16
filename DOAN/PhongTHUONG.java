package DOAN;

import java.io.IOException;
import java.util.Scanner;

public class PhongTHUONG extends Phong {
    static Scanner sc = new Scanner(System.in);

    protected PhongTHUONG() throws IOException {
        super();
        maLoaiPhong = "N";
        bath = "D:\\OOPJava\\src\\Project\\MenuPhongThuong.txt";
        loaiPhong = "NORMAL";
    }

    public static void main(String[] args) throws IOException {
        PhongTHUONG a = new PhongTHUONG();
        a.menu();
        //a.Add();
        //a.menu();
        a.Filter();
    }

    @Override
    public void menu() throws IOException {
        this.docFile();
        table();
        for (int i = 0; i < soluong; i++) {
            System.out.printf("|%-10s|%-15s|%-15s|%-20d|%-19s|\n", ma[i], maLoaiPhong, loaiPhong, DonGia[i], tt[i]);
        }
        for (int i = 0; i < 85; i++) {
            if (i == 0 || i == 11 || i == 27 || i == 43 || i == 64 || i == 84) System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();
    }

    @Override
    public void tienDichVu(int i) throws IOException {
        // TODO Auto-generated method stub

    }
}