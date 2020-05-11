package mk.ukim.finki.wp.project_v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "class")
public class Class {

    @Field(value = "id")
    private String id;

    @Field(value = "name")
    private String name;

    @Field(value = "students")
    private List<Student> students;

}
