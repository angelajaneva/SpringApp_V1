package mk.ukim.finki.wp.project_v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "reviews")
public class Review {

    @Id
    private String id;

    @Field(value = "text")
    private String text;

    @Field(value = "rated")
    private int rated;

    @Field(value = "student")
    private Student student;

    @Field(value = "aclass")
    private Class aClass;

    @Field(value = "createdOn")
    private LocalDate createdOn;

}
