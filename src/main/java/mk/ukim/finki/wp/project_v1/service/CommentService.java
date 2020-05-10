package mk.ukim.finki.wp.project_v1.service;

import mk.ukim.finki.wp.project_v1.model.Comment;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    Flux<Comment> getAllComments();

    Mono<Comment> save(Comment comment);

    Mono<Comment> findById(String commentId);

    Mono<Void> deleteById(String commentId);

    Flux<Comment> findCommentsByQuestion_Id(String questionId);

    Mono<Comment> newComment(String questionId, String content, String username);

}


