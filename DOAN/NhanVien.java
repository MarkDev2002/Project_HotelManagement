package DOAN;

import java.io.IOException;
import java.util.Scanner;

public class NhanVien extends File implements QuanLy {
    static Scanner sc = new Scanner(System.in);
    protected ConNguoi[] nv;
    protected int[] Luong;
    protected String[] Diachi;
    protected String[] ID;
    protected int TongLuong;

    public NhanVien() {
        super();
        TongLuong = 0;
        nv = new ConNguoi[100];
        for (int i = 0; i < 100; i++) {
            nv[i] = new ConNguoi();
        }
        Luong = new int[100];
        Diachi = new String[100];
        ID = new String[100];
        bath = "C:\\Users\\nguye\\Documents\\OOPJava\\src\\Project\\nhanvien.txt";
    }

    public static void table() {
        for (int i = 0; i < 111; i++) {
            if (i == 0 || i == 11 || i == 37 || i == 46 || i == 69 || i == 90 || i == 110) System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();
        System.out.printf("|%-10s|%-25s|%-8s|%-22s|%-20s|%-19s|\n", "ID", "Ten", "Tuoi", "Gioi tinh", "TTLL", "Luong");
        for (int i = 0; i < 111; i++) {
            if (i == 0 || i == 11 || i == 37 || i == 46 || i == 69 || i == 90 || i == 110) System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        NhanVien nv = new NhanVien();
        //nv.FixInfMenu();
        //nv.EmployeeList();
        //nv.Add();
        nv.EmployeeList();
        //nv.Remove();
        nv.FixInfMenu();
        nv.EmployeeList();
        //nv.EmployeeList();
    }

    public void TongLuongNV() throws IOException {
        this.docFile();
        TongLuong = 0;
        for (int i = 0; i < this.soluong; i++) {
            TongLuong += this.Luong[i];
        }
    }

    @Override
    public void Parse(String line, int num) {
        String[] param = line.split(",");
        ID[num] = param[0];
        nv[num].Ten = param[1];
        nv[num].Tuoi = Integer.parseInt(param[2]);
        nv[num].GT = param[3];
        Diachi[num] = param[4];
        nv[num].TTLL = param[5];
        Luong[num] = Integer.parseInt(param[6]);
    }

    @Override
    public String writeline(int i) {
        return this.ID[i] + "," + nv[i].Ten + "," + nv[i].Tuoi + "," + nv[i].GT + "," + this.Diachi[i] + "," + nv[i].TTLL + "," + this.Luong[i] + "\n";
    }

    public void Input(int num) {
        System.out.print("Nhap ten : ");
        nv[num].Ten = String.valueOf(sc.nextLine());
        System.out.print("Nhap gioi tinh: ");
        nv[num].GT = String.valueOf(sc.nextLine());
        System.out.print("Nhap tuoi : ");
        nv[num].Tuoi = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap thong tin lien lac : ");
        nv[num].TTLL = String.valueOf(sc.nextLine());
        System.out.print("Nhap dia chi : ");
        Diachi[num] = String.valueOf(sc.nextLine());
        Luong[num] = 4000000;
    }

    @Override
    public void Add() throws IOException {
        this.docFile();
        int plus, temp;
        try {
            System.out.print("So luong nhan vien them: ");
            plus = Integer.parseInt(sc.nextLine());
            temp = this.soluong;
            this.soluong += plus;
            for (int i = temp; i < this.soluong; i++) {
                int x = 1;
                ID[i] = "NV" + x;
                for (int j = 0; j < temp; j++) {
                    if (ID[i].equalsIgnoreCase(ID[j])) {
                        x++;
                        ID[i] = "NV" + x;
                        j = -1;
                    }
                }
                Input(i);
                System.out.println("=========================");
            }
            System.out.println("Cap nhat thanh cong");
            this.ghiFile();
        } catch (NumberFormatException a) {
            System.out.println("Cap nhat that bai");
        }
    }

    public void EmployeeList() throws IOException {
        this.docFile();
        table();
        for (int i = 0; i < this.soluong; i++) {
            System.out.printf("|%-10s|%-25s|%-8s|%-22s|%-20s|%-19d|\n", ID[i], nv[i].Ten, nv[i].Tuoi, nv[i].GT, nv[i].TTLL, Luong[i]);
        }
        for (int i = 0; i < 111; i++) {
            if (i == 0 || i == 11 || i == 37 || i == 46 || i == 69 || i == 90 || i == 110) System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();
    }

    @Override
    public void Remove() throws IOException {
        this.docFile();
        String remove;
        int x = 0;
        int chon;
        System.out.print("Hay nhap ID nhan vien muon xoa: ");
        remove = String.valueOf(sc.nextLine());
        for (int i = 0; i < soluong; i++) {
            if (this.ID[i].equalsIgnoreCase(remove)) {
                x = 1;
                for (int j = i; j < soluong - 1; j++) {
                    this.ID[j] = this.ID[j + 1];
                    nv[j].Ten = nv[j + 1].Ten;
                    this.Luong[j] = this.Luong[j + 1];
                    nv[j].Tuoi = nv[j + 1].Tuoi;
                    nv[j].GT = nv[j + 1].GT;
                    nv[j].TTLL = nv[j + 1].TTLL;
                    this.Diachi[j] = this.Diachi[j + 1];
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
                        System.out.print("Hay nhap ID nhan vien muon xoa: ");
                        remove = String.valueOf(sc.nextLine());
                        for (int i = 0; i < soluong; i++) {
                            if (this.ID[i].equalsIgnoreCase(remove)) {
                                x = 1;
                                for (int j = i; j < soluong - 1; j++) {
                                    this.ID[j] = this.ID[j + 1];
                                    nv[j].Ten = nv[j + 1].Ten;
                                    this.Luong[j] = this.Luong[j + 1];
                                    nv[j].Tuoi = nv[j + 1].Tuoi;
                                    nv[j].GT = nv[j + 1].GT;
                                    nv[j].TTLL = nv[j + 1].TTLL;
                                    this.Diachi[j] = this.Diachi[j + 1];
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
    public void Sort() throws IOException {
        this.docFile();
        try {
            System.out.println("1.Theo ID nhan vien.");
            System.out.println("2.Theo luong.");
            System.out.println("==============================");
            System.out.println("Chon phuong thuc sap xep: ");
            int chon = Integer.parseInt(sc.nextLine());
            int temp;
            int[] num = new int[soluong];
            if (chon > 2 || chon < 1) System.out.println("Khong ton tai");
            else {
                switch (chon) {
                    case 1 -> {
                        System.out.println("1.Theo thu tu tang dan.");
                        System.out.println("2.Theo thu tu giam dan.");
                        System.out.println("==============================");
                        System.out.println("Chon phuong thuc sap xep: ");
                        chon = Integer.parseInt(sc.nextLine());
                        if (chon > 2 || chon < 1) System.out.println("Khong ton tai");
                        else {
                            switch (chon) {
                                case 1 -> {
                                    for (int i = 0; i < soluong; i++) {
                                        String[] a = ID[i].split("");
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
                                        String[] a = ID[i].split("");
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
                            }
                            System.out.println("Cap nhat thanh cong");
                        }
                    }
                    case 2 -> {
                        System.out.println("1.Theo thu tu tang dan.");
                        System.out.println("2.Theo thu tu giam dan.");
                        System.out.println("==============================");
                        System.out.println("Chon phuong thuc sap xep: ");
                        chon = Integer.parseInt(sc.nextLine());
                        if (chon > 2 || chon < 1) System.out.println("Khong ton tai");
                        else {
                            switch (chon) {
                                case 1 -> {
                                    for (int i = 0; i < soluong - 1; i++) {
                                        for (int j = i + 1; j < soluong; j++) {
                                            if (this.Luong[i] > this.Luong[j]) {
                                                swap(i, j);
                                            }
                                        }
                                    }
                                    this.ghiFile();
                                }
                                case 2 -> {
                                    for (int i = 0; i < soluong - 1; i++) {
                                        for (int j = i + 1; j < soluong; j++) {
                                            if (this.Luong[i] < this.Luong[j]) {
                                                swap(i, j);
                                            }
                                        }
                                    }
                                    this.ghiFile();
                                }
                            }
                            System.out.println("Cap nhat thanh cong");
                        }
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Cap nhat that bai");
        }
    }

    public void swap(int i, int j) {
        int temp;
        String temp_1;
        temp = this.Luong[i];
        this.Luong[i] = this.Luong[j];
        this.Luong[j] = temp;

        temp = nv[i].Tuoi;
        nv[i].Tuoi = nv[j].Tuoi;
        nv[j].Tuoi = temp;

        temp_1 = this.ID[i];
        this.ID[i] = this.ID[j];
        this.ID[j] = temp_1;

        temp_1 = nv[i].Ten;
        nv[i].Ten = nv[j].Ten;
        nv[j].Ten = temp_1;

        temp_1 = nv[i].TTLL;
        nv[i].TTLL = nv[j].TTLL;
        nv[j].TTLL = temp_1;

        temp_1 = nv[i].GT;
        nv[i].GT = nv[j].GT;
        nv[j].GT = temp_1;

        temp_1 = this.Diachi[i];
        this.Diachi[i] = this.Diachi[j];
        this.Diachi[j] = temp_1;
    }

    @Override
    public void Filter() throws IOException {
        this.docFile();
        try {
            System.out.println("1.Theo luong");
            System.out.println("2.Theo ID nhan vien");
            System.out.println("3.Theo gioi tinh");
            System.out.println("=============================");
            System.out.print("Chon: ");
            int chon = Integer.parseInt(sc.nextLine());
            if (chon > 3 || chon < 1) System.out.println("Khong ton tai phuong thuc");
            else {
                switch (chon) {
                    case 1 -> {
                        System.out.print("Nhap muc luong: ");
                        int luong = Integer.parseInt(sc.nextLine());
                        System.out.println("====MENU====");
                        System.out.println("1.>");
                        System.out.println("2.<");
                        System.out.println("3.=");
                        System.out.println("============");
                        System.out.print("Chon: ");
                        chon = Integer.parseInt(sc.nextLine());
                        if (chon > 3 || chon < 1) System.out.println("Khong ton tai");
                        else {
                            switch (chon) {
                                case 1 -> {
                                    table();
                                    for (int i = 0; i < this.soluong; i++)
                                        if (this.Luong[i] > luong)
                                            System.out.printf("|%-10s|%-25s|%-8s|%-22s|%-20s|%-19d|\n", ID[i], nv[i].Ten, nv[i].Tuoi, nv[i].GT, nv[i].TTLL, Luong[i]);
                                    for (int i = 0; i < 111; i++) {
                                        if (i == 0 || i == 11 || i == 37 || i == 53 || i == 69 || i == 90 || i == 110)
                                            System.out.print("+");
                                        else System.out.print("-");
                                    }
                                    System.out.println();
                                }
                                case 2 -> {
                                    table();
                                    for (int i = 0; i < this.soluong; i++)
                                        if (this.Luong[i] < luong)
                                            System.out.printf("|%-10s|%-25s|%-8s|%-22s|%-20s|%-19d|\n", ID[i], nv[i].Ten, nv[i].Tuoi, nv[i].GT, nv[i].TTLL, Luong[i]);
                                    for (int i = 0; i < 111; i++) {
                                        if (i == 0 || i == 11 || i == 37 || i == 53 || i == 69 || i == 90 || i == 110)
                                            System.out.print("+");
                                        else System.out.print("-");
                                    }
                                    System.out.println();
                                }
                                case 3 -> {
                                    table();
                                    for (int i = 0; i < this.soluong; i++)
                                        if (this.Luong[i] == luong)
                                            System.out.printf("|%-10s|%-25s|%-8s|%-22s|%-20s|%-19d|\n", ID[i], nv[i].Ten, nv[i].Tuoi, nv[i].GT, nv[i].TTLL, Luong[i]);
                                    for (int i = 0; i < 111; i++) {
                                        if (i == 0 || i == 11 || i == 37 || i == 53 || i == 69 || i == 90 || i == 110)
                                            System.out.print("+");
                                        else System.out.print("-");
                                    }
                                    System.out.println();
                                }
                            }
                        }
                    }
                    case 2 -> {
                        System.out.print("Nhap ID nhan vien: ");
                        String m = String.valueOf(sc.nextLine());
                        table();
                        for (int i = 0; i < this.soluong; i++) {
                            if (this.ID[i].equalsIgnoreCase(m)) {
                                System.out.printf("|%-10s|%-25s|%-8s|%-22s|%-20s|%-19d|\n", ID[i], nv[i].Ten, nv[i].Tuoi, nv[i].GT, nv[i].TTLL, Luong[i]);
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
                    case 3 -> {
                        System.out.print("Nhap gioi tinh can loc: ");
                        String gt = String.valueOf(sc.nextLine());
                        table();
                        for (int i = 0; i < this.soluong; i++)
                            if (nv[i].GT.equalsIgnoreCase(gt))
                                System.out.printf("|%-10s|%-25s|%-8s|%-22s|%-20s|%-19d|\n", ID[i], nv[i].Ten, nv[i].Tuoi, nv[i].GT, nv[i].TTLL, Luong[i]);
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

    public void FixInfMenu() throws IOException {
        this.docFile();
        System.out.println("======Chon thong tin muon sua======");
        System.out.println("1.Ten");
        System.out.println("2.Luong");
        System.out.println("3.Gioi tinh");
        System.out.println("4.Thong tin lien he");
        System.out.println("5.Dia chi");
        System.out.println("6.Tuoi");
        System.out.println("===================================");
        System.out.print("Chon: ");
        int chon = Integer.parseInt(sc.nextLine());
        if (chon < 1 || chon > 6) System.out.println("Khong ton tai phuong thuc nay");
        else {
            System.out.print("ID nhan vien: ");
            String id = String.valueOf(sc.nextLine());
            int t = 0, t2 = 0;
            String sua = null;
            for (int i = 0; i < this.soluong; i++) {
                if (id.equalsIgnoreCase(ID[i])) {
                    System.out.print("Nhap noi dung sua: ");
                    sua = String.valueOf(sc.nextLine());
                    t = 1;
                    t2 = i;
                    break;
                }
            }
            if (t == 0) {
                System.out.println("Khong tim thay ID nhan vien");
            } else {
                switch (chon) {
                    case 1 -> nv[t2].Ten = sua;
                    case 2 -> this.Luong[t2] = Integer.parseInt(sua);
                    case 3 -> nv[t2].GT = sua;
                    case 4 -> nv[t2].TTLL = sua;
                    case 5 -> this.Diachi[t2] = sua;
                    case 6 -> nv[t2].Tuoi = Integer.parseInt(sua);
                    default -> {
                    }
                }
                System.out.println("Cap nhat thanh cong");
                this.ghiFile();
            }
        }
    }
}
