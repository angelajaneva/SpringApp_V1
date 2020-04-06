package mk.ukim.finki.wp.project_v1.repository.impl;

import mk.ukim.finki.wp.project_v1.model.Note;
import mk.ukim.finki.wp.project_v1.repository.NotesRepository;
import mk.ukim.finki.wp.project_v1.repository.jpa.JpaNotesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NotesRepositoryImpl implements NotesRepository {

    private final JpaNotesRepository jpaNotesRepository;

    public NotesRepositoryImpl(JpaNotesRepository jpaNotesRepository) {
        this.jpaNotesRepository = jpaNotesRepository;
    }

    @Override
    public List<Note> getAllNotes() {
        return jpaNotesRepository.findAll();
    }

    @Override
    public Note save(Note note) {
        return jpaNotesRepository.save(note);
    }

    @Override
    public Page<Note> getAllNotes(int page, int size) {
        return jpaNotesRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Optional<Note> findById(String noteId) {
        return jpaNotesRepository.findById(noteId);
    }

    @Override
    public void deleteById(String noteId) {
        jpaNotesRepository.deleteById(noteId);
    }

    @Override
    public List<Note> getNotesByAClass(String classId) {
        return jpaNotesRepository.getNotesByaClass_Id(classId);
    }
}
