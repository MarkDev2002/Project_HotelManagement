package DOAN;

import java.util.Scanner;
import java.io.IOException;

public class DichVuAnUong extends DichVu {
    static Scanner sc = new Scanner(System.in);

    protected DichVuAnUong() throws IOException {
        super();
        maLoaiDichVu = "A";
        bath = "D:\\OOPJava\\src\\Project\\MenuThucAn.txt";
        loaiDichVu = "AN UONG";
    }

    public static void main(String[] args) throws IOException {
        DichVuAnUong a = new DichVuAnUong();
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
            System.out.printf("|%-10s|%-25s|%-15s|%-15s|%-20d|%-19s|\n", ma[i], ten[i], maLoaiDichVu, loaiDichVu, DonGia[i], tt[i]);
        }
        for (int i = 0; i < 111; i++) {
            if (i == 0 || i == 11 || i == 37 || i == 53 || i == 69 || i == 90 || i == 110) System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();
    }
}
