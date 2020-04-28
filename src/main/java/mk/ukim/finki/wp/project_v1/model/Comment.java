package mk.ukim.finki.wp.project_v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "comment")
public class Comment {

    @Id
    @Field(value = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Field(value = "content")
    private String content;

    @Field(value = "createdOn")
    private LocalDate createdOn;

    @Field(value = "question")
    @ManyToOne
    private Question question;

    @Field(value = "student")
    @ManyToOne
    private Student student;
}
