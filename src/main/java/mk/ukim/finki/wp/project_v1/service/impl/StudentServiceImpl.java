package mk.ukim.finki.wp.project_v1.service.impl;

import mk.ukim.finki.wp.project_v1.model.Class;
import mk.ukim.finki.wp.project_v1.model.Student;
import mk.ukim.finki.wp.project_v1.repository.StudentRepository;
import mk.ukim.finki.wp.project_v1.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Flux<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public Mono<Student> save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Page<Student> getAllStudents(int page, int size) {
        return null;
    }

    @Override
    public Mono<Student> findById(String studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public Mono<Void> deleteById(String studentId) {

        return studentRepository.deleteById(studentId);
    }

    @Override
    public Mono<Student> findByUsername(String username) {
        return studentRepository.findByUsername(username);
    }

//    @Override
//    public Flux<Class> findClassesForStudent(String studentId) {
//        return studentRepository.findClassesForStudent(studentId);
//    }
}
