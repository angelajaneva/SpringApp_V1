package mk.ukim.finki.wp.project_v1.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Note {

    @Id
    @Column(name = "note_id")
    String id;
    String title;
    String description;

    @ManyToOne
    Class aClass;
    @ManyToOne
    Student student;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note)) return false;
        Note note = (Note) o;
        return id.equals(note.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
