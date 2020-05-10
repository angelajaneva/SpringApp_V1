package mk.ukim.finki.wp.project_v1.repository.impl;

import mk.ukim.finki.wp.project_v1.repository.ClassRepository;
import mk.ukim.finki.wp.project_v1.repository.mongo.MongoClassRepository;

import mk.ukim.finki.wp.project_v1.model.Class;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ClassRepositoryImpl implements ClassRepository {

    private final MongoClassRepository mongoClassRepository;

    public ClassRepositoryImpl(MongoClassRepository mongoClassRepository) {
        this.mongoClassRepository = mongoClassRepository;
    }

    @Override
    public Flux<Class> getAllClasses() {
        return mongoClassRepository.findAll();
    }

    @Override
    public Mono<Class> save(Class aClass) {
        return mongoClassRepository.save(aClass);
    }

    @Override
    public Mono<Class> findById(String classId) {
        return mongoClassRepository.findById(classId);
    }

    @Override
    public Mono<Void> deleteById(String classId) {

        return mongoClassRepository.deleteById(classId);
    }

    @Override
    public Flux<Class> findClassesByStudents_username(String username) {
        return mongoClassRepository.findClassesByStudents_username(username);
    }

    @Override
    public Mono<Class> findByName(String className) {
        return mongoClassRepository.findByName(className);
    }
}
