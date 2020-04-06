package mk.ukim.finki.wp.project_v1.repository.impl;

import mk.ukim.finki.wp.project_v1.model.Class;
import mk.ukim.finki.wp.project_v1.model.Student;
import mk.ukim.finki.wp.project_v1.repository.StudentRepository;
import mk.ukim.finki.wp.project_v1.repository.jpa.JpaStudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final JpaStudentRepository jpaStudentRepository;

    public StudentRepositoryImpl(JpaStudentRepository jpaStudentRepository) {
        this.jpaStudentRepository = jpaStudentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return jpaStudentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        return jpaStudentRepository.save(student);
    }

    @Override
    public Page<Student> getAllStudents(int page, int size) {
        return jpaStudentRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Optional<Student> findById(String studentId) {
        return jpaStudentRepository.findById(studentId);
    }

    @Override
    public void deleteById(String studentId) {
        jpaStudentRepository.deleteById(studentId);
    }

    @Override
    public List<Class> findClassesForStudent(String studentId) {
        return jpaStudentRepository.findClassesForStudent(studentId);
    }
}
