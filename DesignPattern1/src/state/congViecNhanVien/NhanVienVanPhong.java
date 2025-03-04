package state.congViecNhanVien;

import state.ChucVuState;

public class NhanVienVanPhong implements ChucVuState {
    @Override
    public String congViec() {
        return "Nhân viên làm việc với các tài liệu, hợp đồng";
    }
}
