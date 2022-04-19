import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuanLyDanhSach {
    private List<HangHoa> list = new ArrayList<>();

    public List<HangHoa> getList() {
        return list;
    }

    ConsoleInput input = new ConsoleInput();

    HangHoa timKiem(String ma) { // Hàm tìm kiếm theo mã
        HangHoa hangHoa = null;
        for (HangHoa xHangHoa : list) {
            if (xHangHoa.getMaHang().equals(ma))
                return hangHoa = xHangHoa;
        }
        return hangHoa;
    }

    int timViTri(HangHoa hangHoa) { // Tìm vị trí của hàng hoá
        int viTri = list.indexOf(hangHoa);
        return viTri;
    }

    void checkMaHang(String maHang) { // Hàm kiểm tra mã hàng có đúng yêu cầu của đề không
        if (maHang == null || maHang == "") {
            System.out.println("Mã hàng không được bỏ trống!");
            return;
        }
        for (HangHoa hangHoa : list) {
            if (maHang.equals(hangHoa.getMaHang())) {
                System.out.println("Mã hàng đã bị trùng!");
                return;
            }
        }
    }

    void themHH(HangHoa hangHoa) { // Thêm hàng hoá vào danh sách
        checkMaHang(hangHoa.getMaHang());
        list.add(hangHoa);
    }

    void xoaHH(HangHoa hangHoa) { // Xoá hàng hoá
        list.remove(hangHoa);
    }

    void suaHH(int viTri, HangHoa hangHoa, String maHang) { // Sửa hàng hoá
        list.set(viTri, hangHoa); // Sửa thông tin hàng hoá
        hangHoa.setMaHang(maHang); // Giữ nguyên mã hàng hoá không đổi

    }

    void inDanhSach() { // In danh sách hàng hoá
        int i = 1;
        for (HangHoa hangHoa : list) {
            System.out.println("Hàng hoá thứ " + i + ": ");
            System.out.println(hangHoa.toString());
            i++;
        }
    }

    void thongKeSoLuong() { // Thống kê số lượng từng loại hàng hoá
        int SLDienMay = 0;
        int SLThucPham = 0;
        int SLSanhSu = 0;
        for (HangHoa hangHoa : list) {
            if (hangHoa instanceof DienMay)
                SLDienMay++;
            else if (hangHoa instanceof ThucPham)
                SLThucPham++;
            else
                SLSanhSu++;
        }
        System.out.println("Tổng số lượng hàng hoá: " + list.size());
        System.out.println("Số lượng hàng điện máy: " + SLDienMay);
        System.out.println("Số lượng hàng thực phẩm: " + SLThucPham);
        System.out.println("Số lượng hàng sành sứ: " + SLSanhSu);
    }

    void sortUpTheoGia() { // Sắp xếp tăng dần theo giá
        Collections.sort(list, new Comparator<HangHoa>() {

            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                return Double.compare(o1.getDonGia(), o2.getDonGia());
            }
        });
    }

    void sortDownTheoGia() { // Sắp xếp giảm dần theo giá
        Collections.reverse(list);
    }

    void duLieuHangHoa() {// dữ liệu mồi
        ConsoleInput inputSpDate = new ConsoleInput();
        list.add(new DienMay("dm01", "Tu lanh", 10, 9000000, 24, 240));
        list.add(new DienMay("dm02", "May giat", 20, 6000000, 12, 120));
        list.add(new DienMay("dm03", "May say toc", 15, 1000000, 3, 60));
        list.add(new DienMay("dm04", "Dieu hoa", 6, 10000000, 12, 300));
        try {
            list.add(new ThucPham("tp01", "Banh mi", 50, 20000, inputSpDate.getSpDate().parse("20/3/2022"),
                    inputSpDate.getSpDate().parse("30/4/2022"), "Kinh đô"));
            list.add(new ThucPham("tp02", "Banh quy", 100, 50000, inputSpDate.getSpDate().parse("5/3/2022"),
                    inputSpDate.getSpDate().parse("9/12/2022"), "Biscoff"));
            list.add(new ThucPham("tp03", "Mi tom hao hao", 500, 4000, inputSpDate.getSpDate().parse("30/1/2022"),
                    inputSpDate.getSpDate().parse("31/12/2022"), "Hảo hảo"));
            list.add(new SanhSu("ss01", "Chen su", 20, 10000, inputSpDate.getSpDate().parse("24/02/2022"),
                    "Lang gom Bat Trang"));
            list.add(new SanhSu("ss02", "To su", 10, 13000, inputSpDate.getSpDate().parse("4/02/2022"),
                    "Cong ty gom su Thang Long"));
            list.add(new SanhSu("ss03", "Dia su", 28, 15000, inputSpDate.getSpDate().parse("24/01/2022"),
                    "Gom Long An"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    void ghiFileDanhSach() { // Ghi danh sách ra file txt
        FileListWriting fileWriter = new FileListWriting();
        fileWriter.ghiFile("DanhSachHangHoa.txt", list);
    }

    void docFileDanhSach() { // Đọc file đã ghi lên màn hình console
        FileListReading fileReader = new FileListReading();
        fileReader.docFile("DanhSachHangHoa.txt");
    }

    void danhGiaHangHoa() { // Đánh giá hàng hoá
        for (HangHoa hangHoa : list) {
            System.out.println(hangHoa.getTenHang() + ": " + hangHoa.danhGia());
        }
    }

    void thueVAT() { // Tính thuế VAT hàng hoá
        int i = 0;
        for (HangHoa hangHoa : list) {
            System.out.println(i + ". " + hangHoa.getTenHang() + ": " + hangHoa.VAT());
            i++;
        }
    }

}
