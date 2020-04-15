package mk.ukim.finki.wp.project_v1.repository.mongo;

import mk.ukim.finki.wp.project_v1.model.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MongoTodoRepository extends MongoRepository<ToDo, String> {


    @Query("select t from ToDo t where t.completed = true ")
    List<ToDo> getCompleted();

    @Query("select t from ToDo t where t.completed = false ")
    List<ToDo> getUncompleted();

}
