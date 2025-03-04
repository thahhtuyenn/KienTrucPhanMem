package nonDesignPattern;

public class Employee {
    private String chucvu;

    public Employee(String chucvu) {
        this.chucvu = chucvu;
    }

    public String congViecCaNhan(){
        String congViec = "";
        if (chucvu.equalsIgnoreCase("Giám đốc")){
            congViec = chucvu + " quản lý công ty";
        } else if (chucvu.equalsIgnoreCase("Trưởng phòng")) {
            congViec = chucvu + " quản lý nhân viên theo phòng ban";
        } else if (chucvu.equalsIgnoreCase("Nhân viên văn phòng")) {
            congViec = chucvu + " thực hiện các công việc trên máy tính, in ấn tài liệu";
        } else if (chucvu.equalsIgnoreCase("Lao công")) {
            congViec = chucvu + " có trách nhiệm dọn dẹp vệ sinh công ty";
        }else {
            congViec = "Chưa phải nhân vie công ty";
        }

        return congViec;
    }
}
