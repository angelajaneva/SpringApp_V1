package mk.ukim.finki.wp.project_v1.repository;

import mk.ukim.finki.wp.project_v1.model.Question;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository {

    Flux<Question> getAllQuestions();

    Mono<Question> save(Question question);

    Page<Question> getAllQuestions(int page, int size);

    Mono<Question> findById(String questionId);

    Mono<Void> deleteById(String questionId);

    Flux<Question> findQuestionsByAClass(String AClass);
}
