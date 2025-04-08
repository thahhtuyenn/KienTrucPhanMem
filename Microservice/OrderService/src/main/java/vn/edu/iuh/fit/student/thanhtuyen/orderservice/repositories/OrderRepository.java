package vn.edu.iuh.fit.student.thanhtuyen.orderservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.student.thanhtuyen.orderservice.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
