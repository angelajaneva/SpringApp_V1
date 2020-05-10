package mk.ukim.finki.wp.project_v1.service.impl;

import mk.ukim.finki.wp.project_v1.model.Comment;
import mk.ukim.finki.wp.project_v1.model.Student;
import mk.ukim.finki.wp.project_v1.repository.CommentRepository;
import mk.ukim.finki.wp.project_v1.repository.QuestionRepository;
import mk.ukim.finki.wp.project_v1.repository.UserRepository;
import mk.ukim.finki.wp.project_v1.service.CommentService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public CommentServiceImpl(CommentRepository commentRepository, QuestionRepository questionRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
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

    @Override
    public Mono<Comment> newComment(String questionId, String content, String username) {

        Comment comment = new Comment();
        Student student = userRepository.findByUsername(username).getStudent();

        return questionRepository.findById(questionId).flatMap(question1 -> {
            comment.setStudent(student);
            comment.setQuestion(question1);
            comment.setContent(content);
            comment.setCreatedOn(LocalDate.now());
            return commentRepository.save(comment);
        });
    }
}
