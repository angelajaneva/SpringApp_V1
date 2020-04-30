package mk.ukim.finki.wp.project_v1.repository.mongo;

import mk.ukim.finki.wp.project_v1.model.Note;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;


public interface MongoNotesRepository extends ReactiveMongoRepository<Note, String> {

    Flux<Note> getNotesByaClass_Id(String classId);
}
