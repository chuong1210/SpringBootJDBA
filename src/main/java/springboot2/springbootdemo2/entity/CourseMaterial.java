package springboot2.springbootdemo2.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            sequenceName = "course_material_sequence"
            ,
            name = "course_material_sequence"
            ,
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_material_sequence")
    private Long courseMaterialId;

    private  String url;
    @OneToOne(cascade = CascadeType.ALL,
    fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "course_id",referencedColumnName = "courseId")
    private  Course course;


}
