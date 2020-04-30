package mk.ukim.finki.wp.project_v1.service.impl;

import mk.ukim.finki.wp.project_v1.model.ToDo;
import mk.ukim.finki.wp.project_v1.repository.ToDoRepository;
import mk.ukim.finki.wp.project_v1.service.ToDoService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }


    @Override
    public Flux<ToDo> getAllTodos() {
        return toDoRepository.getAllTodos();
    }

    @Override
    public Mono<ToDo> save(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @Override
    public Mono<ToDo> findById(String todoId) {
        return toDoRepository.findById(todoId);
    }

    @Override
    public Mono<Void> deleteById(String todoId) {
        return toDoRepository.deleteById(todoId);
    }

    @Override
    public Flux<ToDo> getCompleted() {
        return toDoRepository.getCompleted();
    }

    @Override
    public Flux<ToDo> getUncompleted() {
        return toDoRepository.getUncompleted();
    }

    @Override
    public Mono<ToDo> updateToDo(String id, String text, boolean done) {
        return toDoRepository.findById(id).flatMap(todo -> {
            todo.setText(text);
            todo.setCompleted(done);
            return toDoRepository.save(todo);
        });
    }


    @Override
    public Flux<ToDo> searchTermInToDo(String term) {

        return this.getAllTodos()
                .filter(toDo -> toDo.getText().toLowerCase().contains(term));
    }
}

