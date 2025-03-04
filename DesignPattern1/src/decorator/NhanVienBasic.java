package decorator;

public class NhanVienBasic implements NhanVien{
    @Override
    public void congViec() {
        System.out.println("Chưa có chức vụ cụ thể");
    }
}
