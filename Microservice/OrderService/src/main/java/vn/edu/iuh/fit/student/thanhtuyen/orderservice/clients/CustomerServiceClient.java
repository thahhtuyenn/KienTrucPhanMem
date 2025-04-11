package vn.edu.iuh.fit.student.thanhtuyen.orderservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.edu.iuh.fit.student.thanhtuyen.orderservice.models.Customer;

@FeignClient(name = "mcr-customer-service", path = "/api/v1/customer")
public interface CustomerServiceClient {
    @GetMapping("/{id}")
    ResponseEntity<Customer> getCustomerById(@PathVariable Long id);
}