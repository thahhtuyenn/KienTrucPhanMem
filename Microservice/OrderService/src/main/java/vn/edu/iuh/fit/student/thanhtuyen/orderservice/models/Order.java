package vn.edu.iuh.fit.student.thanhtuyen.orderservice.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "orders")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "order_date")
    private LocalDate orderDate;
    @Column(name = "total_price")
    private Double totalPrice;
    @Column(name = "status")
    private Integer status; // 0: pending, 1: confirmed, 2: shipped, 3: delivered, -1: canceled
    @Column(name = "shipping_address")
    private String shippingAddress;
    @Column(name = "shipping_phone")
    private String shippingPhone;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails;
}
