package vn.edu.iuh.fit.student.thanhtuyen.customerservice.models;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "customers")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private int status;
}
