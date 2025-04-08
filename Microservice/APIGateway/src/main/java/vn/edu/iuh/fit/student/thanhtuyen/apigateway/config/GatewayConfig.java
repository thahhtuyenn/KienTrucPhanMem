package vn.edu.iuh.fit.student.thanhtuyen.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product-service", r -> r.path("/api/v1/product/**")
                        .uri("lb://product-service"))
                .route("customer-service", r -> r.path("/api/v1/customer/**")
                        .uri("lb://customer-service"))
                .build();
    }
}
