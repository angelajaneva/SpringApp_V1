package mk.ukim.finki.wp.project_v1.repository.impl;

import mk.ukim.finki.wp.project_v1.model.ToDo;
import mk.ukim.finki.wp.project_v1.repository.ToDoRepository;
import mk.ukim.finki.wp.project_v1.repository.jpa.JpaTodoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ToDoRepositoryImpl implements ToDoRepository {

    private final JpaTodoRepository jpaTodoRepository;

    public ToDoRepositoryImpl(JpaTodoRepository jpaTodoRepository) {
        this.jpaTodoRepository = jpaTodoRepository;
    }


    @Override
    public List<ToDo> getAllTodos() {
        return jpaTodoRepository.findAll();
    }

    @Override
    public ToDo save(ToDo toDo) {
        return jpaTodoRepository.save(toDo);
    }

    @Override
    public Page<ToDo> getAllStudents(int page, int size) {
        return jpaTodoRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Optional<ToDo> findById(String todoId) {
        return jpaTodoRepository.findById(todoId);
    }

    @Override
    public void deleteById(String todoId) {
        jpaTodoRepository.deleteById(todoId);
    }

    @Override
    public List<ToDo> getCompleted() {
        return jpaTodoRepository.getCompleted();
    }

    @Override
    public List<ToDo> getUncompleted() {
        return jpaTodoRepository.getUncompleted();
    }
}
