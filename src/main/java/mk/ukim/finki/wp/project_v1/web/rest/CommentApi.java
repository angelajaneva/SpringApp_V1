package mk.ukim.finki.wp.project_v1.web.rest;

import mk.ukim.finki.wp.project_v1.model.Comment;
import mk.ukim.finki.wp.project_v1.model.Question;
import mk.ukim.finki.wp.project_v1.service.CommentService;
import mk.ukim.finki.wp.project_v1.service.QuestionService;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class CommentApi {

    private final CommentService commentService;
    private final QuestionService questionService;

    public CommentApi(CommentService commentService, QuestionService questionService) {
        this.commentService = commentService;
        this.questionService = questionService;
    }

    @GetMapping("{questionId}/comments")
    public List<Comment> getCommentsForQuestion(@PathVariable String questionId){
        return commentService.findCommentsByQuestion_Id(questionId);
    }

    @PostMapping("/comments/{questionId}")
    public Comment newComment(@PathVariable String questionId, @RequestParam String content){
        //@RequestParam String studentId
        Comment comment = new Comment();

        Question question = questionService.findById(questionId).orElseThrow(RuntimeException::new);
        comment.setQuestion(question);
        comment.setContent(content);
        comment.setCreatedOn(LocalDate.now());

        return commentService.save(comment);
    }
}
