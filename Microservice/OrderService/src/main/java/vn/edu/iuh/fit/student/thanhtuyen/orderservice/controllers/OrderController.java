package vn.edu.iuh.fit.student.thanhtuyen.orderservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.student.thanhtuyen.orderservice.models.Order;
import vn.edu.iuh.fit.student.thanhtuyen.orderservice.services.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAll();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOne(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        String result = orderService.save(order);
        if (result.equals("Đơn hàng không có sản phẩm nào")) {
            return ResponseEntity.badRequest().body(result);
        } else if (result.equals("Khách hàng không tồn tại")) {
            return ResponseEntity.badRequest().body(result);
        } else if (result.equals("Đặt hàng không thành công")) {
            return ResponseEntity.badRequest().body(result);
        } else {
            return ResponseEntity.ok(result);
        }
    }
}
