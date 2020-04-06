package mk.ukim.finki.wp.project_v1.service;

import mk.ukim.finki.wp.project_v1.model.Question;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    List<Question> getAllQuestions();

    Question save(Question question);

    Page<Question> getAllQuestions(int page, int size);

    Optional<Question> findById(String questionId);

    void deleteById(String questionId);

    List<Question> findQuestionByAClass_Id(String AClass);

}
