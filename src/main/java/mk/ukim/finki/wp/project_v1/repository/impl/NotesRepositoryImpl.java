package mk.ukim.finki.wp.project_v1.repository.impl;

import mk.ukim.finki.wp.project_v1.model.Note;
import mk.ukim.finki.wp.project_v1.repository.NotesRepository;
import mk.ukim.finki.wp.project_v1.repository.mongo.MongoClassRepository;
import mk.ukim.finki.wp.project_v1.repository.mongo.MongoNotesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NotesRepositoryImpl implements NotesRepository {

    private final MongoNotesRepository mongoNotesRepository;

    public NotesRepositoryImpl(MongoNotesRepository mongoNotesRepository) {
        this.mongoNotesRepository = mongoNotesRepository;
    }

    @Override
    public List<Note> getAllNotes() {
        return mongoNotesRepository.findAll();
    }

    @Override
    public Note save(Note note) {
        return mongoNotesRepository.save(note);
    }

    @Override
    public Page<Note> getAllNotes(int page, int size) {
        return mongoNotesRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Optional<Note> findById(String noteId) {
        return mongoNotesRepository.findById(noteId);
    }

    @Override
    public void deleteById(String noteId) {
        mongoNotesRepository.deleteById(noteId);
    }

    @Override
    public List<Note> getNotesByAClass(String classId) {
        return mongoNotesRepository.getNotesByaClass_Id(classId);
    }
}
