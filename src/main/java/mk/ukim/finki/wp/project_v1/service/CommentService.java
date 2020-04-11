package mk.ukim.finki.wp.project_v1.service;

import mk.ukim.finki.wp.project_v1.model.Comment;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    List<Comment> getAllComments();

    Comment save(Comment comment);

    Page<Comment> getAllComments(int page, int size);

    Optional<Comment> findById(long commentId);

    void deleteById(long commentId);

    List<Comment> findCommentsByQuestion_Id(String questionId);

}


