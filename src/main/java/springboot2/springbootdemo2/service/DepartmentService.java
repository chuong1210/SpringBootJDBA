package springboot2.springbootdemo2.service;

import springboot2.springbootdemo2.entity.Department;
import springboot2.springbootdemo2.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);
  public List<Department> fetchDepartmentList();
    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;


  public  void deleteDepartmentById(Long departmentId);

 public   Department updateDepartment(Long departmentId,Department department);

  public  Department fetchDepartmenByName(String departmentName);
}
