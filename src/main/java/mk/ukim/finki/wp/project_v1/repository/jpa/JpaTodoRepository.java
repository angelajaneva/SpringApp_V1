package mk.ukim.finki.wp.project_v1.repository.jpa;

import mk.ukim.finki.wp.project_v1.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaTodoRepository extends JpaRepository<ToDo, String> {


    @Query("select t from ToDo t where t.completed = true ")
    List<ToDo> getCompleted();

    @Query("select t from ToDo t where t.completed = false ")
    List<ToDo> getUncompleted();

}
