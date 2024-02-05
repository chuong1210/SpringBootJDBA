package springboot2.springbootdemo2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import springboot2.springbootdemo2.entity.Department;
import springboot2.springbootdemo2.repository.DepartmentRepository;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department=Department.builder().departmentName("IT").departmentAddress("Hà nội").departmentCode("IT - 01").departmentId((long) 1L).build();

        Mockito.when(
                departmentRepository.findByDepartmentNameIgnoreCase("IT")
        ).thenReturn(department);
    }

    @Test
    @DisplayName("Get data based on Validate  DepartmentName")
//    @Disabled
    public void whenValidDepartmentName_thenDepartmentShouldFound()
    {
        String departmentName="IT";
        Department DpFound=departmentService.fetchDepartmenByName(departmentName);

        assertEquals(departmentName,DpFound.getDepartmentName());
    }

}