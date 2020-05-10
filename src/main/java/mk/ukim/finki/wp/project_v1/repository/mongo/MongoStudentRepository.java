package mk.ukim.finki.wp.project_v1.repository.mongo;

import mk.ukim.finki.wp.project_v1.model.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface MongoStudentRepository extends ReactiveMongoRepository<Student, String> {

    Mono<Student> findByUsername(String username);

}
