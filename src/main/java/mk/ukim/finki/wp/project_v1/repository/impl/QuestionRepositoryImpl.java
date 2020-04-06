package mk.ukim.finki.wp.project_v1.repository.impl;

import mk.ukim.finki.wp.project_v1.model.Question;
import mk.ukim.finki.wp.project_v1.repository.QuestionRepository;
import mk.ukim.finki.wp.project_v1.repository.jpa.JpaQuestionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    private final JpaQuestionRepository jpaQuestionRepository;

    public QuestionRepositoryImpl(JpaQuestionRepository jpaQuestionRepository) {
        this.jpaQuestionRepository = jpaQuestionRepository;
    }

    @Override
    public List<Question> getAllQuestions() {
        return jpaQuestionRepository.findAll();
    }

    @Override
    public Question save(Question question) {
        return jpaQuestionRepository.save(question);
    }

    @Override
    public Page<Question> getAllQuestions(int page, int size) {
        return jpaQuestionRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Optional<Question> findById(String questionId) {
        return jpaQuestionRepository.findById(questionId);
    }

    @Override
    public void deleteById(String questionId) {
        jpaQuestionRepository.deleteById(questionId);
    }

    @Override
    public List<Question> findQuestionsByAClass(String AClass) {
        return jpaQuestionRepository.getQuestionsByaClass_Id(AClass);
    }
}
