package mk.ukim.finki.wp.project_v1.repository.mongo;

import mk.ukim.finki.wp.project_v1.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoNotesRepository extends MongoRepository<Note, String> {


//    @Query("select n from Note n where n.AClass like :name")
     List<Note> getNotesByaClass_Id(String classId);

}
