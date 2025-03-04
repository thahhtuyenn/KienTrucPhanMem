package state.congViecNhanVien;

import state.ChucVuState;

public class GiamDoc implements ChucVuState {
    @Override
    public String congViec() {
        return "Giám đốc quản lý công ty";
    }
}
