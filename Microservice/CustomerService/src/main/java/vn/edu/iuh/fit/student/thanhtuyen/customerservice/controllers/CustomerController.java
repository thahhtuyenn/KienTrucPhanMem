package vn.edu.iuh.fit.student.thanhtuyen.customerservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.student.thanhtuyen.customerservice.models.Customer;
import vn.edu.iuh.fit.student.thanhtuyen.customerservice.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PostMapping
    public ResponseEntity<Customer> insertCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }

    @PutMapping("/update-customer")
    public ResponseEntity updateCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }

    @PutMapping("/update-status")
    public ResponseEntity<Customer> updateStatusCustomer(@RequestParam Long id, @RequestParam int status) {
        return ResponseEntity.ok(customerService.updateStatusCustomer(id, status));
    }
}
