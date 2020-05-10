package mk.ukim.finki.wp.project_v1.web.rest;

import mk.ukim.finki.wp.project_v1.model.ToDo;
import mk.ukim.finki.wp.project_v1.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)

public class ToDoApi {

    private final ToDoService toDoService;

    public ToDoApi(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/todos")
    public Flux<ToDo> getAll() {
        return toDoService.getAllTodos();
    }

    @GetMapping("/todo/{todoId}")
    public Mono<ToDo> getById(@PathVariable String todoId) {
        return toDoService.findById(todoId);
    }

    @GetMapping("/todos/completed")
    public Flux<ToDo> getCompleted() {
        return toDoService.getCompleted();
    }

    @GetMapping("/todos/uncompleted")
    public Flux<ToDo> getUncompleted() {
        return toDoService.getUncompleted();
    }

    @GetMapping("todos/{username}")
    public Flux<ToDo> getAllByUsername(@PathVariable String username){
        return toDoService.getAllByUsername(username);
    }

    @PatchMapping("/todo/{todoId}")
    public Mono<ToDo> edit(@PathVariable String todoId, @RequestParam String text,
                     @RequestParam boolean done) {
       return toDoService.updateToDo(todoId, text, done);
    }

    @PostMapping("/todo")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ToDo> create(@RequestParam String text, @RequestParam String username) {
        return toDoService.create(text, username);
    }

    @DeleteMapping("/todo/{todoId}")
    public Mono<Void> deleteToDo(@PathVariable String todoId) {
       return toDoService.deleteById(todoId);
    }


    @GetMapping(path = "/todo/search", params = "term")
    public Flux<ToDo> searchToDos(@RequestParam String term) {
        return toDoService.searchTermInToDo(term);
    }
}
