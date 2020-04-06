package mk.ukim.finki.wp.project_v1.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ToDo {

    @Id
    @Column(name = "todoId")
    private String id;
    private LocalDate date;
    private String text;
    private boolean completed;
}
