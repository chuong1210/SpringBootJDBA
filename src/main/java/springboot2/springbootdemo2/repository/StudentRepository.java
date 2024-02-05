package springboot2.springbootdemo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springboot2.springbootdemo2.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    public List<Student> findByName(String fullname);
    //name hay Name cũng đc
    public List<Student> findByNameContaining(String fullname);
    public List<Student> findByNameNotNull();
//    @Query("SELECT s FROM Student s WHERE s.guardian.name = :guardianName")

    public List<Student> findByGuardianName(String guardianName);

    public List<Student> findByGuardianNameAndEmailId(String guardianName,String emailId);

    @Query("select s from  Student as s where s.emailId=?1")
    Student getStudentByEmailId(String Emailid);

    @Query("select s.name from  Student as s where s.emailId=?1")
    Student getStudentNameByEmailId(String Emailid);

    @Query(value = "select * from tbl_student s where  s.email_address=?1",nativeQuery = true)
    Student getStudentNameByAddressNative(String Emailid);

    @Query(value = "select * from tbl_student s where  s.email_address=:emailId",nativeQuery = true)
    Student getStudentNameByAddressNativeNamedParam(@Param( "emailId") String Emailid);

    @Modifying
    @Transactional
    @Query(value = "update tbl_student set name=?1 where  email_address=?2",nativeQuery = true)
    int updateStudentNameByEmailId(String Name,String Emailid);


}
