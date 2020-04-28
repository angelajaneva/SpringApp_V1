package mk.ukim.finki.wp.project_v1.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "notes")
public class Note {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String id;

    @Field(value = "title")
    String title;

    @Field(value = "description")
    String description;

    @Field(value = "aclass")
    @ManyToOne
    Class aClass;

    @Field(value = "student")
    @ManyToOne
    Student student;

}
