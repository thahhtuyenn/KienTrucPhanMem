package vn.edu.iuh.fit.student.thanhtuyen.orderservice.services;

import vn.edu.iuh.fit.student.thanhtuyen.orderservice.models.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();
    Order getOne(Long id);
    String save(Order order);
    Order updateStatus(Long id, String status);
}
