package mk.ukim.finki.wp.project_v1.repository.mongo;

import mk.ukim.finki.wp.project_v1.model.Class;
import mk.ukim.finki.wp.project_v1.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MongoStudentRepository extends MongoRepository<Student, String> {

    @Query("select s.classes from Student s where s.id = :id")
    List<Class> findClassesForStudent(@Param("id") String studentId);
}
