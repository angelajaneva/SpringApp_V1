package mk.ukim.finki.wp.project_v1.repository.impl;

import mk.ukim.finki.wp.project_v1.model.Question;
import mk.ukim.finki.wp.project_v1.repository.QuestionRepository;
import mk.ukim.finki.wp.project_v1.repository.mongo.MongoQuestionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    private final MongoQuestionRepository mongoQuestionRepository;

    public QuestionRepositoryImpl(MongoQuestionRepository jpaQuestionRepository) {
        this.mongoQuestionRepository = jpaQuestionRepository;
    }

    @Override
    public Flux<Question> getAllQuestions() {
        return mongoQuestionRepository.findAll();
    }

    @Override
    public Mono<Question> save(Question question) {
        return mongoQuestionRepository.save(question);
    }

    @Override
    public Page<Question> getAllQuestions(int page, int size) {
        return null;
//        return mongoQuestionRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Mono<Question> findById(String questionId) {
        return mongoQuestionRepository.findById(questionId);
    }

    @Override
    public Mono<Void> deleteById(String questionId) {
        return mongoQuestionRepository.deleteById(questionId);
    }

    @Override
    public Flux<Question> findQuestionsByAClass(String AClass) {
        return mongoQuestionRepository.getQuestionsByaClass_Id(AClass);
    }
}
