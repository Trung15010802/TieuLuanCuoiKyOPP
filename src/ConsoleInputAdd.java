public class ConsoleInputAdd extends ConsoleInput {
    @Override
    HangHoa nhapHH() {
        System.out.print("Nhập mã hàng: ");
        String maHang = sc.nextLine();
        HangHoa hangHoa = super.nhapHH();
        if (hangHoa instanceof DienMay)
            hangHoa.setMaHang(maHang);
        else if (hangHoa instanceof ThucPham)
            hangHoa.setMaHang(maHang);
        else
            hangHoa.setMaHang(maHang);
        return  hangHoa;
    }
}
