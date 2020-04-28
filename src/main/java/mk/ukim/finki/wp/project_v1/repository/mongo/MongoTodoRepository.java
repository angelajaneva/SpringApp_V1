package mk.ukim.finki.wp.project_v1.repository.mongo;

import mk.ukim.finki.wp.project_v1.model.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MongoTodoRepository extends MongoRepository<ToDo, String> {

    @Query(value =  "{ 'completed' : 'true'}")
    List<ToDo> getCompleted();

    @Query(value =  "{ 'completed' : 'false'}")
    List<ToDo> getUncompleted();

}
