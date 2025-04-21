package vn.edu.iuh.fit.student.thanhtuyen.customerservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.student.thanhtuyen.customerservice.services.BService;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/b")
public class ServiceBController {

    @Autowired
    private BService bService;

    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<String>> hello(@PathVariable Integer id) {
        return bService.getById(id);
    }

    @GetMapping("/retry/{id}")
    public ResponseEntity<String> retry(@PathVariable Integer id) throws Exception {
        return bService.retry(id);
    }

    @GetMapping("/rate-limit")
    public ResponseEntity<String> rateLimit() {
        return bService.rateLimit();
    }
}
