import java.util.Date;

public class ThucPham extends HangHoa {
    private Date ngaySanXuat;
    private Date ngayHetHan;

    public ThucPham() { // Hàm tạo mặc định
    }

    public ThucPham(String maHang, String tenHang, int soLuongTon, double donGia, Date ngaySanXuat, Date ngayHetHan,
            String nhaCungCap) { // Hàm tạo đầy đủ tham số
        super(maHang, tenHang, soLuongTon, donGia);
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
    }

    public ThucPham(String tenHang, int soLuongTon, double donGia, Date ngaySanXuat, Date ngayHetHan,
            String nhaCungCap) { // Hàm tạo không có mã hàng dùng để sửa thông tin hàng hoá
        super(tenHang, soLuongTon, donGia);
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
    }

    /** Gettter and setter có ràng buộc theo đề bài */
    public void setNgayHetHan(Date ngayHetHan) {
        if (ngayHetHan.after(ngaySanXuat))
            this.ngayHetHan = ngayHetHan;
        else
            System.out.println("Ngày hết hạn phải sau ngày sản xuất!");
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    @Override
    public double VAT() { // Thuế VAT
        return getDonGia() * 0.05;
    }

    @Override
    public String danhGia() { // Đánh giá hàng hoá điện máy
        Date toDay = new Date();
        if (getSoLuongTon() > 0 && ngayHetHan.after(toDay))
            return "Khó bán";
        return "Không đánh giá!";
    }

    @Override
    public String toString() { // Ghi đè toString
        ConsoleInput spDate = new ConsoleInput();
        return super.toString() + String.format("Loai hang: thuc pham\tNgay san xuat: %-15s Ngay het han: %s",
                spDate.getSpDate().format(ngaySanXuat), spDate.getSpDate().format(ngayHetHan));
    }

}
