package mk.ukim.finki.wp.project_v1.repository.impl;

import mk.ukim.finki.wp.project_v1.repository.ClassRepository;
import mk.ukim.finki.wp.project_v1.repository.jpa.JpaClassRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;
import mk.ukim.finki.wp.project_v1.model.Class;
import org.springframework.stereotype.Repository;

@Repository
public class ClassRepositoryImpl implements ClassRepository {

    private final JpaClassRepository jpaClassRepository;

    public ClassRepositoryImpl(JpaClassRepository jpaClassRepository) {
        this.jpaClassRepository = jpaClassRepository;
    }

    @Override
    public List<Class> getAllClasses() {
        return jpaClassRepository.findAll();
    }

    @Override
    public Class save(Class aClass) {
        return jpaClassRepository.save(aClass);
    }

    @Override
    public Page<Class> getAllClasses(int page, int size) {
        return jpaClassRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Optional<Class> findById(String classId) {
        return jpaClassRepository.findById(classId);
    }

    @Override
    public void deleteById(String classId) {
        jpaClassRepository.deleteById(classId);
    }

    @Override
    public List<Class> findClassesByStudents_Id(String studentId) {
        return jpaClassRepository.findClassesByStudents_Id(studentId);
    }
}
