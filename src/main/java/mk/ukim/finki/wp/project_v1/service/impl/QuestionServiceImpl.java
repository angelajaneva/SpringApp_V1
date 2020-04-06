package mk.ukim.finki.wp.project_v1.service.impl;

import mk.ukim.finki.wp.project_v1.model.Question;
import mk.ukim.finki.wp.project_v1.repository.QuestionRepository;
import mk.ukim.finki.wp.project_v1.service.QuestionService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.getAllQuestions();
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Page<Question> getAllQuestions(int page, int size) {
        return questionRepository.getAllQuestions(page, size);
    }

    @Override
    public Optional<Question> findById(String questionId) {
        return questionRepository.findById(questionId);
    }

    @Override
    public void deleteById(String questionId) {
        questionRepository.deleteById(questionId);
    }

    @Override
    public List<Question> findQuestionByAClass_Id(String AClass) {
        return questionRepository.findQuestionsByAClass(AClass);
    }
}
