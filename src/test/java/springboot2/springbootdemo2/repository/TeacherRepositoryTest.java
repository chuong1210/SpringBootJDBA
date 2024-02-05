package springboot2.springbootdemo2.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboot2.springbootdemo2.entity.Course;
import springboot2.springbootdemo2.entity.Teacher;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository repository;

    @Test
    public void SaveTeacher()
    {
        Course course1=Course.builder().credit(200).title("C").build();
        Course course2=Course.builder().credit(1000).title("C++").build();

        Teacher teacher=Teacher.builder().name("Giang")
               // .courses(List.of(course1,course2))

                .subject("Anh Van").build();
        repository.save(teacher);
    }

}