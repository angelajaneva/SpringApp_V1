package mk.ukim.finki.wp.project_v1.service.impl;

import mk.ukim.finki.wp.project_v1.model.Class;
import mk.ukim.finki.wp.project_v1.repository.ClassRepository;
import mk.ukim.finki.wp.project_v1.service.ClassService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;

    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public List<Class> getAllClasses() {
        return classRepository.getAllClasses();
    }

    @Override
    public Class save(Class aClass) {
        return classRepository.save(aClass);
    }

    @Override
    public Page<Class> getAllClasses(int page, int size) {
        return classRepository.getAllClasses(page, size);
    }

    @Override
    public Optional<Class> findById(String classId) {
        return classRepository.findById(classId);
    }

    @Override
    public void deleteById(String classId) {
        classRepository.deleteById(classId);
    }

    @Override
    public List<Class> findClassesByStudents_username(String username) {
        return classRepository.findClassesByStudents_username(username);
    }

    @Override
    public Class findByName(String className) {
        return classRepository.findByName(className);
    }
}
