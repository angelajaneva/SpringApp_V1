package mk.ukim.finki.wp.project_v1.repository.jpa;

import mk.ukim.finki.wp.project_v1.model.Class;
import mk.ukim.finki.wp.project_v1.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface JpaNotesRepository extends JpaRepository<Note, String> {


//    @Query("select n from Note n where n.AClass like :name")
     List<Note> getNotesByaClass_Id(String classId);

}
