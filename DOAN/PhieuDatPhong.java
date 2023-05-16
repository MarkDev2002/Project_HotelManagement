package DOAN;

import java.io.IOException;
import java.util.Scanner;

public class PhieuDatPhong extends File implements QuanLy {
    static Scanner sc = new Scanner(System.in);
    protected String[] ngay;
    protected String[] maphieu;
    protected String[] maphong;
    protected String[] pttt;
    protected String[] makh;
    protected KhachHang kh;
    protected Phong phgv;
    protected Phong phgt;
    protected int[] songaythue;

    public PhieuDatPhong() throws IOException {
        phgv = new PhongVIP();
        phgt = new PhongTHUONG();
        ngay = new String[100];
        maphieu = new String[100];
        pttt = new String[100];
        makh = new String[100];
        maphong = new String[100];
        songaythue = new int[100];
        kh = new KhachHang();
        bath = "D:\\OOPJava\\src\\Project\\phieudatphong.txt";
    }

    public static void table() {
        for (int i = 0; i < 91; i++) {
            if (i == 0 || i == 11 || i == 37 || i == 46 || i == 69 || i == 90) System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();
        System.out.printf("|%-10s|%-25s|%-8s|%-22s|%-20s|\n", "ID phieu", "Phuong thuc thanh toan", "IDKH", "Ngay dang ky", "Ma phong");
        for (int i = 0; i < 91; i++) {
            if (i == 0 || i == 11 || i == 37 || i == 46 || i == 69 || i == 90) System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        PhieuDatPhong pdp = new PhieuDatPhong();
        pdp.ListPDP();
        pdp.Add();
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    @Override
    public void Add() throws IOException {
        kh.docFile();
        this.docFile();
        System.out.println("Ban da tung dat phong chua?");
        System.out.println("1. Roi");
        System.out.println("2. Chua");
        System.out.println("=============================");
        System.out.print("Chon: ");
        int chon = Integer.valueOf(sc.nextLine());
        if (chon > 2 || chon < 1) System.out.println("Lua chon khong hop le");
        else {
            int x = 0;
            String name = null;
            switch (chon) {
                case 1:
                    System.out.print("Hay ghi ten (ID) cua ban: ");
                    name = String.valueOf(sc.nextLine());
                    for (int i = 0; i < kh.soluong; i++) {
                        if (name.equalsIgnoreCase(kh.kh[i].Ten) || name.equalsIgnoreCase(kh.ma[i])) {
                            makh[soluong] = kh.ma[i];
                            x = 1;
                            break;
                        }
                    }
                    if (x == 0) System.out.println("Ten hoac ID cua ban khong ton tai");
                    else {
                        add();
                    }
                    break;
                case 2:
                    kh.Add();
                    makh[soluong] = kh.ma[kh.soluong - 1];
                    add();
                    break;
            }
            kh.ghiFile();
        }

    }

    public void add() throws IOException {
        int chon;
        System.out.print("So ngay thue phong: ");
        songaythue[soluong] = Integer.valueOf(sc.nextLine());
        System.out.print("So phong muon dat: ");
        int sophong = Integer.valueOf(sc.nextLine());
        System.out.println("Hay chon phuong thuc thanh toan: ");
        System.out.println("1. The tin dung");
        System.out.println("2. Thanh toan truc tiep");
        System.out.println("====================================");
        System.out.print("Chon: ");
        chon = Integer.valueOf(sc.nextLine());
        if (chon > 2 || chon < 1) System.out.println("Lua chon khong hop le");
        else {
            switch (chon) {
                case 1:
                    pttt[soluong] = "The tin dung";
                    break;
                case 2:
                    pttt[soluong] = "Thanh toan truc tiep";
                    break;
            }
        }
        for (int i = this.soluong; i < this.soluong + 1; i++) {
            int x = 1;
            maphieu[i] = "DP" + x;
            for (int j = 0; j < this.soluong; j++) {
                if (maphieu[i].equalsIgnoreCase(maphieu[j])) {
                    x++;
                    maphieu[i] = "DP" + x;
                    j = -1;
                }
            }
        }
        System.out.print("Dien vao ngay dang ky phong (DD/MM/YYYY): ");
        ngay[soluong] = String.valueOf(sc.nextLine());
        String[] maph = new String[sophong];
        phgt.docFile();
        phgv.docFile();
        for (int g = 0; g < sophong; g++) {
            System.out.print("Dien vao ma phong muon dat: ");
            maph[g] = String.valueOf(sc.nextLine());
        }

        maphong[soluong] = "";
        int l = 0;
        for (int i = 0; i < phgt.soluong; i++) {
            for (int j = 0; j < sophong; j++) {
                if (maph[j].equalsIgnoreCase(phgt.ma[i])) {


                    if (phgt.tt[i].equalsIgnoreCase("DA BI DAT")) {
                        System.out.println("Phong " + maph[j] + " da co nguoi dat");
                        break;
                    } else {
                        maphong[soluong] += phgt.ma[i] + " ";
                        l = 1;
                        phgt.tt[i] = "DA BI DAT";
                        phgt.ghiFile();
                    }
                }
            }
        }
        if (l == 0) {
            for (int i = 0; i < phgv.soluong; i++) {
                for (int j = 0; j < sophong; j++) {
                    if (maph[j].equalsIgnoreCase(phgv.ma[i])) {


                        if (phgv.tt[i].equalsIgnoreCase("DA BI DAT")) {
                            System.out.println("Phong da co nguoi dat");
                            break;
                        } else {
                            maphong[soluong] += phgv.ma[i] + " ";
                            l = 1;
                            phgv.tt[i] = "DA BI DAT";
                            phgv.ghiFile();
                        }

                    }
                }
            }
        }
        if (l == 1) {
            System.out.println("Thanh cong");
            setSoluong(++this.soluong);
            this.ghiFile();
        } else System.out.println("That bai");
    }

    @Override
    public void Parse(String line, int num) {
        String[] param = line.split(",");
        maphieu[num] = param[0];
        pttt[num] = param[1];
        makh[num] = param[2];
        ngay[num] = param[3];
        maphong[num] = param[4];
        songaythue[num] = Integer.valueOf(param[5]);
    }

    @Override
    public String writeline(int i) {
        return maphieu[i] + "," + pttt[i] + "," + makh[i] + "," + ngay[i] + "," + maphong[i] + "," + songaythue[i] + "\n";
    }

    public void ListPDP() throws IOException {
        this.docFile();
        table();
        for (int i = 0; i < this.soluong; i++) {
            System.out.printf("|%-10s|%-25s|%-8s|%-22s|%-20s|\n", maphieu[i], pttt[i], makh[i], ngay[i], maphong[i]);
        }
        for (int i = 0; i < 91; i++) {
            if (i == 0 || i == 11 || i == 37 || i == 46 || i == 69 || i == 90) System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();
    }

    @Override
    public void Filter() throws IOException {
        this.docFile();
        try {
            System.out.println("1.Theo ID khach hang");
            System.out.println("2.Theo PTTT");
            System.out.println("3.Theo ngay dang ky phong");
            System.out.println("=============================");
            System.out.print("Chon: ");
            int chon = Integer.valueOf(sc.nextLine());
            if (chon > 3 || chon < 1) System.out.println("Khong ton tai phuong thuc");
            else {
                switch (chon) {
                    case 1:
                        System.out.print("Nhap ID khach hang: ");
                        String m = String.valueOf(sc.nextLine());
                        table();
                        for (int i = 0; i < this.soluong; i++) {
                            if (this.makh[i].equalsIgnoreCase(m)) {
                                System.out.printf("|%-10s|%-25s|%-8s|%-22s|%-20s|\n", maphieu[i], pttt[i], makh[i], ngay[i], maphong[i]);
                                break;
                            }
                        }
                        for (int i = 0; i < 91; i++) {
                            if (i == 0 || i == 11 || i == 37 || i == 46 || i == 69 || i == 90) System.out.print("+");
                            else System.out.print("-");
                        }
                        System.out.println();
                        break;
                    case 2:
                        System.out.print("Nhap PTTT: ");
                        String gt = String.valueOf(sc.nextLine());
                        table();
                        for (int i = 0; i < this.soluong; i++)
                            if (pttt[i].equalsIgnoreCase(gt))
                                System.out.printf("|%-10s|%-25s|%-8s|%-22s|\n", maphieu[i], pttt[i], makh[i], ngay[i]);
                        for (int i = 0; i < 91; i++) {
                            if (i == 0 || i == 11 || i == 37 || i == 46 || i == 69 || i == 90) System.out.print("+");
                            else System.out.print("-");
                        }
                        System.out.println();
                        break;
                    case 3:
                        System.out.print("Nhap ngay dang ky phong (cu phap: EEE MMM dd HH:mm:ss ICT yyyy): ");
                        String lich = String.valueOf(sc.nextLine());
                        table();
                        for (int i = 0; i < this.soluong; i++)
                            if (String.valueOf(ngay[i]).equalsIgnoreCase(lich))
                                System.out.printf("|%-10s|%-25s|%-8s|%-22s|\n", maphieu[i], pttt[i], makh[i], ngay[i]);
                        for (int i = 0; i < 91; i++) {
                            if (i == 0 || i == 11 || i == 37 || i == 46 || i == 69 || i == 90) System.out.print("+");
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

    @Override
    public void Sort() throws IOException {
        this.docFile();
        try {
            int chon;
            int temp = 0;
            int[] num = new int[soluong];
            int[] year = new int[soluong];
            int[] month = new int[soluong];
            int[] day = new int[soluong];
            System.out.println("1.Theo thu tu tang dan cua ngay dang ky phong.");
            System.out.println("2.Theo thu tu giam dan cua ngay dang ky phong.");
            System.out.println("3.Theo thu tu tang dan cua ID phieu dat phong.");
            System.out.println("4.Theo thu tu giam dan cua ID phieu dat phong.");
            System.out.println("==============================");
            System.out.println("Chon phuong thuc sap xep: ");
            chon = Integer.valueOf(sc.nextLine());
            if (chon > 4 || chon < 1) System.out.println("Khong ton tai");
            else {
                switch (chon) {
                    case 1:
                        for (int i = 0; i < soluong; i++) {
                            String[] a = ngay[i].split("/");
                            year[i] = Integer.valueOf(a[2]);
                            month[i] = Integer.valueOf(a[1]);
                            day[i] = Integer.valueOf(a[0]);
                        }
                        for (int i = 0; i < soluong - 1; i++) {
                            for (int j = i + 1; j < soluong; j++) {
                                if (year[i] > year[j]) {
                                    swap(i, j);
                                    swapsmall(year[i], year[j]);
                                } else if (year[i] == year[j]) {
                                    if (month[i] > month[j]) {
                                        swap(i, j);
                                        swapsmall(year[i], year[j]);
                                        swapsmall(month[i], month[j]);
                                    } else if (month[i] == month[j]) {
                                        if (day[i] > day[j]) {
                                            swap(i, j);
                                            swapsmall(day[i], day[j]);
                                            swapsmall(month[i], month[j]);
                                            swapsmall(year[i], year[j]);
                                        }
                                    }
                                }
                            }
                        }
                        this.ghiFile();
                        break;
                    case 2:
                        for (int i = 0; i < soluong; i++) {
                            String[] a = ngay[i].split("/");
                            year[i] = Integer.valueOf(a[2]);
                            month[i] = Integer.valueOf(a[1]);
                            day[i] = Integer.valueOf(a[0]);
                        }
                        for (int i = 0; i < soluong - 1; i++) {
                            for (int j = i + 1; j < soluong; j++) {
                                if (year[i] < year[j]) {
                                    swap(i, j);
                                    swapsmall(year[i], year[j]);
                                } else if (year[i] == year[j]) {
                                    if (month[i] < month[j]) {
                                        swap(i, j);
                                        swapsmall(year[i], year[j]);
                                        swapsmall(month[i], month[j]);
                                    } else if (month[i] == month[j]) {
                                        if (day[i] < day[j]) {
                                            swap(i, j);
                                            swapsmall(day[i], day[j]);
                                            swapsmall(month[i], month[j]);
                                            swapsmall(year[i], year[j]);
                                        }
                                    }
                                }
                            }
                        }
                        this.ghiFile();
                        break;
                    case 3:
                        for (int i = 0; i < soluong; i++) {
                            String[] a = maphieu[i].split("");
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
                        break;
                    case 4:
                        for (int i = 0; i < soluong; i++) {
                            String[] a = maphieu[i].split("");
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
                        break;
                }
                System.out.println("Cap nhat thanh cong");
            }
        } catch (NumberFormatException e) {
            System.out.println("Cap nhat that bai");
        }
    }

    public void swapsmall(int a, int b) {
        int temp = 0;
        temp = a;
        a = b;
        b = temp;
    }

    public void swap(int num, int num2) {
        String temp_1;
        int temp;

        temp = this.songaythue[num];
        this.songaythue[num] = this.songaythue[num2];
        this.songaythue[num2] = temp;

        temp_1 = this.maphieu[num];
        this.maphieu[num] = this.maphieu[num2];
        this.maphieu[num2] = temp_1;

        temp_1 = this.makh[num];
        this.makh[num] = this.makh[num2];
        this.makh[num2] = temp_1;

        temp_1 = this.pttt[num];
        this.pttt[num] = this.pttt[num2];
        this.pttt[num2] = temp_1;

        temp_1 = this.ngay[num];
        this.ngay[num] = this.ngay[num2];
        this.ngay[num2] = temp_1;
    }

    @Override
    public void Remove() throws IOException {
        this.docFile();
        int x = 0;
        int chon = 1;
        System.out.println("ID ma phieu muon xoa: ");
        String remove = String.valueOf(sc.nextLine());
        do {
            switch (chon) {
                case 1:
                    for (int i = 0; i < soluong; i++) {
                        if (this.maphieu[i].equalsIgnoreCase(remove)) {
                            x = 1;
                            for (int j = i; j < soluong - 1; j++) {
                                this.maphieu[j] = this.maphieu[j + 1];
                                this.pttt[j] = this.pttt[j + 1];
                                this.makh[j] = this.makh[j + 1];
                                this.ngay[j] = this.ngay[j + 1];
                                this.songaythue[j] = this.songaythue[j + 1];
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
            System.out.println("1.Tiep tuc xoa");
            System.out.println("2.Thoat");
            System.out.println("================");
            System.out.print("Chon: ");
            chon = Integer.valueOf(sc.nextLine());
            if (chon > 2 || chon < 1) {
                System.out.println("Lua chon khong hop le");
                chon = 2;
            }
        } while (chon != 2);
        this.ghiFile();
    }
}
