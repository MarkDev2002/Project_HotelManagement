package DOAN;

import java.io.IOException;

public class ChiTietDatPhong extends PhieuDatPhong {
    protected DichVu dv;
    protected int[] gia;

    public ChiTietDatPhong() throws IOException {
        super();
        dv = new DichVuKhac();
        gia = new int[100];
    }

    public static void table() {
        for (int i = 0; i < 84; i++) {
            if (i == 0 || i == 11 || i == 37 || i == 63 || i == 72 || i == 83) System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();
        System.out.printf("|%-10s|%-25s|%-25s|%-8s|%-10s|\n", "ID", "Ngay bat dau thue phong", "Thoi gian thue(ngay)", "ID phong", "Gia");
        for (int i = 0; i < 84; i++) {
            if (i == 0 || i == 11 || i == 37 || i == 63 || i == 72 || i == 83) System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        ChiTietDatPhong ct = new ChiTietDatPhong();
        ct.view();
    }

    public void price(int j, String ma) throws IOException {
        phgt = new PhongTHUONG();
        phgv = new PhongVIP();
        phgt.docFile();
        phgv.docFile();
        for (int i = 0; i < phgt.soluong; i++) {
            if (ma.equalsIgnoreCase(phgt.ma[i])) this.gia[j] = phgt.DonGia[i];
        }
        for (int i = 0; i < phgv.soluong; i++) {
            if (ma.equalsIgnoreCase(phgv.ma[i])) this.gia[j] = phgv.DonGia[i];
        }
    }

    public void view() throws IOException {
        this.docFile();
        System.out.print("Hay nhap ma phieu muon xem chi tiet: ");
        String mp = String.valueOf(sc.nextLine());
        table();
        for (int j = 0; j < soluong; j++) {
            if (mp.equalsIgnoreCase(maphieu[j])) {
                String[] cut = maphong[j].split(" ");
                int dem = cut.length;
                for (String s : cut) {
                    this.gia[j] = 0;
                    price(j, s);
                    System.out.printf("|%-10s|%-25s|%-25s|%-8s|%-10d|\n", maphieu[j], ngay[j], songaythue[j], s, gia[j]);
                }
            }

        }
        for (int i = 0; i < 84; i++) {
            if (i == 0 || i == 11 || i == 37 || i == 63 || i == 72 || i == 83) System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();
    }
}
