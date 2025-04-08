package vn.edu.iuh.fit.student.thanhtuyen.customerservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public Customer insertCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/update-customer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/update-status")
    public Customer updateStatusCustomer(@RequestParam Long id, @RequestParam int status) {
        return customerService.updateStatusCustomer(id, status);
    }
}
