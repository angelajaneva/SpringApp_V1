package mk.ukim.finki.wp.project_v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "students")
public class Student {

    @Field(value = "id")
    @Id
    private String id;

    @Field(value = "firstName")
    private String firstName;

    @Field(value = "lastName")
    private String lastName;

    @Field(value = "classes")
    @ManyToMany(fetch = FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Class> classes;

    @Field(value = "username")
    private String username;


//    @OneToMany
//    private List<Note> notes;
//    @OneToMany
//    private List<Question> questions;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
