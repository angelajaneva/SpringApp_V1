package mk.ukim.finki.wp.project_v1.repository.mongo;

import mk.ukim.finki.wp.project_v1.model.Class;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



public interface MongoClassRepository extends ReactiveMongoRepository<Class, String> {

    Flux<Class> findClassesByStudents_username(String username);

    Mono<Class> findByName(String className);
}
