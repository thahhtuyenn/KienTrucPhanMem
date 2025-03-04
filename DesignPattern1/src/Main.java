import decorator.GiamDoc;
import decorator.NhanVien;
import decorator.NhanVienBasic;
import decorator.NhanVienDecorator;
import state.NhanVienContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //khong dùng DP
//        Employee emplNonDesignPattern = new Employee("Nhân viên văn phòng");
//        String congViecDamNhan = emplNonDesignPattern.congViecCaNhan();
//        System.out.println(congViecDamNhan);

        // state pattern
//        NhanVienContext nhanvien = new NhanVienContext();
//        nhanvien.setChucVuState(new GiamDoc());
//        nhanvien.thucHienCongViec();

        GiamDoc giamDoc = new GiamDoc(new NhanVienBasic());
        giamDoc.congViec();
    }
}