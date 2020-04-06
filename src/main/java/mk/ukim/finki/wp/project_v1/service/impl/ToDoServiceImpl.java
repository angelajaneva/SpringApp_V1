package mk.ukim.finki.wp.project_v1.service.impl;

import mk.ukim.finki.wp.project_v1.model.ToDo;
import mk.ukim.finki.wp.project_v1.repository.ToDoRepository;
import mk.ukim.finki.wp.project_v1.service.ToDoService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }


    @Override
    public List<ToDo> getAllTodos() {
        return toDoRepository.getAllTodos();
    }

    @Override
    public ToDo save(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @Override
    public Page<ToDo> getAllToDos(int page, int size) {
        return toDoRepository.getAllStudents(page, size);
    }

    @Override
    public Optional<ToDo> findById(String todoId) {
        return toDoRepository.findById(todoId);
    }

    @Override
    public void deleteById(String todoId) {
        toDoRepository.deleteById(todoId);
    }

    @Override
    public List<ToDo> getCompleted() {
        return toDoRepository.getCompleted();
    }

    @Override
    public List<ToDo> getUncompleted() {
        return toDoRepository.getUncompleted();
    }

    @Override
    public ToDo updateToDo(String id, String text, boolean done) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(RuntimeException::new);
        toDo.setText(text);
        toDo.setCompleted(done);
        toDoRepository.save(toDo);
        return toDo;
    }
}
