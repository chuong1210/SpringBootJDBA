//package springboot2.springbootdemo2.repository;
//
//import jakarta.transaction.Transactional;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Replace;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.Import;
//
//import springboot2.springbootdemo2.entity.Department;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
////@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Import(DepartmentRepository.class)
//
//class DepartmentRepositoryTest {
//
//    @Autowired
//    private  DepartmentRepository departmentRepository;
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//
//    @BeforeEach
//    void setUp() {
//        Department department = Department.builder()
//                .departmentName("Mechanical")
//                .departmentAddress("Hạ long")
//                .departmentCode("ME - 01")
//                .build();
//        entityManager.persist(department);
//
//    }
//
//    @Test
//    @DisplayName("Check Find By id")
//    public void whenFindById_thenReturnDepartment()
//    {
//
//          Department department=departmentRepository.findById(1L).get();
//          assertEquals(department.getDepartmentName(),"Mechanical");
//    }
//
//}