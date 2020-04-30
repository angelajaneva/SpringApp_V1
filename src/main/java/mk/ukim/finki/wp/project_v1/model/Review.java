package mk.ukim.finki.wp.project_v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "reviews")
public class Review {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Field(value = "text")
    private String text;

    @Field(value = "rated")
    private int rated;

    @Field(value = "student")
    @ManyToOne
    private Student student;

    //mi trebat site reviews za class, znaci vo Class kje stavam reviews
    @Field(value = "aclass")
    @ManyToOne
    private Class aClass;

    @Field(value = "createdOn")
    private LocalDate createdOn;

}
