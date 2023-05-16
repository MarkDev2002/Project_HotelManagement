package DOAN;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    static PhieuDatPhong pdp;
    static HoaDon hd;
    static Scanner sc = new Scanner(System.in);

    public static void Admin() {
        System.out.println("============MENU============");
        System.out.println("1.Quan ly nhan vien");
        System.out.println("2.Quan ly dich vu");
        System.out.println("3.Quan ly phong");
        System.out.println("4.Quan ly phieu dat phong");
        System.out.println("5.Xem thong ke");
        System.out.println("6.Thoat");
        System.out.println("============================");
    }

    public static void QuanLy() {
        System.out.println("============MENU============");
        System.out.println("1.Xem menu");
        System.out.println("2.Them");
        System.out.println("3.Xoa");
        System.out.println("4.Sap xep");
        System.out.println("5.Loc");
        System.out.println("6.Sua thong tin");
        System.out.println("7.Thoat");
        System.out.println("============================");
    }

    public static void main(String[] args) throws IOException {
        int chon = 0;

        String user, password;
        int a = 0;
        do {
            System.out.print("Enter user : ");
            user = String.valueOf(sc.nextLine());
            System.out.print("Enter password : ");
            password = String.valueOf(sc.nextLine());
            if (user.equals("admin") && password.equals("1")) {
                System.out.println("Welcome back");
                a = 1;
                break;
            } else {
                System.out.println("Wrong user or password");
            }
        } while (a == 0);

        do {
            try {
                Admin();
                System.out.print("Chon: ");
                chon = Integer.parseInt(sc.nextLine());
                if (chon < 1 || chon > 6) {
                    System.out.println("Khong hop le");
                    chon = 6;
                } else {
                    switch (chon) {
                        case 1:
                            do {
                                NhanVien nv = new NhanVien();
                                QuanLy();
                                System.out.print("Chon: ");
                                chon = Integer.parseInt(sc.nextLine());
                                if (chon < 1 || chon > 7) {
                                    System.out.println("Khong hop le");
                                    chon = 7;
                                } else {
                                    switch (chon) {
                                        case 1:
                                            nv.EmployeeList();
                                            break;
                                        case 2:
                                            nv.Add();
                                            break;
                                        case 3:
                                            nv.Remove();
                                            break;
                                        case 4:
                                            nv.Sort();
                                            break;
                                        case 5:
                                            nv.Filter();
                                            break;
                                        case 6:
                                            nv.FixInfMenu();
                                            break;
                                        case 7:
                                            break;
                                    }
                                }
                            } while (chon != 7);
                            break;
                        case 2:
                            do {
                                DichVu dvk = new DichVuKhac();
                                DichVu dva = new DichVuAnUong();
                                QuanLy();
                                System.out.println("Chon: ");
                                chon = Integer.parseInt(sc.nextLine());
                                if (chon < 1 || chon > 7) {
                                    System.out.println("Khong hop le");
                                    chon = 7;
                                } else {
                                    switch (chon) {
                                        case 1:
                                            System.out.println("1. Dich vu an uong");
                                            System.out.println("2. Dich vu khac");
                                            System.out.println("3.Thoat");
                                            System.out.println("=====================");
                                            System.out.println("Chon: ");
                                            chon = Integer.parseInt(sc.nextLine());
                                            if (chon < 1 || chon > 3) {
                                                System.out.println("Khong hop le");
                                                chon = 3;
                                            } else {
                                                switch (chon) {
                                                    case 1:
                                                        dva.menu();
                                                        break;
                                                    case 2:
                                                        dvk.menu();
                                                        break;
                                                    case 3:
                                                        break;
                                                }
                                            }
                                        case 2:
                                            System.out.println("1. Dich vu an uong");
                                            System.out.println("2. Dich vu khac");
                                            System.out.println("3.Thoat");
                                            System.out.println("=====================");
                                            System.out.println("Chon: ");
                                            chon = Integer.parseInt(sc.nextLine());
                                            if (chon < 1 || chon > 3) {
                                                System.out.println("Khong hop le");
                                                chon = 3;
                                            } else {
                                                switch (chon) {
                                                    case 1:
                                                        dva.Add();
                                                        break;
                                                    case 2:
                                                        dvk.Add();
                                                        break;
                                                    case 3:
                                                        break;
                                                }
                                            }
                                        case 3:
                                            System.out.println("1. Dich vu an uong");
                                            System.out.println("2. Dich vu khac");
                                            System.out.println("3.Thoat");
                                            System.out.println("=====================");
                                            System.out.println("Chon: ");
                                            chon = Integer.parseInt(sc.nextLine());
                                            if (chon < 1 || chon > 3) {
                                                System.out.println("Khong hop le");
                                                chon = 3;
                                            } else {
                                                switch (chon) {
                                                    case 1:
                                                        dva.Remove();
                                                        break;
                                                    case 2:
                                                        dvk.Remove();
                                                        break;
                                                    case 3:
                                                        break;
                                                }
                                            }
                                        case 4:
                                            System.out.println("1. Dich vu an uong");
                                            System.out.println("2. Dich vu khac");
                                            System.out.println("3.Thoat");
                                            System.out.println("=====================");
                                            System.out.println("Chon: ");
                                            chon = Integer.parseInt(sc.nextLine());
                                            if (chon < 1 || chon > 3) {
                                                System.out.println("Khong hop le");
                                                chon = 3;
                                            } else {
                                                switch (chon) {
                                                    case 1:
                                                        dva.Sort();
                                                        break;
                                                    case 2:
                                                        dvk.Sort();
                                                        break;
                                                    case 3:
                                                        break;
                                                }
                                            }
                                        case 5:
                                            System.out.println("1. Dich vu an uong");
                                            System.out.println("2. Dich vu khac");
                                            System.out.println("3.Thoat");
                                            System.out.println("=====================");
                                            System.out.println("Chon: ");
                                            chon = Integer.valueOf(sc.nextLine());
                                            if (chon < 1 || chon > 3) {
                                                System.out.println("Khong hop le");
                                                chon = 3;
                                            } else {
                                                switch (chon) {
                                                    case 1:
                                                        dva.Filter();
                                                        break;
                                                    case 2:
                                                        dvk.Filter();
                                                        break;
                                                    case 3:
                                                        break;
                                                }
                                            }
                                        case 6:
                                            System.out.println("1. Dich vu an uong");
                                            System.out.println("2. Dich vu khac");
                                            System.out.println("3.Thoat");
                                            System.out.println("=====================");
                                            System.out.println("Chon: ");
                                            chon = Integer.valueOf(sc.nextLine());
                                            if (chon < 1 || chon > 3) {
                                                System.out.println("Khong hop le");
                                                chon = 3;
                                            } else {
                                                switch (chon) {
                                                    case 1:
                                                        System.out.println("1.Sua gia");
                                                        System.out.println("2.Cap nhat tinh trang");
                                                        System.out.println("3.Thoat");
                                                        System.out.println("=====================");
                                                        System.out.println("Chon: ");
                                                        chon = Integer.valueOf(sc.nextLine());
                                                        if (chon < 1 || chon > 3) {
                                                            System.out.println("Khong hop le");
                                                            chon = 3;
                                                        } else {
                                                            switch (chon) {
                                                                case 1:
                                                                    dva.fixPrice();
                                                                    break;
                                                                case 2:
                                                                    dva.capnhatTinhTrang();
                                                                    break;
                                                                case 3:
                                                                    break;
                                                            }
                                                        }
                                                        break;
                                                    case 2:
                                                        System.out.println("1.Sua gia");
                                                        System.out.println("2.Cap nhat tinh trang");
                                                        System.out.println("3.Thoat");
                                                        System.out.println("=====================");
                                                        System.out.println("Chon: ");
                                                        chon = Integer.valueOf(sc.nextLine());
                                                        if (chon < 1 || chon > 3) {
                                                            System.out.println("Khong hop le");
                                                            chon = 3;
                                                        } else {
                                                            switch (chon) {
                                                                case 1:
                                                                    dvk.fixPrice();
                                                                    break;
                                                                case 2:
                                                                    dvk.capnhatTinhTrang();
                                                                    break;
                                                                case 3:
                                                                    break;
                                                            }
                                                        }
                                                        break;
                                                    case 3:
                                                        break;
                                                }
                                            }
                                        case 7:
                                            break;
                                    }
                                }
                            } while (chon != 7);
                            break;
                        case 3:
                            do {
                                Phong pt = new PhongTHUONG();
                                Phong pv = new PhongVIP();
                                QuanLy();
                                System.out.println("Chon: ");
                                chon = Integer.valueOf(sc.nextLine());
                                if (chon < 1 || chon > 7) {
                                    System.out.println("Khong hop le");
                                    chon = 7;
                                } else {
                                    switch (chon) {
                                        case 1:
                                            System.out.println("1.Phong thuong");
                                            System.out.println("2.Phong vip");
                                            System.out.println("3.Thoat");
                                            System.out.println("=====================");
                                            System.out.println("Chon: ");
                                            chon = Integer.valueOf(sc.nextLine());
                                            if (chon < 1 || chon > 3) {
                                                System.out.println("Khong hop le");
                                                chon = 3;
                                            } else {
                                                switch (chon) {
                                                    case 1:
                                                        pt.menu();
                                                        break;
                                                    case 2:
                                                        pv.menu();
                                                        break;
                                                    case 3:
                                                        break;
                                                }
                                            }
                                        case 2:
                                            System.out.println("1.Phong thuong");
                                            System.out.println("2.Phong vip");
                                            System.out.println("3.Thoat");
                                            System.out.println("=====================");
                                            System.out.println("Chon: ");
                                            chon = Integer.valueOf(sc.nextLine());
                                            if (chon < 1 || chon > 3) {
                                                System.out.println("Khong hop le");
                                                chon = 3;
                                            } else {
                                                switch (chon) {
                                                    case 1:
                                                        pt.Add();
                                                        break;
                                                    case 2:
                                                        pv.Add();
                                                        break;
                                                    case 3:
                                                        break;
                                                }
                                            }
                                        case 3:
                                            System.out.println("1.Phong thuong");
                                            System.out.println("2.Phong vip");
                                            System.out.println("3.Thoat");
                                            System.out.println("=====================");
                                            System.out.println("Chon: ");
                                            chon = Integer.valueOf(sc.nextLine());
                                            if (chon < 1 || chon > 3) {
                                                System.out.println("Khong hop le");
                                                chon = 3;
                                            } else {
                                                switch (chon) {
                                                    case 1:
                                                        pt.Remove();
                                                        break;
                                                    case 2:
                                                        pv.Remove();
                                                        break;
                                                    case 3:
                                                        break;
                                                }
                                            }
                                        case 4:
                                            System.out.println("1.Phong thuong");
                                            System.out.println("2.Phong vip");
                                            System.out.println("3.Thoat");
                                            System.out.println("=====================");
                                            System.out.println("Chon: ");
                                            chon = Integer.valueOf(sc.nextLine());
                                            if (chon < 1 || chon > 3) {
                                                System.out.println("Khong hop le");
                                                chon = 3;
                                            } else {
                                                switch (chon) {
                                                    case 1:
                                                        pt.Sort();
                                                        break;
                                                    case 2:
                                                        pv.Sort();
                                                        break;
                                                    case 3:
                                                        break;
                                                }
                                            }
                                        case 5:
                                            System.out.println("1.Phong thuong");
                                            System.out.println("2.Phong vip");
                                            System.out.println("3.Thoat");
                                            System.out.println("=====================");
                                            System.out.println("Chon: ");
                                            chon = Integer.valueOf(sc.nextLine());
                                            if (chon < 1 || chon > 3) {
                                                System.out.println("Khong hop le");
                                                chon = 3;
                                            } else {
                                                switch (chon) {
                                                    case 1:
                                                        pt.Filter();
                                                        break;
                                                    case 2:
                                                        pv.Filter();
                                                        break;
                                                    case 3:
                                                        break;
                                                }
                                            }
                                        case 6:
                                            System.out.println("1.Phong thuong");
                                            System.out.println("2.Phong vip");
                                            System.out.println("3.Thoat");
                                            System.out.println("=====================");
                                            System.out.println("Chon: ");
                                            chon = Integer.valueOf(sc.nextLine());
                                            if (chon < 1 || chon > 3) {
                                                System.out.println("Khong hop le");
                                                chon = 3;
                                            } else {
                                                switch (chon) {
                                                    case 1:
                                                        System.out.println("1.Sua gia");
                                                        System.out.println("2.Cap nhat tinh trang");
                                                        System.out.println("3.Thoat");
                                                        System.out.println("=====================");
                                                        System.out.println("Chon: ");
                                                        chon = Integer.valueOf(sc.nextLine());
                                                        if (chon < 1 || chon > 3) {
                                                            System.out.println("Khong hop le");
                                                            chon = 3;
                                                        } else {
                                                            switch (chon) {
                                                                case 1:
                                                                    pt.fixPrice();
                                                                    break;
                                                                case 2:
                                                                    pt.capnhatTinhTrang();
                                                                    break;
                                                                case 3:
                                                                    break;
                                                            }
                                                        }
                                                        break;
                                                    case 2:
                                                        System.out.println("1.Sua gia");
                                                        System.out.println("2.Cap nhat tinh trang");
                                                        System.out.println("3.Thoat");
                                                        System.out.println("=====================");
                                                        System.out.println("Chon: ");
                                                        chon = Integer.valueOf(sc.nextLine());
                                                        if (chon < 1 || chon > 3) {
                                                            System.out.println("Khong hop le");
                                                            chon = 3;
                                                        } else {
                                                            switch (chon) {
                                                                case 1:
                                                                    pv.fixPrice();
                                                                    break;
                                                                case 2:
                                                                    pv.capnhatTinhTrang();
                                                                    break;
                                                                case 3:
                                                                    break;
                                                            }
                                                        }
                                                        break;
                                                    case 3:
                                                        break;
                                                }
                                            }
                                        case 7:
                                            break;
                                    }
                                }
                            } while (chon != 7);
                            break;
                        case 4:
                            do {
                                hd = new HoaDon();
                                pdp = new PhieuDatPhong();
                                ChiTietDatPhong ctdp = new ChiTietDatPhong();
                                System.out.println("============MENU============");
                                System.out.println("1.Xem menu");
                                System.out.println("2.Them");
                                System.out.println("3.Xoa");
                                System.out.println("4.Sap xep");
                                System.out.println("5.Loc");
                                System.out.println("6.Xem chi tiet");
                                System.out.println("7.Xem hoa don");
                                System.out.println("8.Thoat");
                                System.out.println("============================");
                                System.out.println("Chon: ");
                                chon = Integer.valueOf(sc.nextLine());
                                if (chon < 1 || chon > 8) {
                                    System.out.println("Khong hop le");
                                    chon = 8;
                                } else {
                                    switch (chon) {
                                        case 1:
                                            pdp.ListPDP();
                                            break;
                                        case 2:
                                            pdp.Add();
                                            break;
                                        case 3:
                                            pdp.Remove();
                                            break;
                                        case 4:
                                            pdp.Sort();
                                            break;
                                        case 5:
                                            pdp.Filter();
                                            break;
                                        case 6:
                                            ctdp.view();
                                            break;
                                        case 7:
                                            hd.xuatHoaDon();
                                            break;
                                        case 8:
                                            break;
                                    }
                                }
                            } while (chon != 8);
                            break;
                        case 5:
                            hd = new HoaDon();
                            NhanVien nv = new NhanVien();
                            nv.TongLuongNV();
                            hd.TongHoaDon();
                            System.out.println("Tong tien phai chi (cho nhan vien): " + nv.TongLuong);
                            System.out.println("Tong tien thu duoc (tu hoa don): " + hd.tongHD);
                            break;
                        case 6:
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Lua chon khong hop le");
            }
        } while (chon != 6);

    }
}