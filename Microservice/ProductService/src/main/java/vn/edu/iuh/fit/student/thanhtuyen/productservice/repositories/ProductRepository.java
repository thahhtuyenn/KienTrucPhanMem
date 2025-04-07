package vn.edu.iuh.fit.student.thanhtuyen.productservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.student.thanhtuyen.productservice.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
