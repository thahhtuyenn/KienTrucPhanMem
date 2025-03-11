import compositeDesignPattern.Product;
import compositeDesignPattern.TotalPrice;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        List<Product> products = List.of(
                new Product(1, "Ca phe", 15000.0),
                new Product(2, "Sting", 18000.0),
                new Product(3, "Coca", 15000.0),
                new Product(4, "Tra duong", 10000.0)
        );

        TotalPrice totalPrice = new TotalPrice(products);
        System.out.println("Total price: " + totalPrice.calculateTotalPrice());
        totalPrice.showProduct();
    }
}