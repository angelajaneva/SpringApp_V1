package mk.ukim.finki.wp.project_v1.repository;

import mk.ukim.finki.wp.project_v1.model.Class;
import mk.ukim.finki.wp.project_v1.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    List<Student> getAllStudents();

    Student save(Student student);

    Page<Student> getAllStudents(int page, int size);

    Optional<Student> findById(String studentId);

    void deleteById(String studentId);

    List<Class> findClassesForStudent(String studentId);

}
