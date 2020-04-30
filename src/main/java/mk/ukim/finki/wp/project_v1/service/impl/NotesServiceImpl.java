package mk.ukim.finki.wp.project_v1.service.impl;

import mk.ukim.finki.wp.project_v1.model.Note;
import mk.ukim.finki.wp.project_v1.repository.NotesRepository;
import mk.ukim.finki.wp.project_v1.service.NotesService;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotesServiceImpl implements NotesService {


    private final NotesRepository notesRepository;

    public NotesServiceImpl(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @Override
    public Flux<Note> getAllNotes() {
        return notesRepository.getAllNotes();
    }

    @Override
    public Mono<Note> save(Note note) {
        return notesRepository.save(note);
    }


    @Override
    public Mono<Note> findById(String noteId) {
        return notesRepository.findById(noteId);
    }

    @Override
    public Mono<Void> deleteById(String noteId) {
        return notesRepository.deleteById(noteId);
    }

    @Override
    public Flux<Note> getNotesByAClass(String classId) {
        return notesRepository.getNotesByAClass(classId);
    }

    @Override
    public Mono<Note> updateNote(String id, String title, String description) {
        return notesRepository.findById(id).flatMap(note1 -> {
            note1.setTitle(title);
            note1.setDescription(description);
            return notesRepository.save(note1);
        });
    }

    @Override
    public Flux<Note> searchNotes(String term) {
        return this.getAllNotes()
                .filter(note -> note.getDescription().toLowerCase().contains(term)
                        || note.getTitle().contains(term));
    }
}
