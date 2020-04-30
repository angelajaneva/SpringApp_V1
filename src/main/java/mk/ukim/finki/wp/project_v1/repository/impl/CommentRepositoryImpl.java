package mk.ukim.finki.wp.project_v1.repository.impl;

import mk.ukim.finki.wp.project_v1.model.Comment;
import mk.ukim.finki.wp.project_v1.repository.CommentRepository;
import mk.ukim.finki.wp.project_v1.repository.mongo.MongoCommentRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    private final MongoCommentRepository mongoCommentRepository;

    public CommentRepositoryImpl(MongoCommentRepository mongoCommentRepository) {
        this.mongoCommentRepository = mongoCommentRepository;
    }

    @Override
    public Flux<Comment> getAllComments() {
        return mongoCommentRepository.findAll();
    }

    @Override
    public Mono<Comment> save(Comment comment) {
        return mongoCommentRepository.save(comment);
    }

    @Override
    public Mono<Comment> findById(String commentId) {
        return mongoCommentRepository.findById(commentId);
    }

    @Override
    public Mono<Void> deleteById(String commentId) {
        return mongoCommentRepository.deleteById(commentId);
    }

    @Override
    public Flux<Comment> findCommentsByQuestion_Id(String questionId) {
        return mongoCommentRepository.getCommentsByQuestion_Id(questionId);
    }
}
