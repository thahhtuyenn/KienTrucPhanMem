package compositeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class TotalPrice implements Component{
    private List<Product> products;

    public TotalPrice(List<Product> products) {

        this.products = products;
    }

    @Override
    public void showProduct() {
        for (Product product : products){
            product.showProduct();
        }
    }

    @Override
    public double calculateTotalPrice() {
        double sum = 0;
        for (Product product : products){
            sum += product.calculateTotalPrice();
        }
        return sum;
    }
}
