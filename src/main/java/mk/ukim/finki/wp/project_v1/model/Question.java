package mk.ukim.finki.wp.project_v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question {

    @Id
    @Column(name = "question_id")
    private String id;
    private String text;

    @ManyToOne
    private Student student;
    @ManyToOne
    private Class aClass;
}
