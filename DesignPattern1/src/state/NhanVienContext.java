package state;

public class NhanVienContext {
    private ChucVuState chucVuState;
    public NhanVienContext(ChucVuState chucVu) {
        this.chucVuState = chucVu;
    }

    public NhanVienContext() {
    }

    //chuyển đổi chức vụ
    public void setChucVuState(ChucVuState chucVuState) {
        this.chucVuState = chucVuState;
    }

    public void thucHienCongViec(){
        System.out.println(chucVuState.congViec());
    }
}
