package springboot2.springbootdemo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springboot2.springbootdemo2.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    public Department findByDepartmentName(String departmentName);
    public Department findByDepartmentNameIgnoreCase(String departmentName);



}
