package springboot2.springbootdemo2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import springboot2.springbootdemo2.entity.Department;
import springboot2.springbootdemo2.error.DepartmentNotFoundException;
import springboot2.springbootdemo2.repository.DepartmentRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public  Department saveDepartment(Department department) {

        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }


    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department= departmentRepository.findById(departmentId); //return luon có get
        if(department.isEmpty())
        {
throw  new DepartmentNotFoundException("Department not Available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId,Department department) {
        Department dpm = departmentRepository.findById(departmentId).get();
        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            dpm.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            dpm.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            dpm.setDepartmentCode(department.getDepartmentCode());
        }


        return departmentRepository.save(dpm);
    }

    @Override
    public Department fetchDepartmenByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }


}
