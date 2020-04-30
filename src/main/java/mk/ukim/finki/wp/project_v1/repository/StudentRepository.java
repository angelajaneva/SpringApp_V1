package mk.ukim.finki.wp.project_v1.repository;

import mk.ukim.finki.wp.project_v1.model.Class;
import mk.ukim.finki.wp.project_v1.model.Student;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    Flux<Student> getAllStudents();

    Mono<Student> save(Student student);

    Mono<Page<Student>> getAllStudents(int page, int size);

    Mono<Student> findById(String studentId);

    Mono<Void> deleteById(String studentId);

//    Flux<Class> findClassesForStudent(String studentId);

}
