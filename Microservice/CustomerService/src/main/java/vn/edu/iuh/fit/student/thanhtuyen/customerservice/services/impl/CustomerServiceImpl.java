package vn.edu.iuh.fit.student.thanhtuyen.customerservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.student.thanhtuyen.customerservice.models.Customer;
import vn.edu.iuh.fit.student.thanhtuyen.customerservice.repositories.CustomerRepository;
import vn.edu.iuh.fit.student.thanhtuyen.customerservice.services.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        Customer customerSave = new Customer();
        if(customer.getId() == null){
            customerSave = Customer.builder()
                    .fullName(customer.getFullName())
                    .email(customer.getEmail())
                    .phone(customer.getPhone())
                    .address(customer.getAddress())
                    .status(1)
                    .build();
        }else {
            customerSave = customerRepository.findById(customer.getId()).orElse(null);
            if(customerSave == null){
                return null;
            }

            if(customer.getFullName() != null){
                customerSave.setFullName(customer.getFullName());
            }
            if(customer.getEmail() != null){
                customerSave.setEmail(customer.getEmail());
            }
            if(customer.getPhone() != null){
                customerSave.setPhone(customer.getPhone());
            }
            if(customer.getAddress() != null) {
                customerSave.setAddress(customer.getAddress());
            }
        }

        return customerRepository.save(customerSave);
    }

    @Override
    public Customer updateStatusCustomer(Long id, int status) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer == null){
            return null;
        }
        customer.setStatus(status);
        return customerRepository.save(customer);
    }
}
