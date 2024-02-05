package springboot2.springbootdemo2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

import java.lang.annotation.Native;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long departmentId;
    @NotBlank(message = "Attention! Importation Name is mandatory")
    @Length(min = 0,max = 20)
 //   @Column(unique = true) // hoặc có thể sử dụng @UniqueConstraint ở cấp độ bảng
 /*   @Size(min = 0,max = 10)
    @Email()
    @Positive
    @Negative
    @PositiveOrZero
    @NegativeOrZero
    @FutureOrPresent
    @PastOrPresent*/
    @Column(name = "department_name",unique = true)
    private String departmentName;
    private String departmentAddress;

    private String departmentCode;

}
