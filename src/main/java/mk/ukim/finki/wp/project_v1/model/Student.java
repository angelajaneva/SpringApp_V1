package mk.ukim.finki.wp.project_v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "students")
public class Student {

    @Id
    @Field(value = "id")
    private String id;

    @Field(value = "firstName")
    private String firstName;

    @Field(value = "lastName")
    private String lastName;

    @Field(value = "classes")
    private List<Class> classes;

    @Field(value = "username")
    private String username;


}
