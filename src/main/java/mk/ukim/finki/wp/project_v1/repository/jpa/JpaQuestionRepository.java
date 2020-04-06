package mk.ukim.finki.wp.project_v1.repository.jpa;

import mk.ukim.finki.wp.project_v1.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaQuestionRepository extends JpaRepository<Question, String> {

    List<Question> getQuestionsByaClass_Id(String classId);

}