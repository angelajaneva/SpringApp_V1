package mk.ukim.finki.wp.project_v1.repository.impl;

import mk.ukim.finki.wp.project_v1.model.ToDo;
import mk.ukim.finki.wp.project_v1.repository.ToDoRepository;
import mk.ukim.finki.wp.project_v1.repository.mongo.MongoTodoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ToDoRepositoryImpl implements ToDoRepository {

    private final MongoTodoRepository mongoTodoRepository;

    public ToDoRepositoryImpl(MongoTodoRepository jpaTodoRepository) {
        this.mongoTodoRepository = jpaTodoRepository;
    }


    @Override
    public List<ToDo> getAllTodos() {
        return mongoTodoRepository.findAll();
    }

    @Override
    public ToDo save(ToDo toDo) {
        return mongoTodoRepository.save(toDo);
    }

    @Override
    public Page<ToDo> getAllStudents(int page, int size) {
        return mongoTodoRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Optional<ToDo> findById(String todoId) {
        return mongoTodoRepository.findById(todoId);
    }

    @Override
    public void deleteById(String todoId) {
        mongoTodoRepository.deleteById(todoId);
    }

    @Override
    public List<ToDo> getCompleted() {
        return mongoTodoRepository.getCompleted();
    }

    @Override
    public List<ToDo> getUncompleted() {
        return mongoTodoRepository.getUncompleted();
    }
}
