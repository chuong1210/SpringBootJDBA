package springboot2.springbootdemo2.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import springboot2.springbootdemo2.entity.Department;
import springboot2.springbootdemo2.error.DepartmentNotFoundException;
import springboot2.springbootdemo2.service.DepartmentService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;

    private Department department;
    @BeforeEach
 public   void setUp() {
         department=Department.builder().
                 departmentName("Business Analyst").
                 departmentAddress("Sai Gon").
                 departmentCode("BA-01").departmentId(1L).build();
    }

    @Test
  public  void saveDepartment() throws Exception {
        Department inputDepartment=Department.builder()
                .departmentName("Business Analyst").
                departmentAddress("Sai Gon").departmentCode("BA-01").departmentId(1L)
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(post("/departments" ).
                contentType(MediaType.APPLICATION_JSON).content("{\n" +
                        "   \"departmentName\":\"IT\",\n" +
                        "   \"departmentAddress\":\"Hạ Long\",\n" +
                        "   \"departmentCode\":\"IT - 02\"\n" +
                        " }\n" +
                        "    ")).andExpect(status().isOk());




    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L)).thenReturn(department);
        mockMvc.perform(get("/departments/1" ).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath( "$.departmentName").value(department.getDepartmentName()));



    }
}