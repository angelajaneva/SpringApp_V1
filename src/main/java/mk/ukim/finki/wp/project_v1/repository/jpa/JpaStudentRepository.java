package mk.ukim.finki.wp.project_v1.repository.jpa;

import mk.ukim.finki.wp.project_v1.model.Class;
import mk.ukim.finki.wp.project_v1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaStudentRepository extends JpaRepository<Student, String> {

    @Query("select s.classes from Student s where s.id = :id")
    List<Class> findClassesForStudent(@Param("id") String studentId);
}
