package mk.ukim.finki.wp.project_v1.service.impl;

import mk.ukim.finki.wp.project_v1.model.Note;
import mk.ukim.finki.wp.project_v1.repository.NotesRepository;
import mk.ukim.finki.wp.project_v1.service.NotesService;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotesServiceImpl implements NotesService {


    private final NotesRepository notesRepository;

    public NotesServiceImpl(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @Override
    public List<Note> getAllNotes() {
        return notesRepository.getAllNotes();
    }

    @Override
    public Note save(Note note) {
        return notesRepository.save(note);
    }

    @Override
    public Page<Note> getAllNotes(int page, int size) {
        return getAllNotes(page, size);
    }

    @Override
    public Optional<Note> findById(String noteId) {
        return notesRepository.findById(noteId);
    }

    @Override
    public void deleteById(String noteId) {
        notesRepository.deleteById(noteId);
    }

    @Override
    public List<Note> getNotesByAClass(String classId) {
        return notesRepository.getNotesByAClass(classId);
    }

    @Override
    public Note updateNote(String id, String title, String description) {
        Note note = notesRepository.findById(id).orElseThrow(RuntimeException::new);
        note.setTitle(title);
        note.setDescription(description);
        notesRepository.save(note);
        return note;
    }

}
