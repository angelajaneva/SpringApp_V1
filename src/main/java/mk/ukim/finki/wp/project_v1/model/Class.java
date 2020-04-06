package mk.ukim.finki.wp.project_v1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Class {

    @Id
    @Column(name = "class_id")
    private String id;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "classes", fetch = FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Student> students;

//    @OneToMany
//    private List<Note> notes;
//    @OneToMany
//    private List<Question> questions;

}
