package DOAN;

import java.io.IOException;
import java.util.Scanner;

public class KhachHang extends File implements QuanLy {
    static Scanner sc = new Scanner(System.in);
    protected ConNguoi[] kh;
    protected String[] ma;
    protected String[] cccd;

    protected KhachHang() {
        super();
        kh = new ConNguoi[100];
        for (int i = 0; i < 100; i++) {
            kh[i] = new ConNguoi();
        }
        cccd = new String[100];
        ma = new String[100];
        bath = "D:\\OOPJava\\src\\Project\\khachhang.txt";
    }

    public static void table() {
        for (int i = 0; i < 111; i++) {
            if (i == 0 || i == 11 || i == 37 || i == 46 || i == 69 || i == 90 || i == 110) System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();
        System.out.printf("|%-10s|%-25s|%-8s|%-22s|%-20s|%-19s|\n", "ID", "Ten", "Tuoi", "Gioi tinh", "TTLL", "CCCD/CMND");
        for (int i = 0; i < 111; i++) {
            if (i == 0 || i == 11 || i == 37 || i == 46 || i == 69 || i == 90 || i == 110) System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        KhachHang kh = new KhachHang();
        kh.CustomerList();
        kh.Sort();
    }

    public void NhapTTKH(int num) {
        System.out.print("Hay nhap ten khach hang: ");
        kh[num].Ten = String.valueOf(sc.nextLine());
        System.out.print("Hay nhap gioi tinh: ");
        kh[num].GT = String.valueOf(sc.nextLine());
        System.out.print("Hay nhap tuoi: ");
        kh[num].Tuoi = Integer.parseInt(sc.nextLine());
        System.out.print("Hay nhap TTLL: ");
        kh[num].TTLL = String.valueOf(sc.nextLine());
        int x = 0;
        while (x == 0) {
            System.out.print("Hay nhap CCCD/CMND: ");
            cccd[num] = String.valueOf(sc.nextLine());
            if (cccd[num].length() == 9 || cccd[num].length() == 12) x = 1;
            else System.out.println("So CCCD/CMND khong hop le");
        }

    }

    @Override
    public void Filter() throws IOException {
        this.docFile();
        try {
            System.out.println("1.Theo ID khach hang");
            System.out.println("2.Theo gioi tinh");
            System.out.println("=============================");
            System.out.print("Chon: ");
            int chon = Integer.parseInt(sc.nextLine());
            if (chon > 2 || chon < 1) System.out.println("Khong ton tai phuong thuc");
            else {
                switch (chon) {
                    case 1 -> {
                        System.out.print("Nhap ID khach hang: ");
                        String m = String.valueOf(sc.nextLine());
                        table();
                        for (int i = 0; i < this.soluong; i++) {
                            if (this.ma[i].equalsIgnoreCase(m)) {
                                System.out.printf("|%-10s|%-25s|%-8s|%-22s|%-20s|%-19s|\n", ma[i], kh[i].Ten, kh[i].Tuoi, kh[i].GT, kh[i].TTLL, cccd[i]);
                                break;
                            }
                        }
                        for (int i = 0; i < 111; i++) {
                            if (i == 0 || i == 11 || i == 37 || i == 53 || i == 69 || i == 90 || i == 110)
                                System.out.print("+");
                            else System.out.print("-");
                        }
                        System.out.println();
                    }
                    case 2 -> {
                        System.out.print("Nhap gioi tinh can loc: ");
                        String gt = String.valueOf(sc.nextLine());
                        table();
                        for (int i = 0; i < this.soluong; i++)
                            if (kh[i].GT.equalsIgnoreCase(gt))
                                System.out.printf("|%-10s|%-25s|%-8s|%-22s|%-20s|%-19s|\n", ma[i], kh[i].Ten, kh[i].Tuoi, kh[i].GT, kh[i].TTLL, cccd[i]);
                        for (int i = 0; i < 111; i++) {
                            if (i == 0 || i == 11 || i == 37 || i == 53 || i == 69 || i == 90 || i == 110)
                                System.out.print("+");
                            else System.out.print("-");
                        }
                        System.out.println();
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Loc that bai");
        }
        this.ghiFile();
    }

    @Override
    public void Sort() throws IOException {
        this.docFile();
        try {
            int chon;
            int temp;
            int[] num = new int[soluong];
            System.out.println("1.Theo thu tu tang dan cua ID.");
            System.out.println("2.Theo thu tu giam dan cua ID.");
            System.out.println("3.Theo thu tu tang dan do tuoi.");
            System.out.println("4.Theo thu tu giam dan do tuoi.");
            System.out.println("==============================");
            System.out.println("Chon phuong thuc sap xep: ");
            chon = Integer.parseInt(sc.nextLine());
            if (chon > 4 || chon < 1) System.out.println("Khong ton tai");
            else {
                switch (chon) {
                    case 1 -> {
                        for (int i = 0; i < soluong; i++) {
                            String[] a = ma[i].split("");
                            num[i] = Integer.parseInt(a[2]);
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
                    }
                    case 2 -> {
                        for (int i = 0; i < soluong; i++) {
                            String[] a = ma[i].split("");
                            num[i] = Integer.parseInt(a[2]);
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
                    }
                    case 3 -> {
                        for (int i = 0; i < soluong - 1; i++) {
                            for (int j = i + 1; j < soluong; j++) {
                                if (kh[i].Tuoi > kh[j].Tuoi) {
                                    swap(i, j);
                                }
                            }
                        }
                        this.ghiFile();
                    }
                    case 4 -> {
                        for (int i = 0; i < soluong - 1; i++) {
                            for (int j = i + 1; j < soluong; j++) {
                                if (kh[i].Tuoi < kh[j].Tuoi) {
                                    swap(i, j);
                                }
                            }
                        }
                        this.ghiFile();
                    }
                }
                System.out.println("Cap nhat thanh cong");
            }
        } catch (NumberFormatException e) {
            System.out.println("Cap nhat that bai");
        }

    }

    public void swap(int num, int num2) {
        int temp;
        String temp_1;
        temp = kh[num].Tuoi;
        kh[num].Tuoi = kh[num2].Tuoi;
        kh[num2].Tuoi = temp;

        temp_1 = this.ma[num];
        this.ma[num] = this.ma[num2];
        this.ma[num2] = temp_1;

        temp_1 = kh[num].Ten;
        kh[num].Ten = kh[num2].Ten;
        kh[num2].Ten = temp_1;

        temp_1 = kh[num].TTLL;
        kh[num].TTLL = kh[num2].TTLL;
        kh[num2].TTLL = temp_1;

        temp_1 = kh[num].GT;
        kh[num].GT = kh[num2].GT;
        kh[num2].GT = temp_1;

        temp_1 = this.cccd[num];
        this.cccd[num] = this.cccd[num2];
        this.cccd[num2] = temp_1;
    }

    public void FixInfMenu() throws IOException {
        this.docFile();
        System.out.println("======Chon thong tin muon sua======");
        System.out.println("1.Ten");
        System.out.println("2.CCCD");
        System.out.println("3.Gioi tinh");
        System.out.println("4.Thong tin lien he");
        System.out.println("5.Tuoi");
        System.out.println("===================================");
        System.out.print("Chon: ");
        int chon = Integer.parseInt(sc.nextLine());
        if (chon < 1 || chon > 5) System.out.println("Khong ton tai phuong thuc nay");
        else {
            System.out.print("ID khach hang: ");
            String id = String.valueOf(sc.nextLine());
            int t = 0, t2 = 0;
            String sua = null;
            for (int i = 0; i < this.soluong; i++) {
                if (id.equalsIgnoreCase(ma[i])) {
                    System.out.print("Nhap noi dung sua: ");
                    sua = String.valueOf(sc.nextLine());
                    t = 1;
                    t2 = i;
                    break;
                }
            }
            if (t == 0) {
                System.out.println("Khong tim thay ID khach hang");
            } else {
                switch (chon) {
                    case 1 -> kh[t2].Ten = sua;
                    case 2 -> cccd[t2] = sua;
                    case 3 -> kh[t2].GT = sua;
                    case 4 -> kh[t2].TTLL = sua;
                    case 5 -> kh[t2].Tuoi = Integer.parseInt(sua);
                    default -> {
                    }
                }
                System.out.println("Cap nhat thanh cong");
                this.ghiFile();
            }
        }
    }

    @Override
    public void Add() throws IOException {
        this.docFile();
        int temp;
        try {
            temp = this.soluong;
            this.soluong++;
            for (int i = temp; i < this.soluong; i++) {
                int x = 1;
                ma[i] = "KH" + x;
                for (int j = 0; j < temp; j++) {
                    if (ma[i].equalsIgnoreCase(ma[j])) {
                        x++;
                        ma[i] = "KH" + x;
                        j = -1;
                    }
                }
                NhapTTKH(i);
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
        int chon;
        System.out.print("Hay nhap ID khach hang muon xoa: ");
        remove = String.valueOf(sc.nextLine());
        for (int i = 0; i < soluong; i++) {
            if (this.ma[i].equalsIgnoreCase(remove)) {
                x = 1;
                for (int j = i; j < soluong - 1; j++) {
                    this.ma[j] = this.ma[j + 1];
                    kh[j].Ten = kh[j + 1].Ten;
                    this.cccd[j] = this.cccd[j + 1];
                    kh[j].Tuoi = kh[j + 1].Tuoi;
                    kh[j].GT = kh[j + 1].GT;
                    kh[j].TTLL = kh[j + 1].TTLL;
                }
                System.out.println("Cap nhat thanh cong !");
                this.soluong--;
                break;
            }
        }
        if (x == 0) System.out.println("Cap nhat that bai !");
        do {
            x = 0;
            System.out.println("1.Tiep tuc xoa");
            System.out.println("2.Thoat");
            System.out.println("================");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());
            if (chon > 2 || chon < 1) System.out.println("Khong ton tai");
            else {
                switch (chon) {
                    case 1:
                        System.out.print("Hay nhap ID khach hang muon xoa: ");
                        remove = String.valueOf(sc.nextLine());
                        for (int i = 0; i < soluong; i++) {
                            if (this.ma[i].equalsIgnoreCase(remove)) {
                                x = 1;
                                for (int j = i; j < soluong - 1; j++) {
                                    this.ma[j] = this.ma[j + 1];
                                    kh[j].Ten = kh[j + 1].Ten;
                                    this.cccd[j] = this.cccd[j + 1];
                                    kh[j].Tuoi = kh[j + 1].Tuoi;
                                    kh[j].GT = kh[j + 1].GT;
                                    kh[j].TTLL = kh[j + 1].TTLL;
                                }
                                System.out.println("Cap nhat thanh cong !");
                                this.soluong--;
                                break;
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
    public void Parse(String line, int num) {
        String[] param = line.split(",");
        ma[num] = param[0];
        kh[num].Ten = param[1];
        kh[num].Tuoi = Integer.parseInt(param[2]);
        kh[num].GT = param[3];
        cccd[num] = param[4];
        kh[num].TTLL = param[5];

    }

    @Override
    public String writeline(int i) {
        return this.ma[i] + "," + kh[i].Ten + "," + kh[i].Tuoi + "," + kh[i].GT + "," + this.cccd[i] + "," + kh[i].TTLL + "," + "\n";
    }

    public void CustomerList() throws IOException {
        this.docFile();
        table();
        for (int i = 0; i < this.soluong; i++) {
            System.out.printf("|%-10s|%-25s|%-8s|%-22s|%-20s|%-19s|\n", ma[i], kh[i].Ten, kh[i].Tuoi, kh[i].GT, kh[i].TTLL, cccd[i]);
        }
        for (int i = 0; i < 111; i++) {
            if (i == 0 || i == 11 || i == 37 || i == 46 || i == 69 || i == 90 || i == 110) System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();
    }
}
