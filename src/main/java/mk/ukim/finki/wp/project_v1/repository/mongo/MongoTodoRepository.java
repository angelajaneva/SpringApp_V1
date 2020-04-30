package mk.ukim.finki.wp.project_v1.repository.mongo;

import mk.ukim.finki.wp.project_v1.model.ToDo;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;


public interface MongoTodoRepository extends ReactiveMongoRepository<ToDo, String> {

    @Query(value =  "{ 'completed' : 'true'}")
    Flux<ToDo> getCompleted();

    @Query(value =  "{ 'completed' : 'false'}")
    Flux<ToDo> getUncompleted();

}
