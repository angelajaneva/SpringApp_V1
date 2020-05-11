package mk.ukim.finki.wp.project_v1.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "notes")
public class Note {

    @Id
    String id;

    @Field(value = "title")
    String title;

    @Field(value = "description")
    String description;

    @Field(value = "aclass")
    Class aClass;

    @Field(value = "student")
    Student student;

}
