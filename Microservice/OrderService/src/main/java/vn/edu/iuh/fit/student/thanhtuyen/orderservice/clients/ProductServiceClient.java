package vn.edu.iuh.fit.student.thanhtuyen.orderservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.student.thanhtuyen.orderservice.models.Product;

@FeignClient(name = "mcr-product-service", path = "/api/v1/product")
public interface ProductServiceClient {
    @GetMapping("/{id}")
    ResponseEntity<Product> getProductById(@PathVariable Long id);

    @PutMapping("/update-quantity")
    ResponseEntity<Product> updateQuantityProduct(@RequestParam Long id, @RequestParam int quantity);
}
