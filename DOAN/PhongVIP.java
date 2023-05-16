package DOAN;

import java.io.IOException;
import java.util.Scanner;

public class PhongVIP extends Phong {
    static Scanner sc = new Scanner(System.in);

    protected PhongVIP() throws IOException {
        super();
        maLoaiPhong = "V";
        bath = "D:\\OOPJava\\src\\Project\\MenuPhongVip.txt";
        loaiPhong = "VIP";
    }

    public static void main(String[] args) throws IOException {
        Phong a = new PhongVIP();
        a.menu();
        //a.Add();
        //a.menu();
        a.Add();
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
        DichVu dvthem = new DichVuKhac();
        dvthem.docFile();
        System.out.println("Dich vu kem theo: ");
        for (int i = 0; i < 44; i++) {
            if (i == 0 || i == 11 || i == 27 || i == 43) System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();
        System.out.printf("|%-10s|%-15s|%-15s|\n", "IDDV", "Ten DV", "Gia");

        for (int i = 0; i < 44; i++) {
            if (i == 0 || i == 11 || i == 27 || i == 43) System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < dvthem.soluong; i++) {
            if (dvthem.ten[i].equalsIgnoreCase("Don dep") || dvthem.ten[i].equalsIgnoreCase("May lanh")) {
                System.out.printf("|%-10s|%-15s|%-15d|\n", dvthem.ma[i], dvthem.ten[i], dvthem.DonGia[i]);
            }
        }
        for (int i = 0; i < 44; i++) {
            if (i == 0 || i == 11 || i == 27 || i == 43) System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();
    }

    @Override
    public void tienDichVu(int i) throws IOException {
        DichVu dvthem = new DichVuKhac();
        dvthem.docFile();
        for (int j = 0; j < dvthem.soluong; j++) {
            if (dvthem.ten[j].equalsIgnoreCase("Don dep") || dvthem.ten[j].equalsIgnoreCase("May lanh")) {
                this.DonGia[i] += dvthem.DonGia[j];
            }
        }
    }
}