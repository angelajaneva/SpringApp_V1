package mk.ukim.finki.wp.project_v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @Column(name = "comment_id")
    @SequenceGenerator(name = "seq", initialValue = 30)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;
    private String content;
    private LocalDate createdOn;

    @ManyToOne
    private Question question;
    @ManyToOne
    private Student student;

}
