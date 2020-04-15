package mk.ukim.finki.wp.project_v1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "class")
public class Class {

    @Id
    @Field
    private String id;

    @Field(value = "name")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "classes", fetch = FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    @Field(value = "students")
    private List<Student> students;

//    @OneToMany
//    private List<Note> notes;
//    @OneToMany
//    private List<Question> questions;

}
