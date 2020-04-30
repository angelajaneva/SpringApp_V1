package mk.ukim.finki.wp.project_v1.repository.impl;

import mk.ukim.finki.wp.project_v1.model.ToDo;
import mk.ukim.finki.wp.project_v1.repository.ToDoRepository;
import mk.ukim.finki.wp.project_v1.repository.mongo.MongoTodoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public class ToDoRepositoryImpl implements ToDoRepository {

    private final MongoTodoRepository mongoTodoRepository;

    public ToDoRepositoryImpl(MongoTodoRepository jpaTodoRepository) {
        this.mongoTodoRepository = jpaTodoRepository;
    }


    @Override
    public Flux<ToDo> getAllTodos() {
        return mongoTodoRepository.findAll();
    }

    @Override
    public Mono<ToDo> save(ToDo toDo) {
        return mongoTodoRepository.save(toDo);
    }


    @Override
    public Mono<ToDo> findById(String todoId) {
        return mongoTodoRepository.findById(todoId);
    }

    @Override
    public Mono<Void> deleteById(String todoId) {
        return mongoTodoRepository.deleteById(todoId);
    }

    @Override
    public Flux<ToDo> getCompleted() {
        return mongoTodoRepository.getCompleted();
    }

    @Override
    public Flux<ToDo> getUncompleted() {
        return mongoTodoRepository.getUncompleted();
    }
}
