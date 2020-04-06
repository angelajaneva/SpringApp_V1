package mk.ukim.finki.wp.project_v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @Column(name = "comment_id")
    private String id;
    private String content;
    private LocalDateTime createdOn;

    @ManyToOne
    private Question question;
    @ManyToOne
    private Student student;
}
