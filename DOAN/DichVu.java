package DOAN;

import java.io.InputStream;
import java.io.IOException;
import java.util.Scanner;

public abstract class DichVu extends File implements QuanLy {
    static Scanner sc = new Scanner(System.in);
    protected InputStream inputStream;
    protected String loaiDichVu;
    protected int[] DonGia;
    protected String maLoaiDichVu;
    protected String[] tt;
    protected String[] ma;
    protected String[] ten;

    protected DichVu() {
        super();
        loaiDichVu = null;
        DonGia = new int[100];
        maLoaiDichVu = null;
        tt = new String[100];
        ten = new String[100];
        ma = new String[100];
    }

    public static void table() {
        for (int i = 0; i < 111; i++) {
            if (i == 0 || i == 11 || i == 37 || i == 53 || i == 69 || i == 90 || i == 110) System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();
        System.out.printf("|%-10s|%-25s|%-15s|%-15s|%-20s|%-19s|\n", "Ma", "Ten", "Ma DV", "Loai dich vu", "Gia(VND)", "Tinh trang");
        for (int i = 0; i < 111; i++) {
            if (i == 0 || i == 11 || i == 37 || i == 53 || i == 69 || i == 90 || i == 110) System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();
    }

    @Override
    public void Parse(String line, int num) {
        String[] param = line.split(",");
        ma[num] = param[0];
        ten[num] = param[1];
        DonGia[num] = Integer.parseInt(param[2]);
        tt[num] = param[3];
    }

    @Override
    public String writeline(int i) {
        return this.ma[i] + "," + this.ten[i] + "," + this.DonGia[i] + "," + this.tt[i] + "," + "\n";
    }

    abstract void menu() throws IOException;

    public void capnhatTinhTrang() throws IOException {
        this.docFile();
        int xd = 0;
        String confirm;
        System.out.print("Ma dich vu (san pham) can cap nhat tinh trang: ");
        String madvu = String.valueOf(sc.nextLine());
        for (int i = 0; i < soluong; i++) {
            if (ma[i].equalsIgnoreCase(madvu)) {
                System.out.println("Tinh trang dich vu (san pham): Y/N");
                System.out.println("-Y:CON PHUC VU");
                System.out.println("-N:KHONG CON PHUC VU");
                System.out.println("===================================");
                confirm = String.valueOf(sc.nextLine());
                if (confirm.equalsIgnoreCase("N") || confirm.equalsIgnoreCase("n")) {
                    this.tt[i] = "KHONG CON PHUC VU";
                } else if (confirm.equalsIgnoreCase("Y") || confirm.equalsIgnoreCase("y")) {
                    this.tt[i] = "CON PHUC VU";
                } else {
                    break;
                }
                xd = 1;
                break;
            }
        }
        if (xd == 0) System.out.println("Cap nhat that bai");
        else {
            System.out.println("Cap nhat thanh cong");
            this.ghiFile();
        }
    }

    public void fixPrice() throws IOException {
        this.docFile();
        System.out.print("Ma dich vu (san pham) can sua gia: ");
        String madvu = String.valueOf(sc.nextLine());
        for (int i = 0; i < soluong; i++) {
            if (ma[i].equalsIgnoreCase(madvu)) {
                try {
                    System.out.print("Gia moi: ");
                    int DonGiaM = Integer.valueOf(sc.nextLine());
                    DonGia[i] = DonGiaM;
                    System.out.println("Cap nhat thanh cong");
                    this.ghiFile();
                    break;
                } catch (NumberFormatException a) {
                    System.out.println("Cap nhat thai bai");
                }
            }
        }
    }

    @Override
    public void Add() throws IOException {
        this.docFile();
        int plus, temp;
        try {
            System.out.print("So luong dich vu (san pham) them: ");
            plus = Integer.valueOf(sc.nextLine());
            temp = this.soluong;
            this.soluong += plus;
            for (int i = temp; i < this.soluong; i++) {
                int x = 1;
                ma[i] = this.maLoaiDichVu + x;
                for (int j = 0; j < this.soluong - plus; j++) {
                    if (ma[i].equalsIgnoreCase(ma[j])) {
                        x++;
                        ma[i] = this.maLoaiDichVu + x;
                        j = -1;
                    }
                }
                plus--;
                this.tt[i] = "CON PHUC VU";
                System.out.print("Ten dich vu (san pham): ");
                this.ten[i] = String.valueOf(sc.nextLine());
                System.out.print("Gia dich vu (san pham): ");
                this.DonGia[i] = Integer.valueOf(sc.nextLine());
                System.out.println("=========================");
            }
            System.out.println("Cap nhat thanh cong");
            this.ghiFile();
        } catch (NumberFormatException a) {
            System.out.println("Cap nhat that bai");
        }
    }

    @Override
    public void Remove() throws IOException {
        this.docFile();
        String remove;
        int x = 0;
        int chon = 0;
        System.out.print("Hay nhap ID dich vu (san pham) muon xoa: ");
        remove = String.valueOf(sc.nextLine());
        for (int i = 0; i < soluong; i++) {
            if (this.ma[i].equalsIgnoreCase(remove)) {
                x = 1;
                for (int j = i; j < soluong - 1; j++) {
                    this.ma[j] = this.ma[j + 1];
                    this.ten[j] = this.ten[j + 1];
                    this.tt[j] = this.tt[j + 1];
                    this.DonGia[j] = this.DonGia[j + 1];
                }
                System.out.println("Cap nhat thanh cong !");
                this.soluong--;
            }
        }
        if (x == 0) System.out.println("Cap nhat that bai !");
        do {
            x = 0;
            System.out.println("1.Tiep tuc xoa");
            System.out.println("2.Thoat");
            System.out.println("================");
            System.out.print("Chon: ");
            chon = Integer.valueOf(sc.nextLine());
            if (chon > 2 || chon < 1) System.out.println("Khong ton tai");
            else {
                switch (chon) {
                    case 1:
                        System.out.print("Hay nhap ID dich vu (san pham) muon xoa: ");
                        remove = String.valueOf(sc.nextLine());
                        for (int i = 0; i < soluong; i++) {
                            if (this.ma[i].equalsIgnoreCase(remove)) {
                                x = 1;
                                for (int j = i; j < soluong - 1; j++) {
                                    this.ma[j] = this.ma[j + 1];
                                    this.ten[j] = this.ten[j + 1];
                                    this.tt[j] = this.tt[j + 1];
                                    this.DonGia[j] = this.DonGia[j + 1];
                                }
                                System.out.println("Cap nhat thanh cong !");
                                this.soluong--;
                            }
                        }
                        if (x == 0) System.out.println("Cap nhat that bai !");
                        break;
                    case 2:
                        break;
                }
            }
        } while (chon != 2);
        this.ghiFile();
    }

    @Override
    public void Sort() throws IOException {
        this.docFile();
        try {
            System.out.println("1.Theo ma san pham (dich vu).");
            System.out.println("2.Theo gia san pham (dich vu).");
            System.out.println("==============================");
            System.out.println("Chon phuong thuc sap xep: ");
            int chon = Integer.valueOf(sc.nextLine());
            if (chon > 2 || chon < 1) System.out.println("Khong ton tai");
            else {
                int temp = 0;
                int[] num = new int[soluong];
                switch (chon) {
                    case 1:
                        System.out.println("1.Theo thu tu tang dan.");
                        System.out.println("2.Theo thu tu giam dan.");
                        System.out.println("==============================");
                        System.out.println("Chon phuong thuc sap xep: ");
                        chon = Integer.valueOf(sc.nextLine());
                        if (chon > 2 || chon < 1) System.out.println("Khong ton tai");
                        else {
                            switch (chon) {
                                case 1:
                                    for (int i = 0; i < soluong; i++) {
                                        String[] a = ma[i].split("");
                                        num[i] = Integer.parseInt(a[1]);
                                    }
                                    for (int i = 0; i < soluong - 1; i++) {
                                        for (int j = i + 1; j < soluong; j++) {
                                            if (num[i] > num[j]) {
                                                temp = num[i];
                                                num[i] = num[j];
                                                num[j] = temp;

                                                swap(i, j);
                                            }
                                        }
                                    }
                                    this.ghiFile();
                                    break;
                                case 2:
                                    for (int i = 0; i < soluong; i++) {
                                        String[] a = ma[i].split("");
                                        num[i] = Integer.parseInt(a[1]);
                                    }
                                    for (int i = 0; i < soluong - 1; i++) {
                                        for (int j = i + 1; j < soluong; j++) {
                                            if (num[i] < num[j]) {
                                                temp = num[i];
                                                num[i] = num[j];
                                                num[j] = temp;

                                                swap(i, j);
                                            }
                                        }
                                    }
                                    this.ghiFile();
                                    break;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("1.Theo thu tu tang dan.");
                        System.out.println("2.Theo thu tu giam dan.");
                        System.out.println("==============================");
                        System.out.println("Chon phuong thuc sap xep: ");
                        chon = Integer.valueOf(sc.nextLine());
                        if (chon > 2 || chon < 1) System.out.println("Khong ton tai");
                        else {
                            switch (chon) {
                                case 1:
                                    for (int i = 0; i < soluong - 1; i++) {
                                        for (int j = i + 1; j < soluong; j++) {
                                            if (this.DonGia[i] > this.DonGia[j]) {
                                                swap(i, j);
                                            }
                                        }
                                    }
                                    this.ghiFile();
                                    break;
                                case 2:
                                    for (int i = 0; i < soluong - 1; i++) {
                                        for (int j = i + 1; j < soluong; j++) {
                                            if (this.DonGia[i] < this.DonGia[j]) {
                                                swap(i, j);
                                            }
                                        }
                                    }
                                    this.ghiFile();
                                    break;
                            }
                        }
                        break;
                }
                System.out.println("Cap nhat thanh cong");
            }

        } catch (NumberFormatException e) {
            System.out.println("Cap nhat that bai");
        }
    }

    public void swap(int i, int j) {
        String temp_1;
        int temp;
        temp = this.DonGia[i];
        this.DonGia[i] = this.DonGia[j];
        this.DonGia[j] = temp;

        temp_1 = this.ma[i];
        this.ma[i] = this.ma[j];
        this.ma[j] = temp_1;

        temp_1 = this.ten[i];
        this.ten[i] = this.ten[j];
        this.ten[j] = temp_1;

        temp_1 = this.tt[i];
        this.tt[i] = this.tt[j];
        this.tt[j] = temp_1;
    }

    @Override
    public void Filter() throws IOException {
        this.docFile();
        try {
            System.out.println("1.Theo gia");
            System.out.println("2.Theo ma dich vu (san pham)");
            System.out.println("=============================");
            System.out.print("Chon: ");
            int chon = Integer.valueOf(sc.nextLine());
            if (chon > 2 || chon < 1) System.out.println("Khong ton tai");
            else {
                switch (chon) {
                    case 1:
                        System.out.print("Nhap gia: ");
                        int gia = Integer.valueOf(sc.nextLine());
                        System.out.println("====MENU====");
                        System.out.println("1.>");
                        System.out.println("2.<");
                        System.out.println("3.=");
                        System.out.println("============");
                        System.out.print("Chon: ");
                        chon = Integer.valueOf(sc.nextLine());
                        if (chon < 1 || chon > 3) System.out.println("Khong ton tai");
                        else {
                            switch (chon) {
                                case 1:
                                    table();
                                    for (int i = 0; i < this.soluong; i++)
                                        if (this.DonGia[i] > gia)
                                            System.out.printf("|%-10s|%-25s|%-15s|%-15s|%-20d|%-19s|\n", ma[i], ten[i], maLoaiDichVu, loaiDichVu, DonGia[i], tt[i]);
                                    for (int i = 0; i < 111; i++) {
                                        if (i == 0 || i == 11 || i == 37 || i == 53 || i == 69 || i == 90 || i == 110)
                                            System.out.print("+");
                                        else System.out.print("-");
                                    }
                                    System.out.println();
                                    break;
                                case 2:
                                    table();
                                    for (int i = 0; i < this.soluong; i++)
                                        if (this.DonGia[i] < gia)
                                            System.out.printf("|%-10s|%-25s|%-15s|%-15s|%-20d|%-19s|\n", ma[i], ten[i], maLoaiDichVu, loaiDichVu, DonGia[i], tt[i]);
                                    for (int i = 0; i < 111; i++) {
                                        if (i == 0 || i == 11 || i == 37 || i == 53 || i == 69 || i == 90 || i == 110)
                                            System.out.print("+");
                                        else System.out.print("-");
                                    }
                                    System.out.println();
                                    break;
                                case 3:
                                    table();
                                    for (int i = 0; i < this.soluong; i++)
                                        if (this.DonGia[i] == gia)
                                            System.out.printf("|%-10s|%-25s|%-15s|%-15s|%-20d|%-19s|\n", ma[i], ten[i], maLoaiDichVu, loaiDichVu, DonGia[i], tt[i]);
                                    for (int i = 0; i < 111; i++) {
                                        if (i == 0 || i == 11 || i == 37 || i == 53 || i == 69 || i == 90 || i == 110)
                                            System.out.print("+");
                                        else System.out.print("-");
                                    }
                                    System.out.println();
                                    break;
                            }
                        }
                        break;
                    case 2:
                        System.out.print("Nhap ma: ");
                        String m = String.valueOf(sc.nextLine());
                        table();
                        for (int i = 0; i < this.soluong; i++)
                            if (this.ma[i].equalsIgnoreCase(m))
                                System.out.printf("|%-10s|%-25s|%-15s|%-15s|%-20d|%-19s|\n", ma[i], ten[i], maLoaiDichVu, loaiDichVu, DonGia[i], tt[i]);
                        for (int i = 0; i < 111; i++) {
                            if (i == 0 || i == 11 || i == 37 || i == 53 || i == 69 || i == 90 || i == 110)
                                System.out.print("+");
                            else System.out.print("-");
                        }
                        System.out.println();
                        break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Loc that bai");
        }
        this.ghiFile();
    }
}
