package mk.ukim.finki.wp.project_v1.repository.impl;

import mk.ukim.finki.wp.project_v1.model.Class;
import mk.ukim.finki.wp.project_v1.model.Student;
import mk.ukim.finki.wp.project_v1.repository.StudentRepository;
import mk.ukim.finki.wp.project_v1.repository.mongo.MongoStudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final MongoStudentRepository mongoStudentRepository;

    public StudentRepositoryImpl(MongoStudentRepository jpaStudentRepository) {
        this.mongoStudentRepository = jpaStudentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return mongoStudentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        return mongoStudentRepository.save(student);
    }

    @Override
    public Page<Student> getAllStudents(int page, int size) {
        return mongoStudentRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Optional<Student> findById(String studentId) {
        return mongoStudentRepository.findById(studentId);
    }

    @Override
    public void deleteById(String studentId) {
        mongoStudentRepository.deleteById(studentId);
    }

    @Override
    public List<Class> findClassesForStudent(String studentId) {
        return mongoStudentRepository.findClassesForStudent(studentId);
    }
}
