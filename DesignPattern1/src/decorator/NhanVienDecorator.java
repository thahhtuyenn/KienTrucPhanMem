package decorator;

public class NhanVienDecorator implements NhanVien{
    protected NhanVien nhanVien;

    public NhanVienDecorator(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    @Override
    public void congViec() {
        System.out.println("Là nhân viên của công ty.");
    }
}
