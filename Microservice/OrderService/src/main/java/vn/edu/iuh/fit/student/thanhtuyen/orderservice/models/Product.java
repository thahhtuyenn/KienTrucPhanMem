package vn.edu.iuh.fit.student.thanhtuyen.orderservice.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@Builder
public class Product {
    private Long id;

    private String name;

    private String description;

    private Double price;

    private Integer quantity;

    private Integer status;
}
