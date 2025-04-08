package vn.edu.iuh.fit.student.thanhtuyen.orderservice.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Customer {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private int status;
}
