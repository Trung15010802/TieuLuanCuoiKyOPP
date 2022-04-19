public class Menu {
    void menuTable() { // Menu lựa chọn chức năng
        ConsoleInput input = new ConsoleInput();
        QuanLyDanhSach danhSach = new QuanLyDanhSach();
        danhSach.duLieuHangHoa();
        do {
            System.out.println("--------------------MENU--------------------");
            System.out.println(">>1. Thêm hàng hoá vào danh sách");
            System.out.println(">>2. Sửa thông tin hàng hoá");
            System.out.println(">>3. Xoá hàng hoá theo mã hàng");
            System.out.println(">>4. In danh sách hàng hoá");
            System.out.println(">>5. Tìm kiếm hàng hoá theo mã hàng");
            System.out.println(">>6. Sắp xếp đơn giá tăng dần");
            System.out.println(">>7. Sắp xếp đơn giá giảm dần");
            System.out.println(">>8. In thống kê hàng hoá");
            System.out.println(">>9. In thuế VAT");
            System.out.println(">>10. Đánh giá các mặt hàng");
            System.out.println(">>11. Ghi danh sách hàng hoá ra file");
            System.out.println(">>12. Đọc file danh sách hàng hoá");
            System.out.println(">>0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            String key = input.sc.nextLine();
            switch (key) {
                case "1":
                    System.out.println("===========Thêm hàng hoá vào danh sách===========");
                    ConsoleInput consoleInput = new ConsoleInputAdd();
                    danhSach.themHH(consoleInput.nhapHH());
                    System.out.println("Thêm hàng hoá vào danh sách thành công!");
                    System.out.println("Đã ghi ra file DanhSachHangHoa.txt!");
                    danhSach.ghiFileDanhSach();
                    break;
                case "2":
                    System.out.println("===========Sửa thông tin hàng hoá===========");
                    ConsoleInput consoleInput2 = new ConsoleInputEdit();
                    System.out.print("Nhập mã hàng hoá cần sửa: ");
                    String ma = input.sc.nextLine();
                    if (ma == null) {
                        System.out.println("Không tìm thấy hàng hoá!");
                        return;
                    }
                    int viTri = danhSach.timViTri(danhSach.timKiem(ma)); // Tìm vị trí mã cần sửa
                    danhSach.suaHH(viTri, consoleInput2.nhapHH(), ma);
                    System.out.println("Đã ghi ra file DanhSachHangHoa.txt!");
                    danhSach.ghiFileDanhSach();
                    break;
                case "3":
                    System.out.println("===========Xoá hàng hoá===========");
                    System.out.print("Nhập mã hàng hoá cần xoá: ");
                    ma = input.sc.nextLine();
                    danhSach.xoaHH(danhSach.timKiem(ma));
                    System.out.println("Đã xoá!");
                    System.out.println("Đã ghi ra file DanhSachHangHoa.txt!");
                    danhSach.ghiFileDanhSach();
                    break;
                case "4":
                    System.out.println("======================Danh sách hàng hoá======================");
                    danhSach.inDanhSach();
                    break;
                case "5":
                    System.out.print("Nhập mã hàng hoá cần tìm: ");
                    ma = input.sc.nextLine();
                    if (danhSach.timKiem(ma) == null)
                        System.out.println("Không tìm thấy mã hàng hoá tương ứng!");
                    else
                        System.out.println(danhSach.timKiem(ma).toString());
                    break;
                case "6":
                    System.out.println("===========Sắp xếp theo giá tăng dần===========");
                    danhSach.sortUpTheoGia();
                    danhSach.inDanhSach();
                    break;
                case "7":
                    System.out.println("===========Sắp xếp theo giá giảm dần===========");
                    danhSach.sortDownTheoGia();
                    danhSach.inDanhSach();
                    break;
                case "8":
                    System.out.println("===========Thống kê số lượng hàng hoá===========");
                    danhSach.thongKeSoLuong();
                    break;
                case "9":
                    System.out.println("===========Thuế VAT===========");
                    danhSach.thueVAT();
                    break;
                case "10":
                    System.out.println("===========Đánh giá các mặt hàng===========");
                    danhSach.danhGiaHangHoa();
                    break;
                case "11":
                    System.out.println("===========Ghi danh sách ra file===========");
                    danhSach.ghiFileDanhSach();
                    System.out.println("Đã ghi ra file DanhSachHangHoa.txt");
                    break;
                case "12":
                    System.out.println("===========Đọc file danh sách===========");
                    danhSach.docFileDanhSach();
                    break;
                case "0":
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
            System.out.print("Nhấn ENTER để quay lại MENU!");
            input.sc.nextLine();
        } while (true);

    }
}
