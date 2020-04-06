package mk.ukim.finki.wp.project_v1.repository.jpa;

import mk.ukim.finki.wp.project_v1.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaCommentRepository extends JpaRepository<Comment, String> {

    List<Comment> findCommentsByQuestion_Id(String questionId);
}
