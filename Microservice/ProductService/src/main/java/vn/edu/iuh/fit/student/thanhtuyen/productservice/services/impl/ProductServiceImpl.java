package vn.edu.iuh.fit.student.thanhtuyen.productservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.student.thanhtuyen.productservice.models.Product;
import vn.edu.iuh.fit.student.thanhtuyen.productservice.repositories.ProductRepository;
import vn.edu.iuh.fit.student.thanhtuyen.productservice.services.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveProduct(Product product) {
        Product productSave = new Product();
        if (product.getId() == null){
            productSave = Product.builder()
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .quantity(product.getQuantity())
                    .status(1)
                    .build();
        }else {
            productSave = productRepository.findById(product.getId()).orElse(null);
            if (productSave == null) {
                return null;
            }
            if (product.getName() != null) {
                productSave.setName(product.getName());
            }
            if (product.getDescription() != null) {
                productSave.setDescription(product.getDescription());
            }
            if (product.getPrice() != null) {
                productSave.setPrice(product.getPrice());
            }
            if (product.getQuantity() != null) {
                productSave.setQuantity(product.getQuantity());
            }
            if (product.getStatus() != null) {
                productSave.setStatus(product.getStatus());
            }
        }
        System.out.println("productSave = " + productSave.toString());
        return productRepository.save(productSave);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateQuantity(Long id, int quantity) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return null;
        }
        int newQuantity = product.getQuantity() - quantity;
        product.setQuantity(newQuantity);
        return productRepository.save(product);
    }
}
