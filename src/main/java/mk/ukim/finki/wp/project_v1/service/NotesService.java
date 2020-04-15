package mk.ukim.finki.wp.project_v1.service;

import mk.ukim.finki.wp.project_v1.model.Note;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface NotesService {

    List<Note> getAllNotes();

    Note save(Note note);

    Page<Note> getAllNotes(int page, int size);

    Optional<Note> findById(String noteId);

    void deleteById(String noteId);

    List<Note> getNotesByAClass(String AClass);

    Note updateNote(String id, String title, String description);

    List<Note> searchNotes (String term);
}
