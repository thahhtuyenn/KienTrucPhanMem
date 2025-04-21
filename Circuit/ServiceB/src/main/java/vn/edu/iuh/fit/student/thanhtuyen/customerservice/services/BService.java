package vn.edu.iuh.fit.student.thanhtuyen.customerservice.services;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.student.thanhtuyen.customerservice.clients.ServiceAClient;

import java.util.concurrent.CompletableFuture;

@Service
public class BService {
    @Autowired
    private ServiceAClient serviceAClient;


    //Circuit Breaker
//    @CircuitBreaker(name = "serviceBCircuitBreaker", fallbackMethod = "getByIdFallback")
    @TimeLimiter(name = "serviceBTimeLimiter", fallbackMethod = "getByIdFallback")
    public CompletableFuture<ResponseEntity<String>> getById(Integer id) {
        return CompletableFuture.supplyAsync(() -> serviceAClient.getById(id));
    }
    private CompletableFuture<String> getByIdFallback(Integer id, Exception t) {
        System.err.println("Fallback triggered for getOrder: " + t.getMessage());
        return CompletableFuture.completedFuture("Service A is down. Please try again later.");
    }


    // Retry
    @Retry(name = "serviceBRetry", fallbackMethod = "retryFallback")
    public ResponseEntity<String> retry(Integer id) {
        System.out.println("Calling Service A for retry...");
        return serviceAClient.retry(id);
    }

    private ResponseEntity<String> retryFallback(Integer id, Exception t) {
        System.err.println("Fallback triggered for retry: " + t.getMessage());
        return ResponseEntity.ok("Service A is down. Please try again later.");
    }

    //rate limiter
    @RateLimiter(name = "serviceBRateLimiter", fallbackMethod = "rateLimitFallback")
    public ResponseEntity<String> rateLimit() {
        System.out.println("Calling Service A for rate limit...");
        return serviceAClient.rateLimit();
    }

    private ResponseEntity<String> rateLimitFallback(Exception t) {
        System.err.println("Fallback triggered for rateLimit: " + t.getMessage());
        return ResponseEntity.ok("Rate limit exceeded. Please try again later.");
    }


    //checkout

}
