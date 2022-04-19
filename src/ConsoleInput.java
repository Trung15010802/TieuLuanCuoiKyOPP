import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConsoleInput {
    public Scanner sc = new Scanner(System.in);
    private SimpleDateFormat spDate = new SimpleDateFormat("dd/MM/yyyy");

    public SimpleDateFormat getSpDate() {
        return spDate;
    }

    HangHoa nhapHH() {
        try { // Try catch lỗi nhập sai kiểu dữ liệu
            HangHoa hangHoa = null;
            System.out.print("Nhập tên hàng: ");
            String tenHang = sc.nextLine();
            System.out.print("Số lượng tồn kho: ");
            int soLuongTon = sc.nextInt();
            System.out.print("Nhập đơn giá: ");
            double donGia = sc.nextDouble();
            System.out.print("Chọn loại hàng hoá (Thực phẩm: 1)(Điện máy: 2)(Sành sứ: 3): ");
            int chon = sc.nextInt();
            sc.nextLine();
            if (chon == 1) {
                System.out.print("Nhập ngày sản xuất: ");
                String ngaySanXuat = sc.nextLine();
                System.out.print("Nhập ngày hết hạn: ");
                String ngayHetHan = sc.nextLine();
                System.out.print("Nhập nhà cung cấp: ");
                String nhaCungCap = sc.nextLine();
                try {
                    hangHoa = new ThucPham(tenHang, soLuongTon, donGia, spDate.parse(ngaySanXuat),
                            spDate.parse(ngayHetHan), nhaCungCap);
                } catch (ParseException e) {
                    System.out.println("Bạn đã nhập sai định dạng ngày tháng dd/MM/yyyy");
                }
            } else if (chon == 2) {
                System.out.print("Nhập thời gian bảo hành(tháng): ");
                int thoiGianBaoHanh = sc.nextInt();
                System.out.print("Nhập công suất(w): ");
                double congSuat = sc.nextDouble();
                hangHoa = new DienMay(tenHang, soLuongTon, donGia, thoiGianBaoHanh, congSuat);
            } else if (chon == 3) {
                System.out.print("Nhập nhà sản xuất: ");
                String nhaSanXuat = sc.nextLine();
                System.out.print("Nhập ngày nhập kho: ");
                String ngayNhapKho = sc.nextLine();
                try {
                    hangHoa = new SanhSu(tenHang, soLuongTon, donGia, nhaSanXuat, spDate.parse(ngayNhapKho));
                } catch (ParseException e) {
                    System.out.println("Bạn đã nhập sai định dạng ngày tháng dd/MM/yyyy");
                }
            } else
                System.out.println("Lựa chọn không hợp lệ!");
            return hangHoa;
        } catch (InputMismatchException e) {
            System.out.println("Bạn đã nhập sai định dạng dữ liệu!");
        }
        return null;

    }

}
