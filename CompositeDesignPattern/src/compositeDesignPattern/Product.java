package compositeDesignPattern;

public class Product implements Component{
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public void showProduct() {
        System.out.println("ID: " + id + ", Name: " + name + ", Price: " + price);
    }

    @Override
    public double calculateTotalPrice() {
        return price;
    }
}
