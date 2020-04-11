package mk.ukim.finki.wp.project_v1.repository.impl;

import mk.ukim.finki.wp.project_v1.model.Comment;
import mk.ukim.finki.wp.project_v1.repository.CommentRepository;
import mk.ukim.finki.wp.project_v1.repository.jpa.JpaCommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    private final JpaCommentRepository jpaCommentRepository;

    public CommentRepositoryImpl(JpaCommentRepository jpaCommentRepository) {
        this.jpaCommentRepository = jpaCommentRepository;
    }

    @Override
    public List<Comment> getAllComments() {
        return jpaCommentRepository.findAll();
    }

    @Override
    public Comment save(Comment comment) {
        return jpaCommentRepository.save(comment);
    }

    @Override
    public Page<Comment> getAllComments(int page, int size) {
        return jpaCommentRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Optional<Comment> findById(long commentId) {
        return jpaCommentRepository.findById(commentId);
    }

    @Override
    public void deleteById(long commentId) {
        jpaCommentRepository.deleteById(commentId);
    }

    @Override
    public List<Comment> findCommentsByQuestion_Id(String questionId) {
        return jpaCommentRepository.findCommentsByQuestion_Id(questionId);
    }
}
