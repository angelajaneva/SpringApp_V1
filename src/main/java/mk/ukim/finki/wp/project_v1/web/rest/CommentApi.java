package mk.ukim.finki.wp.project_v1.web.rest;

import mk.ukim.finki.wp.project_v1.model.Comment;
import mk.ukim.finki.wp.project_v1.service.CommentService;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class CommentApi {

    private final CommentService commentService;

    public CommentApi(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("{questionId}/comments")
    public List<Comment> getCommentsForQuestion(@PathVariable String questionId){
        return commentService.findCommentsByQuestion_Id(questionId);
    }
}
