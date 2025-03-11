package observerDesignPattern;
import java.util.ArrayList;
import java.util.List;

public class Clazz implements Subject{
    private List<Observer> students;

    public Clazz() {
        students = new ArrayList<>();
    }

    @Override
    public void attach(Observer observer) {
        students.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        students.remove(observer);
    }

    @Override
    public void notification() {
        for (Observer observer : students){
            observer.update();
        }
    }
}
