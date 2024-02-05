package springboot2.springbootdemo2.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboot2.springbootdemo2.entity.Course;
import springboot2.springbootdemo2.entity.CourseMaterial;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private  CourseMaterialRepository courseMaterialRepository;
    @Test
    public void SaveCourseMaterial()
    {
        Course course= Course.builder().title("Javascipt").credit(1200).build();
        CourseMaterial courseMaterial= CourseMaterial.builder().course(course).url("www.www.com").build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllcouseMaterial()
    {
         List<CourseMaterial> list=courseMaterialRepository.findAll();
        System.out.println("====" + list);

    }




}