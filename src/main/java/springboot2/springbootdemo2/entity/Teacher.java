package springboot2.springbootdemo2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator ="teacher_sequence" )
    private String teacherId;
    private  String name;
    private String subject;

//    @Enumerated
//    private Subject subject;

    @OneToMany(mappedBy = "teacher") //,cascade = CascadeType.ALL
    private List<Course> courses;
}
