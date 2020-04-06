package mk.ukim.finki.wp.project_v1.model;

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

public class Student {

    @Id
    @Column(name = "student_id")
    private String id;
    private String firstName;
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Class> classes;

//    @OneToMany
//    private List<Note> notes;
//    @OneToMany
//    private List<Question> questions;

    public void addClass(Class aClass){
        this.getClasses().add(aClass);
        aClass.getStudents().add(this);
    }
}
