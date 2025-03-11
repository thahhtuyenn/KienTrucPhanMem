package observerDesignPattern;

public class Student implements Observer{
    private int id;
    private String fullName;

    public Student(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    @Override
    public void update() {
        System.out.println("Thong bao den sinh vien: " + fullName);
    }
}
