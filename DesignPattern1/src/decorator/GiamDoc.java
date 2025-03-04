package decorator;

public class GiamDoc extends NhanVienDecorator {
    public GiamDoc(NhanVien nhanVien) {
        super(nhanVien);
    }

    @Override
    public void congViec() {
        super.congViec();
        System.out.println("Chức vụ: giám đốc. Công việc: quản lý tất cả nhân viên");
    }
}
