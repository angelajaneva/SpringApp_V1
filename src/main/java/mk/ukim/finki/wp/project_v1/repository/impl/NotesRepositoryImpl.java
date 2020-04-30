package mk.ukim.finki.wp.project_v1.repository.impl;

import mk.ukim.finki.wp.project_v1.model.Note;
import mk.ukim.finki.wp.project_v1.repository.NotesRepository;
import mk.ukim.finki.wp.project_v1.repository.mongo.MongoNotesRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class NotesRepositoryImpl implements NotesRepository {

    private final MongoNotesRepository mongoNotesRepository;

    public NotesRepositoryImpl(MongoNotesRepository mongoNotesRepository) {
        this.mongoNotesRepository = mongoNotesRepository;
    }

    @Override
    public Flux<Note> getAllNotes() {
        return mongoNotesRepository.findAll();
    }

    @Override
    public Mono<Note> save(Note note) {
        return mongoNotesRepository.save(note);
    }

    @Override
    public Mono<Note> findById(String noteId) {
        return mongoNotesRepository.findById(noteId);
    }

    @Override
    public Mono<Void> deleteById(String noteId) {
        return mongoNotesRepository.deleteById(noteId);
    }

    @Override
    public Flux<Note> getNotesByAClass(String classId) {
        return mongoNotesRepository.getNotesByaClass_Id(classId);
    }
}
