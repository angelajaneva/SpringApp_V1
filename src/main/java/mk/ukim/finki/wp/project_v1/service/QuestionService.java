package mk.ukim.finki.wp.project_v1.service;

import mk.ukim.finki.wp.project_v1.model.Question;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface QuestionService {

    Flux<Question> getAllQuestions();

    Mono<Question> save(Question question);

    Page<Question> getAllQuestions(int page, int size);

    Mono<Question> findById(String questionId);

    Mono<Void> deleteById(String questionId);

    Flux<Question> findQuestionByAClass_Id(String AClass);

}
