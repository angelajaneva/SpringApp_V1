package mk.ukim.finki.wp.project_v1.service.impl;

import mk.ukim.finki.wp.project_v1.model.Question;
import mk.ukim.finki.wp.project_v1.model.Student;
import mk.ukim.finki.wp.project_v1.repository.ClassRepository;
import mk.ukim.finki.wp.project_v1.repository.QuestionRepository;
import mk.ukim.finki.wp.project_v1.repository.UserRepository;
import mk.ukim.finki.wp.project_v1.service.QuestionService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    private final ClassRepository classRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, UserRepository userRepository, ClassRepository classRepository) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
        this.classRepository = classRepository;
    }

    @Override
    public Flux<Question> getAllQuestions() {
        return questionRepository.getAllQuestions();
    }

    @Override
    public Mono<Question> save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Page<Question> getAllQuestions(int page, int size) {
        return questionRepository.getAllQuestions(page, size);
    }

    @Override
    public Mono<Question> findById(String questionId) {
        return questionRepository.findById(questionId);
    }

    @Override
    public Mono<Void> deleteById(String questionId) {
        return questionRepository.deleteById(questionId);
    }

    @Override
    public Flux<Question> findQuestionByAClass_Id(String AClass) {
        return questionRepository.findQuestionsByAClass(AClass);
    }

    @Override
    public Mono<Question> createQuestion(String classId, String text, String username) {

        Question question = new Question();
        Student student = userRepository.findByUsername(username).getStudent();


        question.setStudent(student);
        question.setAClass(classRepository.findById(classId).orElseThrow(RuntimeException::new));
        question.setText(text);

        return questionRepository.save(question);

    }
}
