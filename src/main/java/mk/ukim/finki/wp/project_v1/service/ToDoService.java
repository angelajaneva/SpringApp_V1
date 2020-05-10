package mk.ukim.finki.wp.project_v1.service;

import mk.ukim.finki.wp.project_v1.model.ToDo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ToDoService {

    Flux<ToDo> getAllTodos();

    Mono<ToDo> save(ToDo toDo);

    Mono<ToDo> findById(String todoId);

    Mono<Void> deleteById(String todoId);

    Flux<ToDo> getCompleted();

    Flux<ToDo> getUncompleted();

    Mono<ToDo> updateToDo (String id, String text, boolean done);

    Flux<ToDo> searchTermInToDo(String term);

    Flux<ToDo> getAllByUsername(String username);

    Mono<ToDo> create(String text, String username);
}
