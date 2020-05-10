package mk.ukim.finki.wp.project_v1.web.rest;


import mk.ukim.finki.wp.project_v1.model.Class;
import mk.ukim.finki.wp.project_v1.model.Question;
import mk.ukim.finki.wp.project_v1.model.Student;
import mk.ukim.finki.wp.project_v1.service.ClassService;
import mk.ukim.finki.wp.project_v1.service.QuestionService;
import mk.ukim.finki.wp.project_v1.service.StudentService;
import mk.ukim.finki.wp.project_v1.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
@RequestMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class QuestionApi {

    private final QuestionService questionService;
    private final ClassService classService;
    private final UserService userService;

    public QuestionApi(QuestionService questionService, ClassService classService, UserService userService) {
        this.questionService = questionService;
        this.classService = classService;
        this.userService = userService;
    }

    @GetMapping("/questions")
    public Flux<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/question/{questionId}")
    public Mono<Question> getQuestionById(@PathVariable String questionId) {
        return questionService.findById(questionId);
    }


    @GetMapping("/{classId}/questions")
    public Flux<Question> getQuestionsForClass(@PathVariable String classId) {
        return questionService.findQuestionByAClass_Id(classId);
    }

    @PostMapping("/question")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Question> createQuestion(@RequestParam String classId, @RequestParam String text,
                                         @RequestParam String username) {
        return questionService.createQuestion(classId, text, username);
    }

    @DeleteMapping("/questions/{questionId}")
    public Mono<Void> deleteQuestion(@PathVariable String questionId) {
        return questionService.deleteById(questionId);
    }
}
