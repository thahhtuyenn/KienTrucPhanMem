package vn.edu.iuh.fit.student.thanhtuyen.productservice.services;

import vn.edu.iuh.fit.student.thanhtuyen.productservice.models.Product;

import java.util.List;

public interface ProductService {
    // Define the methods that will be implemented in the service class
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product saveProduct(Product product);
    void deleteProduct(Long id);
    Product updateQuantity(Long id, int quantity);
}
