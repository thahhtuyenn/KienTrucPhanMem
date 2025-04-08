package vn.edu.iuh.fit.student.thanhtuyen.orderservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.student.thanhtuyen.orderservice.clients.CustomerServiceClient;
import vn.edu.iuh.fit.student.thanhtuyen.orderservice.clients.ProductServiceClient;
import vn.edu.iuh.fit.student.thanhtuyen.orderservice.models.Customer;
import vn.edu.iuh.fit.student.thanhtuyen.orderservice.models.Order;
import vn.edu.iuh.fit.student.thanhtuyen.orderservice.models.OrderDetail;
import vn.edu.iuh.fit.student.thanhtuyen.orderservice.models.Product;
import vn.edu.iuh.fit.student.thanhtuyen.orderservice.repositories.OrderDetailRepository;
import vn.edu.iuh.fit.student.thanhtuyen.orderservice.repositories.OrderRepository;
import vn.edu.iuh.fit.student.thanhtuyen.orderservice.services.OrderService;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ProductServiceClient productServiceClient;
    @Autowired
    private CustomerServiceClient customerServiceClient;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOne(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public String save(Order order) {
        if (order.getOrderDetails().isEmpty()){
            return "Đơn hàng không có sản phẩm nào";
        }

        // kiem tra khach hang ton tai
        Customer customer = customerServiceClient.getCustomerById(order.getCustomerId()).getBody();
        if (customer == null) {
            return "Khách hàng không tồn tại";
        }
        Order orderSaved = new Order();
        if(order.getId() == null){
            orderSaved = Order.builder()
                    .orderDate(order.getOrderDate())
                    .customerId(order.getCustomerId())
                    .shippingAddress(order.getShippingAddress())
                    .shippingPhone(order.getShippingPhone())
                    .build();
            orderSaved = orderRepository.save(orderSaved);
        }else {
            orderSaved = orderRepository.findById(order.getId()).orElse(null);
        }
        List<OrderDetail> orderDetails = order.getOrderDetails();
        double totalPrice = 0;
        // kiem tra san pham ton tai va con hang, luu thong tin chi tiet don hang
        for (OrderDetail orderDetail : orderDetails) {
            Product product = productServiceClient.getProductById(orderDetail.getProductId()).getBody();
            if (product == null) {
                return "Sản phẩm " + orderDetail.getProductId() + " không tồn tại";
            }
            if (product.getQuantity() < orderDetail.getQuantity()) {
                return "Sản phẩm " + orderDetail.getProductId() + " không đủ số lượng";
            }
            int quantity = product.getQuantity() - orderDetail.getQuantity();
            product = productServiceClient.updateQuantityProduct(product.getId(), quantity).getBody();
            OrderDetail orderDetailSaved = OrderDetail.builder()
                    .order(orderSaved)
                    .productId(orderDetail.getProductId())
                    .quantity(orderDetail.getQuantity())
                    .price(product.getPrice())
                    .build();
            orderDetailRepository.save(orderDetailSaved);
            totalPrice += orderDetail.getQuantity() * product.getPrice();
        }

        orderSaved.setTotalPrice(totalPrice);
        orderSaved.setStatus(0);
        orderSaved = orderRepository.save(orderSaved);
        orderSaved = orderRepository.findById(orderSaved.getId()).orElse(null);
        if (orderSaved == null) {
            return "Đặt hàng không thành công";
        }

        return "Đặt hàng thành công";
    }

    @Override
    public Order updateStatus(Long id, String status) {
        return null;
    }
}
