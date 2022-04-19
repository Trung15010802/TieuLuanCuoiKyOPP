public class DienMay extends HangHoa {
    private int thoiGianBaoHanh;
    private double congSuat;

    public DienMay(String tenHang, int soLuongTon, double donGia, int thoiGianBaoHanh, double congSuat) {// Hàm tạo
                                                                                                         // không có mã
                                                                                                         // hàng dùng để
                                                                                                         // sửa thông
                                                                                                         // tin hàng
                                                                                                         // điện máy
        super(tenHang, soLuongTon, donGia);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.congSuat = congSuat;
    }

    public DienMay(String maHang, String tenHang, int soLuongTon, double donGia, int thoiGianBaoHanh, double congSuat) { // Hàm
                                                                                                                         // tạo
                                                                                                                         // đầy
                                                                                                                         // đủ
                                                                                                                         // thông
                                                                                                                         // tin
        super(maHang, tenHang, soLuongTon, donGia);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.congSuat = congSuat;
    }

    /** Gettter and setter có ràng buộc theo đề bài */
    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        if (thoiGianBaoHanh >= 0)
            this.thoiGianBaoHanh = thoiGianBaoHanh;
        else
            System.out.println("Thời gian bảo hành phải >= 0");
    }

    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setCongSuat(double congSuat) {
        if (congSuat > 0)
            this.congSuat = congSuat;
        else
            System.out.println("Công suất phải > 0!");
    }

    public double getCongSuat() {
        return congSuat;
    }

    @Override
    public double VAT() { // Tính thuế VAT hàng điện máy
        return getDonGia() * 0.1;
    }

    @Override
    public String danhGia() {// Đánh giá hàng điện máy
        if (getSoLuongTon() < 3)
            return "Bán được!";
        return "Không đánh giá!";
    }

    @Override
    public String toString() { // Ghi đè toString điện máy
        return super.toString() + String.format("Loai hang: dien may\t\tCong suat: %-18.0f  Thoi gian bao hanh: %s", congSuat,
                thoiGianBaoHanh);
    }

}
