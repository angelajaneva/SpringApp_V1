package mk.ukim.finki.wp.project_v1.web.rest;


import mk.ukim.finki.wp.project_v1.model.Question;
import mk.ukim.finki.wp.project_v1.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class QuestionApi {

    private final QuestionService questionService;

    public QuestionApi(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public List<Question> getAllQuestions(){
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

//    @PostMapping("/{classId}/questions")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Question createQuestion(@PathVariable String classId, @RequestParam String text, @RequestParam String id){
//    //id-to kje mora da go vmetnam preku add formata bidejkji dr nacin nema so tekovniot dizajn
      // za class uste ostanuva problem
//    }

    @DeleteMapping("/questions/{questionId}")
    public void deleteQuestion (@PathVariable String questionId){
        questionService.deleteById(questionId);
    }
}
