package mk.ukim.finki.wp.project_v1.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import mk.ukim.finki.wp.project_v1.model.Class;

import java.util.List;


public interface JpaClassRepository extends JpaRepository<Class, String> {

    List<Class> findClassesByStudents_Id(String studentId);
}
