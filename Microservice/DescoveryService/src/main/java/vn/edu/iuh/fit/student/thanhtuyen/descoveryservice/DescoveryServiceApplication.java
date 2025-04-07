package vn.edu.iuh.fit.student.thanhtuyen.descoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DescoveryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DescoveryServiceApplication.class, args);
    }

}
