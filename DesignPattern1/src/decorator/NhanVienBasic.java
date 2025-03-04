package decorator;

public class NhanVienBasic implements NhanVien{
    @Override
    public void congViec() {
        System.out.println("Là nhân viên của công ty");
    }
}
