package vn.edu.iuh.fit.student.thanhtuyen.customerservice.services;

import vn.edu.iuh.fit.student.thanhtuyen.customerservice.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    Customer saveCustomer(Customer customer);
    Customer updateStatusCustomer(Long id, int status);
}
