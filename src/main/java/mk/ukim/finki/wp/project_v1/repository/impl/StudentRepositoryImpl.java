package mk.ukim.finki.wp.project_v1.repository.impl;

import mk.ukim.finki.wp.project_v1.model.Student;
import mk.ukim.finki.wp.project_v1.repository.StudentRepository;
import mk.ukim.finki.wp.project_v1.repository.mongo.MongoStudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final MongoStudentRepository mongoStudentRepository;

    public StudentRepositoryImpl(MongoStudentRepository jpaStudentRepository) {
        this.mongoStudentRepository = jpaStudentRepository;
    }

    @Override
    public Flux<Student> getAllStudents() {
        return mongoStudentRepository.findAll();
    }

    @Override
    public Mono<Student> save(Student student) {
        return mongoStudentRepository.save(student);
    }

    @Override
    public Mono<Page<Student>> getAllStudents(int page, int size) {
        return null;
    }

    @Override
    public Mono<Student> findById(String studentId) {
        return mongoStudentRepository.findById(studentId);
    }

    @Override
    public Mono<Void> deleteById(String studentId) {
        return mongoStudentRepository.deleteById(studentId);
    }

    @Override
    public Mono<Student> findByUsername(String username) {
        return mongoStudentRepository.findByUsername(username);
    }

//    @Override
//    public Flux<Class> findClassesForStudent(String studentId) {
//        return mongoStudentRepository.findClassesForStudent(studentId);
//    }
}
