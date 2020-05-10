package mk.ukim.finki.wp.project_v1.service.impl;

import mk.ukim.finki.wp.project_v1.model.Class;
import mk.ukim.finki.wp.project_v1.model.Note;
import mk.ukim.finki.wp.project_v1.repository.ClassRepository;
import mk.ukim.finki.wp.project_v1.repository.NotesRepository;
import mk.ukim.finki.wp.project_v1.service.NotesService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class NotesServiceImpl implements NotesService {


    private final NotesRepository notesRepository;
    private final ClassRepository classRepository;

    public NotesServiceImpl(NotesRepository notesRepository, ClassRepository classRepository) {
        this.notesRepository = notesRepository;
        this.classRepository = classRepository;
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

    @Override
    public Mono<Note> createNote(String title, String description, String classId) {
        Note note = new Note();
        return classRepository.findById(classId).flatMap(aClass -> {
            note.setTitle(title);
            note.setDescription(description);
            note.setAClass(aClass);
            return notesRepository.save(note);
        });

    }
}
