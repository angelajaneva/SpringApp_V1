package mk.ukim.finki.wp.project_v1.service.impl;

import mk.ukim.finki.wp.project_v1.model.Comment;
import mk.ukim.finki.wp.project_v1.repository.CommentRepository;
import mk.ukim.finki.wp.project_v1.service.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Flux<Comment> getAllComments() {
        return commentRepository.getAllComments();
    }

    @Override
    public Mono<Comment> save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Mono<Comment> findById(String commentId) {
        return commentRepository.findById(commentId);
    }

    @Override
    public Mono<Void> deleteById(String commentId) {
        return commentRepository.deleteById(commentId);
    }

    @Override
    public Flux<Comment> findCommentsByQuestion_Id(String questionId) {
        return commentRepository.findCommentsByQuestion_Id(questionId);
    }
}
