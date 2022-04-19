import java.util.Date;

public class SanhSu extends HangHoa {
    private Date ngayNhapKho;
    private String nhaSanXuat;

    public SanhSu() { // Hàm tạo mặc định
    }

    public SanhSu(String tenHang, int soLuongTon, double donGia, String nhaSanXuat, Date ngayNhapKho) { // Hàm tạo thiếu
                                                                                                        // mã hàng dùng
                                                                                                        // để sửa thông
                                                                                                        // tin hàng hoá
        super(tenHang, soLuongTon, donGia);
        this.ngayNhapKho = ngayNhapKho;
    }

    public SanhSu(String maHang, String tenHang, int soLuongTon, double donGia, Date ngayNhapKho, String nhaSanXuat) {// Hàm
                                                                                                                      // tạo
                                                                                                                      // đầy
                                                                                                                      // đủ
                                                                                                                      // thông
                                                                                                                      // tin
        super(maHang, tenHang, soLuongTon, donGia);
        this.ngayNhapKho = ngayNhapKho;
        this.nhaSanXuat = nhaSanXuat;
    }

    @Override
    public double VAT() { // Thuế VAT hàng sành sứ
        return getDonGia() * 0.1;
    }

    @Override
    public String danhGia() { // Đánh giá hàng sành sứ
        Date toDay = new Date();
        long thoiGianLuuKho = (toDay.getTime() - ngayNhapKho.getTime()) / (24 * 60 * 60 * 1000);
        if (thoiGianLuuKho > 10 && this.getSoLuongTon() > 50)
            return "Bán chậm!";
        return "Không đánh giá";
    }

    @Override
    public String toString() { // Ghi đề toString sành sứ
        ConsoleInput SpDate = new ConsoleInput();
        return super.toString() + String.format("Loai hang: sanh su\t\tNgay nhap kho: %-15s Nha san xuat: %s",
                SpDate.getSpDate().format(ngayNhapKho), nhaSanXuat);
    }

}
