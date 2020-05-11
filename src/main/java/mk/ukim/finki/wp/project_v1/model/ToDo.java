package mk.ukim.finki.wp.project_v1.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "todo")
public class ToDo {

    @Id
    private String id;

    @Field(value = "date")
    private LocalDate date;

    @Field(value = "text")
    private String text;

    @Field(value = "completed")
    private boolean completed;

    @Field(value = "user")
    private User user;

}
