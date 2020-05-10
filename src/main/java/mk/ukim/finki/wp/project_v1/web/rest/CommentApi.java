package mk.ukim.finki.wp.project_v1.web.rest;

import mk.ukim.finki.wp.project_v1.model.Comment;
import mk.ukim.finki.wp.project_v1.model.Student;
import mk.ukim.finki.wp.project_v1.service.CommentService;
import mk.ukim.finki.wp.project_v1.service.QuestionService;
import mk.ukim.finki.wp.project_v1.service.StudentService;
import mk.ukim.finki.wp.project_v1.service.UserService;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class CommentApi {

    private final CommentService commentService;

    public CommentApi(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    public Flux<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("{questionId}/comments")
    public Flux<Comment> getCommentsForQuestion(@PathVariable String questionId) {
        return commentService.findCommentsByQuestion_Id(questionId);
    }

    @PostMapping("/comments/{questionId}")
    public Mono<Comment> newComment(@PathVariable String questionId, @RequestParam String content,
        @RequestParam String username) {
        return commentService.newComment(questionId, content, username);
    }
}
