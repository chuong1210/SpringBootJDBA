package springboot2.springbootdemo2.repository;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot2.springbootdemo2.entity.Teacher;

@Repository

public interface TeacherRepository extends JpaRepository<Teacher,Long> {


}
