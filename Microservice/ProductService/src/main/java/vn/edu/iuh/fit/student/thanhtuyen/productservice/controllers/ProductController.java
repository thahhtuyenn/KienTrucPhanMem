package vn.edu.iuh.fit.student.thanhtuyen.productservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.student.thanhtuyen.productservice.models.Product;
import vn.edu.iuh.fit.student.thanhtuyen.productservice.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product insertProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/update-quantity")
    public Product updateQuantityProduct(@RequestParam Long id, @RequestParam int quantity) {
        return productService.updateQuantity(id, quantity);
    }
}
