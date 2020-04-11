package mk.ukim.finki.wp.project_v1.web.rest;


import mk.ukim.finki.wp.project_v1.model.Class;
import mk.ukim.finki.wp.project_v1.model.Question;
import mk.ukim.finki.wp.project_v1.model.Student;
import mk.ukim.finki.wp.project_v1.service.ClassService;
import mk.ukim.finki.wp.project_v1.service.QuestionService;
import mk.ukim.finki.wp.project_v1.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class QuestionApi {

    private final QuestionService questionService;
    private final ClassService classService;
    private final StudentService studentService;

    public QuestionApi(QuestionService questionService, ClassService classService, StudentService studentService) {
        this.questionService = questionService;
        this.classService = classService;
        this.studentService = studentService;
    }

    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

//    @GetMapping("/{questionId}")
//    public Question getQuestionById(@PathVariable String questionId){
//        return questionService.findById(questionId).orElseThrow(RuntimeException::new);
//    }


    @GetMapping("/{classId}/questions")
    public List<Question> getQuestionsForClass(@PathVariable String classId) {
        return questionService.findQuestionByAClass_Id(classId);
    }

    @PostMapping("/question")
    @ResponseStatus(HttpStatus.CREATED)
    public Question createQuestion(@RequestParam String classId, @RequestParam String text) {
        Question question = new Question();

        Class aClass = classService.findById(classId).orElseThrow(RuntimeException::new);
        question.setAClass(aClass);
        question.setText(text);

        //studentot treba da se srede preku authentication
        Student student = studentService.findById("S17001").orElseThrow(RuntimeException::new);
        question.setStudent(student);
        return questionService.save(question);
    }

    @DeleteMapping("/questions/{questionId}")
    public void deleteQuestion(@PathVariable String questionId) {
        questionService.deleteById(questionId);
    }
}
