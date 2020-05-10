package mk.ukim.finki.wp.project_v1.repository;

import mk.ukim.finki.wp.project_v1.model.Class;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClassRepository {

    Flux<Class> getAllClasses();

    Mono<Class> save(Class aClass);

    Mono<Class> findById(String classId);

    Mono<Void> deleteById(String classId);

    Flux<Class> findClassesByStudents_username(String username);

    Mono<Class> findByName(String className);

}
