public abstract class HangHoa {
    private String maHang;
    private String tenHang;
    private int soLuongTon;
    private double donGia;

    public HangHoa() {
    }

    public HangHoa(String maHang, String tenHang, int soLuongTon, double donGia) {// Hàm tạo đầy đủ thông tin
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
    }

    public HangHoa(String tenHang, int soLuongTon, double donGia) { // Hàm tạo thiếu mã hàng
        this.tenHang = tenHang;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
    }

    public abstract double VAT(); // Abstract method tính VAT

    public abstract String danhGia(); // Abstract method đánh giá sản phẩm

    public void setMaHang(String maHang) {
        if (maHang != null)
            this.maHang = maHang;
        else
            System.out.println("Mã hàng không được rỗng!");
    }

    /** Getter and setter theo ràng buộc của đề bài */
    public String getMaHang() {
        return maHang;
    }

    public void setTenHang(String tenHang) {
        if (tenHang != null)
            this.tenHang = tenHang;
        else
            System.out.println("Tên hàng không được để trống!");
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setSoLuongTon(int soLuongTon) {
        if (soLuongTon >= 0)
            this.soLuongTon = soLuongTon;
        else
            System.out.println("Số lượng tồn kho phải lớn hơn hoắc bằng 0!");
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setDonGia(double donGia) {
        if (donGia > 0)
            this.donGia = donGia;
        else
            System.out.println("Đơn giá phải lớn hơn 0 !");
    }

    public double getDonGia() {
        return donGia;
    }

    @Override
    public String toString() {
        return String.format("->Ma hang: %-10sTen hang: %-18sDon gia: %-18fSo luong ton kho: %-10d", maHang, tenHang,
                donGia, soLuongTon);

    }

}
