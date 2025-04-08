package vn.edu.iuh.fit.student.thanhtuyen.orderservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "product-service", url = "/api/v1/product")
public interface ProductServiceClient {


}
