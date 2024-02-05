package springboot2.springbootdemo2.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot2.springbootdemo2.entity.Department;
import springboot2.springbootdemo2.error.DepartmentNotFoundException;
import springboot2.springbootdemo2.service.DepartmentService;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private  DepartmentService departmentService;

//    private final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department SaveDepartment(@Valid @RequestBody  Department department)
    {



        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList()
    {
return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);

    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department Deleted Successfully";

    }


    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department) {
        return departmentService.updateDepartment(departmentId,department);

    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmenByName( @PathVariable("name") String departmentName)
    {
        return departmentService.fetchDepartmenByName( departmentName);
    }
}
