package mk.ukim.finki.wp.project_v1.service.impl;

import mk.ukim.finki.wp.project_v1.model.Class;
import mk.ukim.finki.wp.project_v1.repository.ClassRepository;
import mk.ukim.finki.wp.project_v1.service.ClassService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;

    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public Flux<Class> getAllClasses() {
        return classRepository.getAllClasses();
    }

    @Override
    public Mono<Class> save(Class aClass) {
        return classRepository.save(aClass);
    }

    @Override
    public Mono<Class> findById(String classId) {
        return classRepository.findById(classId);
    }

    @Override
    public Mono<Void> deleteById(String classId) {
        return classRepository.deleteById(classId);
    }

    @Override
    public Flux<Class> findClassesByStudents_username(String username) {
        return classRepository.findClassesByStudents_username(username);
    }

    @Override
    public Mono<Class> findByName(String className) {
        return classRepository.findByName(className);
    }
}
