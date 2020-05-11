package mk.ukim.finki.wp.project_v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "question")
public class Question {

    @Id
    private String id;

    @Field(value = "text")
    private String text;

    @Field(value = "student")
    private Student student;

    @Field(value = "aclass")
    private Class aClass;
}
