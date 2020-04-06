package mk.ukim.finki.wp.project_v1.service;

import mk.ukim.finki.wp.project_v1.model.ToDo;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ToDoService {

    List<ToDo> getAllTodos();

    ToDo save(ToDo toDo);

    Page<ToDo> getAllToDos(int page, int size);

    Optional<ToDo> findById(String todoId);

    void deleteById(String todoId);

    List<ToDo> getCompleted();

    List<ToDo> getUncompleted();

    ToDo updateToDo (String id, String text, boolean done);
}
