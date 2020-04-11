package mk.ukim.finki.wp.project_v1.service.impl;

import mk.ukim.finki.wp.project_v1.model.Comment;
import mk.ukim.finki.wp.project_v1.repository.CommentRepository;
import mk.ukim.finki.wp.project_v1.service.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.getAllComments();
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Page<Comment> getAllComments(int page, int size) {
        return commentRepository.getAllComments(page, size);
    }

    @Override
    public Optional<Comment> findById(long commentId) {
        return commentRepository.findById(commentId);
    }

    @Override
    public void deleteById(long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public List<Comment> findCommentsByQuestion_Id(String questionId) {
        return commentRepository.findCommentsByQuestion_Id(questionId);
    }
}
