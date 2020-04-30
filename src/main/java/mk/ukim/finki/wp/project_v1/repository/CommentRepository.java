package mk.ukim.finki.wp.project_v1.repository;

import mk.ukim.finki.wp.project_v1.model.Comment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface CommentRepository {

    Flux<Comment> getAllComments();

    Mono<Comment> save(Comment comment);

    Mono<Comment> findById(String commentId);

    Mono<Void> deleteById(String commentId);

    Flux<Comment> findCommentsByQuestion_Id(String questionId);

}
