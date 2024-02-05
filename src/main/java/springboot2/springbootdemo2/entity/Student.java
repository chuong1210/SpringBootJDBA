package springboot2.springbootdemo2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_student",
uniqueConstraints = @UniqueConstraint(name ="emailid_unique",columnNames = "email_address"))
public class Student {
    @Id

    @SequenceGenerator(
    name = "student_sequence",
    sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator ="student_sequence" )
    private  Long studentId;
    @NotBlank
    private String name;
    @JsonIgnore //mã hóa
    private String NumberPhone;
    private Double scores;

    @JsonFormat(pattern = "dd/mm/yy" )
    private Date dateofbirdth;
    @Column(name = "email_address",nullable = false)
    private String emailId;

    @Embedded
    private  Guardian guardian;





}
