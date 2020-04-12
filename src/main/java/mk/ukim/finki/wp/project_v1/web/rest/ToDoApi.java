package mk.ukim.finki.wp.project_v1.web.rest;

import mk.ukim.finki.wp.project_v1.model.ToDo;
import mk.ukim.finki.wp.project_v1.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)

public class ToDoApi {

    private final ToDoService toDoService;

    public ToDoApi(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/todos")
    public List<ToDo> getAll() {
        return toDoService.getAllTodos();
    }

    @GetMapping("/todo/{todoId}")
    public ToDo getById(@PathVariable String todoId) {
        return toDoService.findById(todoId).orElseThrow(RuntimeException::new);
    }

    @GetMapping("/todos/completed")
    public List<ToDo> getCompleted() {
        return toDoService.getCompleted();
    }

    @GetMapping("/todos/uncompleted")
    public List<ToDo> getUncompleted() {
        return toDoService.getUncompleted();
    }

    @PatchMapping("/todo/{todoId}")
    public ToDo edit(@PathVariable String todoId, @RequestParam String text,
                     @RequestParam boolean done) {
       return toDoService.updateToDo(todoId, text, done);
    }

    @PostMapping("/todo")
    @ResponseStatus(HttpStatus.CREATED)
    public ToDo create(@RequestParam String text) {
        ToDo toDo = new ToDo();

        toDo.setText(text);
        toDo.setCompleted(false);
        toDo.setDate(LocalDate.now());

        return toDoService.save(toDo);
    }

    @DeleteMapping("/todo/{todoId}")
    public void deleteToDo(@PathVariable String todoId) {
        toDoService.deleteById(todoId);
    }


    @GetMapping(path = "/todo/search", params = "term")
    public List<ToDo> searchToDos(@RequestParam String term) {
        return toDoService.searchTermInToDo(term);
    }
}
