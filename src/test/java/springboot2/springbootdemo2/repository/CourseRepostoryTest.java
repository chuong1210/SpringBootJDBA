package springboot2.springbootdemo2.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import springboot2.springbootdemo2.entity.Course;
import springboot2.springbootdemo2.entity.CourseMaterial;
import springboot2.springbootdemo2.entity.Student;
import springboot2.springbootdemo2.entity.Teacher;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

@Test
    public void printAllcourses()
{
    List<Course> courses= repository.findAll();
    System.out.println(courses);
}

//    @Test one to one nên này ko cần
//    public void saveCourse()
//    {
//        Course courses=Course.builder().title("Hentai").credit(100).build();
//        CourseMaterial courseMaterial= CourseMaterial.builder().course(courses).url("https:/vlxx.com").build();
//
//        repository.save(courses);
//    }

    @Test
    public  void saveCourseWithTeacher()
    {
        Teacher teacher = Teacher.builder().name("Giao vien").subject("CNTT").build();
              Course courses=Course.builder().title("Python").teacher(teacher).credit(100).build();
        repository.save(courses);

    }

    @Test
    public void saveCourseWithStudentandTeacher()
    {
        Teacher teacher = Teacher.builder().name("Giao vien A").subject("Machine Learninig").build();

        Student student= Student.builder().scores(6.4).name("Chương").NumberPhone("077283").emailId("xuandepgai@gmail.com").build();
        Course courses=Course.builder().title("AI").teacher(teacher).credit(12).build();

        courses.addStudent(student);
        repository.save(courses);

    }
@Test
    public void  findAllPagination()

{
    Pageable firstPagewiththreeRecords= PageRequest.of(0,3);
    Pageable secondPagewiththreeRecords= PageRequest.of(1,2);

    List<Course> courses=repository.findAll(firstPagewiththreeRecords).getContent();
  // Long totalElement=repository.findAll(firstPagewiththreeRecords).stream().count();
    long totalElement=repository.findAll(firstPagewiththreeRecords).getTotalElements();
    long totalPage=repository.findAll(firstPagewiththreeRecords).getTotalPages();


    System.out.println("====="+courses);
    System.out.println("Toal Elemntent="+totalElement);
    System.out.println("Toal Page="+totalPage);




}



@Test
public  void findAllsorting()
{
    Pageable sortBytile=PageRequest.of(0,2, Sort.by("title"));
    Pageable sortByCreditDesc=
            PageRequest.of(0,4, Sort.by("credit").descending());
    Pageable sortBytileAndCreditDesc=PageRequest.of(0,2, Sort.by("title").descending().and(Sort.by("credit").descending()));
    List<Course> courses=repository.findAll(sortByCreditDesc).getContent();

    System.out.println("After sort"+courses);
}


@Test
    public void PrintfindByTitleCointaing()
{

    Pageable firstPageTenRecord=PageRequest.of(0,10);
          List<Course> courses=  repository.findByTitleContaining("P",firstPageTenRecord).getContent();
    System.out.println("====="+courses);

}



}