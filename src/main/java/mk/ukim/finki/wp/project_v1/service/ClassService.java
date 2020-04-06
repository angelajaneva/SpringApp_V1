package mk.ukim.finki.wp.project_v1.service;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import mk.ukim.finki.wp.project_v1.model.Class;

public interface ClassService {

    List<Class> getAllClasses();

    Class save(Class aClass);

    Page<Class> getAllClasses(int page, int size);

    Optional<Class> findById(String classId);

    void deleteById(String classId);

    List<Class> findClassesByStudents_Id(String studentId);

}
