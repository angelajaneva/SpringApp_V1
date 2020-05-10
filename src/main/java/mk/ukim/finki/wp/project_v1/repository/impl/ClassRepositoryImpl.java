package mk.ukim.finki.wp.project_v1.repository.impl;

import mk.ukim.finki.wp.project_v1.repository.ClassRepository;
import mk.ukim.finki.wp.project_v1.repository.mongo.MongoClassRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;
import mk.ukim.finki.wp.project_v1.model.Class;
import org.springframework.stereotype.Repository;

@Repository
public class ClassRepositoryImpl implements ClassRepository {

    private final MongoClassRepository mongoClassRepository;

    public ClassRepositoryImpl(MongoClassRepository mongoClassRepository) {
        this.mongoClassRepository = mongoClassRepository;
    }

    @Override
    public List<Class> getAllClasses() {
        return mongoClassRepository.findAll();
    }

    @Override
    public Class save(Class aClass) {
        return mongoClassRepository.save(aClass);
    }

    @Override
    public Page<Class> getAllClasses(int page, int size) {
        return mongoClassRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Optional<Class> findById(String classId) {
        return mongoClassRepository.findById(classId);
    }

    @Override
    public void deleteById(String classId) {
        mongoClassRepository.deleteById(classId);
    }

    @Override
    public List<Class> findClassesByStudents_username(String username) {
        return mongoClassRepository.findClassesByStudents_username(username);
    }

    @Override
    public Class findByName(String className) {
        return mongoClassRepository.findByName(className);
    }
}
