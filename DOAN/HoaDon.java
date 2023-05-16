package DOAN;

import java.io.IOException;

public class HoaDon extends PhieuDatPhong {
    protected static PhieuDatPhong pdp;
    protected int[] gia;
    protected int tongHD;
    protected String[] maHD;
    protected String[] ngaytraphong;

    public HoaDon() throws IOException {
        super();
        ngaytraphong = new String[100];
        pdp = new PhieuDatPhong();
        gia = new int[100];
        maHD = new String[100];
        bath = "D:\\OOPJava\\src\\Project\\hoadon.txt";
    }

    public static void table() {
        for (int i = 0; i < 112; i++) {
            if (i == 0 || i == 11 || i == 22 || i == 37 || i == 63 || i == 74 || i == 85 || i == 111)
                System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();
        System.out.printf("|%-10s|%-10s|%-14s|%-25s|%-10s|%-10s|%-25s|\n", "ID", "Ma phieu", "Ma khach hang", "Phuong thuc thanh toan", "ID phong", "Gia", "Ngay tra phong");
        for (int i = 0; i < 112; i++) {
            if (i == 0 || i == 11 || i == 22 || i == 37 || i == 63 || i == 74 || i == 85 || i == 111)
                System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        HoaDon hd = new HoaDon();
        //hd.xuatHoaDon();
        //hd.TongHoaDon();
        //System.out.println(hd.tongHD);
        hd.xuatHoaDon();
        hd.ListHD();
        System.out.println(hd.countHoaDon());
    }

    public int countHoaDon() throws IOException {
        this.docFile();
        return this.soluong;
    }

    public void SumPrice(int j, String[] ma, int k) throws IOException {
        phgt = new PhongTHUONG();
        phgv = new PhongVIP();
        phgt.docFile();
        phgv.docFile();
        gia[j] = 0;
        int count = ma.length;
        for (int g = 0; g < count; g++) {
            for (int i = 0; i < phgt.soluong; i++) {
                if (ma[g].equalsIgnoreCase(phgt.ma[i])) {
                    gia[j] += phgt.DonGia[i];
                    phgt.tt[i] = "CON PHUC VU";
                }
            }
            for (int i = 0; i < phgv.soluong; i++) {
                if (ma[g].equalsIgnoreCase(phgv.ma[i])) {
                    gia[j] += phgv.DonGia[i];
                    phgv.tt[i] = "CON PHUC VU";
                }
            }
        }
        gia[j] += (Integer.valueOf(pdp.songaythue[k]) - 1) * 50000;
        phgt.ghiFile();
        phgv.ghiFile();
    }

    public void tinhHDvaNgayTraPhong() throws IOException {
        int ngay, thang, nam;
        for (int j = 0; j < pdp.soluong; j++) {
            if (this.maphieu[this.soluong].equalsIgnoreCase(pdp.maphieu[j])) {
                String[] cut = pdp.maphong[j].split(" ");
                SumPrice(this.soluong, cut, j);
                String[] cut2 = pdp.ngay[j].split("/");
                ngay = Integer.valueOf(cut2[0]);
                thang = Integer.valueOf(cut2[1]);
                nam = Integer.valueOf(cut2[2]);
                if (thang == 2) {
                    ngay += pdp.songaythue[j];
                    if (ngay > 28) {
                        ngay -= 28;
                        thang++;
                        if (thang > 12) {
                            thang -= 12;
                            nam += 1;
                        }
                    }
                } else if (thang == 1 || thang == 3 || thang == 5 || thang == 7 || thang == 12) {
                    ngay += pdp.songaythue[j];
                    if (ngay > 31) {
                        ngay -= 31;
                        thang++;
                        if (thang > 12) {
                            thang -= 12;
                            nam++;
                        }
                    }
                } else {
                    ngay += pdp.songaythue[j];
                    if (ngay > 30) {
                        ngay -= 30;
                        thang++;
                        if (thang > 12) {
                            thang -= 12;
                            nam += 1;
                        }
                    }
                }
                ngaytraphong[this.soluong] = Integer.toString(ngay) + "/" + Integer.toString(thang) + "/" + Integer.toString(nam);
            }
        }
    }

    @Override
    public void Parse(String line, int num) {
        String[] param = line.split(",");
        maHD[num] = param[0];
        maphieu[num] = param[1];
        makh[num] = param[2];
        pttt[num] = param[3];
        maphong[num] = param[4];
        gia[num] = Integer.parseInt(param[5]);
        ngaytraphong[num] = param[6];
    }

    @Override
    public String writeline(int i) {
        return maHD[i] + "," + maphieu[i] + "," + makh[i] + "," + pttt[i] + "," + maphong[i] + "," + gia[i] + "," + ngaytraphong[i] + "\n";
    }

    public void xuatHoaDon() throws IOException {
        pdp.docFile();
        this.docFile();
        pdp.ListPDP();
        int check2 = 0;
        int check = this.soluong;
        System.out.print("Hay nhap ma phieu dat phong muon xuat hoa don: ");
        String mp = String.valueOf(sc.nextLine());
        for (int j = 0; j < pdp.soluong; j++) {
            for (int i = 0; i < this.soluong; i++)
                if (mp.equalsIgnoreCase(this.maphieu[i])) {
                    check2 = 1;
                    break;
                }
            if (check2 == 1) {
                System.out.println("Ma phieu da thanh toan hoa don");
                break;
            } else if (mp.equalsIgnoreCase(pdp.maphieu[j]) || mp.toUpperCase().equalsIgnoreCase(pdp.maphieu[j])) {
                this.maphieu[this.soluong] = pdp.maphieu[j];
                this.makh[this.soluong] = pdp.makh[j];
                this.pttt[this.soluong] = pdp.pttt[j];
                this.tinhHDvaNgayTraPhong();
                this.maphong[this.soluong] = pdp.maphong[j];
                this.maHD[this.soluong] = "HD" + (this.soluong);
                this.soluong++;
                break;
            }
        }
        if (this.soluong == check) System.out.println("Xuat hoa don that bai");
        this.ghiFile();
    }

    public void ListHD() throws IOException {
        this.docFile();
        table();
        for (int j = 0; j < soluong; j++) {
            System.out.printf("|%-10s|%-10s|%-14s|%-25s|%-10s|%-10d|%-25s|\n", maHD[j], maphieu[j], makh[j], pttt[j], maphong[j], gia[j], ngaytraphong[j]);
        }
        for (int i = 0; i < 112; i++) {
            if (i == 0 || i == 11 || i == 22 || i == 37 || i == 63 || i == 74 || i == 85 || i == 111)
                System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();
    }

    public void TongHoaDon() throws IOException {
        this.docFile();
        tongHD = 0;
        for (int i = 0; i < this.soluong; i++) {
            tongHD += this.gia[i];
        }
    }
}
