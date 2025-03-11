import observerDesignPattern.Clazz;
import observerDesignPattern.LopTruong;
import observerDesignPattern.Student;

public class Main {
    public static void main(String[] args) {
        Clazz clazz = new Clazz();

        Student student = new Student(1, "Thanh Tuyen");
        Student student2 = new Student(2, "Don Chung");
        Student student3 = new Student(3, "Thanh Nho");

        LopTruong lopTruong = new LopTruong(4, "Trung Hieu");

        clazz.attach(student);
        clazz.attach(student2);
        clazz.attach(student3);
        clazz.attach(lopTruong);

        clazz.notification();
    }
}