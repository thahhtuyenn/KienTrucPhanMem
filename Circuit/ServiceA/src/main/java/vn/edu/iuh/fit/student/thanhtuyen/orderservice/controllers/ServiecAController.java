package vn.edu.iuh.fit.student.thanhtuyen.orderservice.controllers;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/a")
public class ServiecAController {

    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable Integer id) throws InterruptedException {
        Thread.sleep(id);
        return ResponseEntity.ok("Info for id: " + id);
    }

    @GetMapping("/retry/{id}")
    public ResponseEntity<String> retry(@PathVariable Integer id) throws InterruptedException {
        System.out.println("Retry called.");
        return ResponseEntity.badRequest().body("Bad.");
    }

    @GetMapping("/rate-limit")
    public ResponseEntity<String> rateLimit() {
        System.out.println("Rate Limit called.");
        return ResponseEntity.ok("Rate Limit called.");
    }

    @GetMapping("/checkout")
    @RateLimiter(name = "checkoutLimiter", fallbackMethod = "checkoutFallback")
    public ResponseEntity<String> checkout() {
        System.out.println("Checkout called.");
        return ResponseEntity.ok("Checkout called.");
    }

    public ResponseEntity<String> checkoutFallback(Exception t) {
        System.err.println("Fallback triggered for checkout: " + t.getMessage());
        return ResponseEntity.ok("Checkout service is down. Please try again later.");
    }
}
