package mk.ukim.finki.wp.project_v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Review {


    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private int rated;

    @ManyToOne
    private Student student;

    //mi trebat site reviews za class, znaci vo Class kje stavam reviews
    @ManyToOne
    private Class aClass;
    private LocalDate createdOn;
}
