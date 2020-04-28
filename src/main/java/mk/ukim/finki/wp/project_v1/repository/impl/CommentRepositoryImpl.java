package mk.ukim.finki.wp.project_v1.repository.impl;

import mk.ukim.finki.wp.project_v1.model.Comment;
import mk.ukim.finki.wp.project_v1.repository.CommentRepository;
import mk.ukim.finki.wp.project_v1.repository.mongo.MongoCommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    private final MongoCommentRepository mongoCommentRepository;

    public CommentRepositoryImpl(MongoCommentRepository mongoCommentRepository) {
        this.mongoCommentRepository = mongoCommentRepository;
    }

    @Override
    public List<Comment> getAllComments() {
        return mongoCommentRepository.findAll();
    }

    @Override
    public Comment save(Comment comment) {
        return mongoCommentRepository.save(comment);
    }

    @Override
    public Page<Comment> getAllComments(int page, int size) {
        return mongoCommentRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Optional<Comment> findById(long commentId) {
        return mongoCommentRepository.findById(commentId);
    }

    @Override
    public void deleteById(long commentId) {
        mongoCommentRepository.deleteById(commentId);
    }

    @Override
    public List<Comment> findCommentsByQuestion_Id(String questionId) {
        return mongoCommentRepository.findByQuestion_Id(questionId);
    }
}
