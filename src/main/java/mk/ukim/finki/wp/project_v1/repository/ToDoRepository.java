package mk.ukim.finki.wp.project_v1.repository;

import mk.ukim.finki.wp.project_v1.model.ToDo;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository {

    Flux<ToDo> getAllTodos();

    Mono<ToDo> save(ToDo toDo);

    Mono<ToDo> findById(String todoId);

    Mono<Void> deleteById(String todoId);

    Flux<ToDo> getCompleted();

    Flux<ToDo> getUncompleted();
}
