package observerDesignPattern;

public class LopTruong implements Observer{

    private int id;
    private String fullName;

    public LopTruong(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
    @java.lang.Override
    public void update() {
        System.out.println("Thong bao den lop truong");
    }
}
