package springboot2.springbootdemo2.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import springboot2.springbootdemo2.entity.Guardian;
import springboot2.springbootdemo2.entity.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void SaveStudent() {
        Student student = Student.builder().name("Nam").emailId("bdc@gmail.com").NumberPhone("12345").scores(7.0)
//                .guardianMobile("234").guardianName("AN").guardianEmail("abc@gmail.com")
                .build();

        studentRepository.save(student);
    }
    @Test
    public void SaveStudentWithGuardian()
    {
        Guardian guardian=  Guardian.builder().email("thao@gmail.com").mobile("07728372-").name("THhao").build();

        Student student = Student.builder().name("Xuan").emailId("yeuXuan@gmail.com").NumberPhone("09030321").scores(8.9)
                .guardian(guardian).build();
        studentRepository.save(student);


    }

    @Test
    public  void printAllStudentByname()
    {
        List<Student> studentList=studentRepository.findByName("Nam");
        System.out.println("================="+studentList);

    }
    @Test
    public  void printAllStudentBynameContaining()
    {
        List<Student> studentList=studentRepository.findByNameContaining("NA");
        System.out.println("================="+studentList);

    }

    @Test
    public  void printAllStudentBynameGuardian()
    {
        List<Student> studentList=studentRepository.findByGuardianName("AN");
        System.out.println("printf"+ studentList);


    }
    @Test
    public void printAllStudent()
    {
        List<Student> studentList=studentRepository.findAll();

        System.out.println("printf"+ studentList);
    }

    @Test
    public void printStudentByEmailAddress()
    {
        Student student=studentRepository.getStudentByEmailId("eft@gmail.com");

        System.out.println("==========="+ student);
    }


    @Test
    public void printStudentByEmailAddressNative()
    {
        Student student=studentRepository.getStudentNameByAddressNative("eft@gmail.com");

        System.out.println("==========="+ student);
    }
    @Test
    public void printStudentByEmailAddressNativeNamedParam()
    {
        Student student=studentRepository.getStudentNameByAddressNativeNamedParam("eft@gmail.com");

        System.out.println("==========="+ student);
    }

    @Test
    public void updateStudentNameByEmailId()
    {

int a=studentRepository.updateStudentNameByEmailId("Ngoc Bich","eft@gmail.com");
        Student student=studentRepository.getStudentNameByAddressNative("eft@gmail.com");

        System.out.println("==========="+ student);
    }
    }