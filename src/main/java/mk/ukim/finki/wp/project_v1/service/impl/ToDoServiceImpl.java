package mk.ukim.finki.wp.project_v1.service.impl;

import mk.ukim.finki.wp.project_v1.model.ToDo;
import mk.ukim.finki.wp.project_v1.repository.ToDoRepository;
import mk.ukim.finki.wp.project_v1.repository.UserRepository;
import mk.ukim.finki.wp.project_v1.service.ToDoService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository;
    private final UserRepository userRepository;

    public ToDoServiceImpl(ToDoRepository toDoRepository, UserRepository userRepository) {
        this.toDoRepository = toDoRepository;
        this.userRepository = userRepository;
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

    @Override
    public Flux<ToDo> getAllByUsername(String username) {
        return toDoRepository.getAllByUsername(username);
    }

    @Override
    public Mono<ToDo> create(String text, String username) {
        ToDo toDo = new ToDo();

        toDo.setUser(userRepository.findByUsername(username));
        toDo.setText(text);
        toDo.setCompleted(false);
        toDo.setDate(LocalDate.now());

        return toDoRepository.save(toDo);

    }
}

