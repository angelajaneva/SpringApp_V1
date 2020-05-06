package mk.ukim.finki.wp.project_v1.repository.mongo;

import mk.ukim.finki.wp.project_v1.model.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MongoStudentRepository extends ReactiveMongoRepository<Student, String> {


//    Flux<Class> findClassesForStudent(@Param("id") String studentId);
}
