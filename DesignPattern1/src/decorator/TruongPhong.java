package decorator;

public class TruongPhong extends NhanVienDecorator{
    public TruongPhong(NhanVien nhanVien) {
        super(nhanVien);
    }

    @Override
    public void congViec() {
        super.congViec();
        System.out.println("Chức vụ: trưởng phòng. Công việc: giám sát nhân viên theo phòng ban");
    }
}
