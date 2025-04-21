package vn.edu.iuh.fit.student.thanhtuyen.customerservice.clients;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-a", path = "/api/v1/a")
public interface ServiceAClient {
    @GetMapping("/{id}")
    ResponseEntity<String> getById(@PathVariable Integer id);

    @GetMapping("/retry/{id}")
    ResponseEntity<String> retry(@PathVariable Integer id);

    @GetMapping("/rate-limit")
    ResponseEntity<String> rateLimit();

    @GetMapping("/checkout")
    ResponseEntity<String> checkout();
}
